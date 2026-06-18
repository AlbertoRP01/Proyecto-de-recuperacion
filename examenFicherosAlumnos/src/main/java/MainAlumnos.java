import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainAlumnos {

    // Ruta base donde se organizarán todos los logs procesados
    public final static Path RUTA_DESTINO = Path.of("./logs_procesados");

    // Patrón robusto para identificar ficheros de log con el formato: server{N}_app{N}.log
    private static final Pattern patron = Pattern.compile("^server\\d+_app\\d+\\.log$");

    // Patrón para parsear líneas de log de la app1
    private final static Pattern patronLogApp1 = Pattern.compile("^(?<fecha>\\d{4}/\\d{2}/\\d{2}) (?<hora>\\d{2}:\\d{2}:\\d{2}) - \\[(?<nivel>\\w+)\\] - (?<mensaje>.*)$");

    // Patrón para parsear líneas de log de la app2
    private final static Pattern patronLogApp2 = Pattern.compile("^\\[(?<fecha>\\d{2}-\\d{2}-\\d{4})\\|(?<hora>\\d{2}:\\d{2}:\\d{2})\\] <(?<nivel>\\w+)> (?<mensaje>.*)$");

    public static void main(String[] args) {
        GeneradorLogsExamen.execute();
        eliminarDirectorioRecursivo(RUTA_DESTINO);

        Path carpetaRaiz = Path.of("./entorno_examen_logs");
        organizaCaosLogs(carpetaRaiz);
    }

    private static void organizaCaosLogs(Path carpetaRaiz) {
        List<DetalleError> todosLosErrores = new ArrayList<>();
        List<Path> ficherosValidos;

        // Paso 1: Leemos y cerramos el stream rápido guardando las rutas en memoria.
        // Esto evita que Files.move corrompa la lectura del stream de Files.walk.
        try (Stream<Path> stream = Files.walk(carpetaRaiz)) {
            ficherosValidos = stream.filter(Files::isRegularFile)
                    .filter(path -> patron.matcher(path.getFileName().toString()).matches())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error al explorar la carpeta raíz: " + e.getMessage());
            return;
        }

        // Paso 2: Procesamos la lista fija de archivos de forma segura
        for (Path path : ficherosValidos) {
            try {
                String nombreDelArchivo = path.getFileName().toString();
                String[] partes = nombreDelArchivo.split("_");
                String servidor = partes[0];
                String app = partes[1].replace(".log", "");

                Path rutaDestino = RUTA_DESTINO.resolve(servidor).resolve(app).resolve(nombreDelArchivo);

                Files.createDirectories(rutaDestino.getParent());
                Files.move(path, rutaDestino);

                Pattern patronLogActual = null;
                if (app.equalsIgnoreCase("app1")) {
                    patronLogActual = patronLogApp1;
                } else if (app.equalsIgnoreCase("app2")) {
                    patronLogActual = patronLogApp2;
                }

                if (patronLogActual != null) {
                    List<DetalleError> erroresDeEsteFichero = buscarErrores(rutaDestino, patronLogActual, servidor, app);
                    todosLosErrores.addAll(erroresDeEsteFichero);
                }

            } catch (Exception e) {
                System.out.println("Error procesando archivo " + path.getFileName() + ": " + e.getMessage());
            }
        }

        // Paso 3: Guardamos el reporte único final
        escribirErrorAFichero(todosLosErrores);
    }

    private static List<DetalleError> buscarErrores(Path p, Pattern logPattern, String server, String app) throws LogException {
        try (Stream<String> stream = Files.lines(p)) {
            return stream.map(logPattern::matcher)
                    .filter(matcher -> matcher.matches() && matcher.group("nivel").equalsIgnoreCase("Error"))
                    .map(matcher -> new DetalleError(
                            matcher.group("fecha"),
                            matcher.group("hora"),
                            server,
                            app,
                            matcher.group("mensaje")
                    ))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new LogException("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void escribirErrorAFichero(List<DetalleError> errores) {
        Path archivoReporte = RUTA_DESTINO.resolve("reporte_errores.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (BufferedWriter writer = Files.newBufferedWriter(archivoReporte)) {
            gson.toJson(errores, writer);
            System.out.println("✅ Reporte global de errores generado con éxito en: " + archivoReporte.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("❌ No se pudo escribir el archivo de reporte JSON: " + e.getMessage());
        }
    }

    private static void eliminarDirectorioRecursivo(Path ruta) {
        if (Files.exists(ruta)) {
            try (Stream<Path> walk = Files.walk(ruta)) {
                walk.sorted(java.util.Comparator.reverseOrder())
                        .forEach(p -> {
                            try {
                                Files.delete(p);
                            } catch (IOException e) {
                                System.err.println("No se pudo borrar: " + p + " -> " + e.getMessage());
                            }
                        });
                System.out.println("Carpeta de destino limpia.");
            } catch (IOException e) {
                System.err.println("Error al intentar limpiar el directorio: " + e.getMessage());
            }
        }
    }
}
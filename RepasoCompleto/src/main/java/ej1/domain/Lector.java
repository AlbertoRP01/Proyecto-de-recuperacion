package ej1.domain;

import ej1.Entidad;
import ej1.models.Morador;
import ej1.models.Mutante;
import mientradasalida.MiEntradaSalida;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

public class Lector {
    static void main(String[] args) {
        cargarCenso("src/main/java/ej1/censo/censo.txt");

    }

    public static void cargarCenso(String ruta) {
        ArrayList<Entidad> lista = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;

            // ABRE EL WHILE
            while ((linea = br.readLine()) != null) {

                // Todo esto ocurre DENTRO del bucle por cada línea del fichero
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String tipo = partes[0].trim();
                    String nombre = partes[1].trim();

                    if (tipo.equalsIgnoreCase("Morador")) {
                        lista.add(new Morador(nombre));
                    } else if (tipo.equalsIgnoreCase("Mutante")) {
                        lista.add(new Mutante(nombre));
                    }
                }

            } // AQUÍ SE CIERRA EL WHILE (Fíjate que antes lo tenías cerrado arriba)

            // Una vez que el archivo se ha leído por completo, imprimimos la lista
            System.out.println("--- EMITIENDO SONIDOS DEL CENSO (CON BUFFER) ---");
            for (Entidad e : lista) {
                System.out.println(e.getNombre() + " dice " + e.emitirSonido());
            }

        } catch (IOException e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
    }
}

package mientradasalida;

import java.time.DateTimeException;
import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MiEntradaSalida {
    private static Scanner sc = new Scanner(System.in);

    /**
     * Lee un entero mostrando el mensaje pasado como parámetro
     *
     * @param mensaje El mensaje a mostrar
     * @return el entero leído por teclado
     */

    public static int leerEntero(String mensaje) {
        System.out.println(mensaje);
        return Integer.parseInt(sc.nextLine());
    }

    /**
     *
     * @param mensaje el mensaje a mostrar
     * @return el enetero leido por teclado
     */
    public static int leerEnteroPositivo(String mensaje) {
        System.out.println(mensaje);
        int a = Integer.parseInt(sc.nextLine());
        while (a < 0) {
            System.out.println("El  numero tiene que ser  positivo: ");
            a = Integer.parseInt(sc.nextLine());
        }
        return a;
    }

    /**
     *
     * @param mensaje // el mensaje que tengas que introducir
     * @return devuelve el numero decimal
     */
    public static double solicitarDouble(String mensaje) {
        double decimal = 0.0;
        boolean flag = true;

        while (flag) {
            System.out.println(mensaje);
            try {
                // 🎯 Usamos Double.parseDouble(sc.nextLine())
                decimal = Double.parseDouble(sc.nextLine());
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Debe introducir un número válido. Utiliza el PUNTO '.' como separador decimal.");
            }
        }
        return decimal;
    }
    public static float solicitarFloat(String mensaje) {
        float numero = 0.0f;
        boolean flag = true;

        while (flag) {
            System.out.println(mensaje);
            try {
                numero = Float.parseFloat(sc.nextLine()); // Lee un número float
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe introducir un número válido (entero o decimal).");
                sc.nextLine(); // Limpiar el buffer para evitar bucle infinito
            }
        }

        return numero;
    }
    /**
     *
     * @param mensaje
     * @param min     rango minimo
     * @param max     rango maximo
     * @return devuelve el numero
     */
    public static int leeEnteroRango(String mensaje, int min, int max) throws MiEntradaSalidaException {
        if (min > max) {
            //mostrar error
            throw new MiEntradaSalidaException("El minimo es mayor que el maximo");
        }
        int num = leerEntero(mensaje);
        while (num < min || num > max) {
            System.out.printf("El numero está fuera del rango %d -%d", min, max);
            num = leerEntero(mensaje);
        }
        return num;
    }

    /**
     *
     * @param mensaje mostando un mensaje que escriba
     * @return devuelve la cadena y la trnasforma en mayuscula
     */
    public static String solicitarCadena(String mensaje) {
        String cadena = "";
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while (flag) {
            // Pedimos el string por pantalla.
            System.out.println(mensaje);

            // 3. Usamos .trim() para eliminar espacios en blanco al inicio y al final.
            cadena = sc.nextLine().trim();

            // Comprobamos que la cadena no esté vacía después de quitarle los espacios.
            if (!cadena.isEmpty()) {
                // Si llegamos hasta aquí, el dato es correcto.
                flag = false;
            } else {
                // 2. Mensaje de error específico.
                System.out.println("Error: No puede introducir una cadena vacía.");
            }
        }

        return cadena;
    }

    /**
     *
     * @param min              el rango mas pequeño
     * @param max              el rango maximo
     * @param seAceptaElMaximo ¿El maximo entra en ese intervalo?
     * @return el numero que genera aleatoriamente
     */
    public static int generaAleatorioEntre(int min, int max, boolean seAceptaElMaximo) {
        int ventana;

        if (seAceptaElMaximo) {
            ventana = max - min + 1;

        } else {
            ventana = max - min;

        }
        return (int) (Math.random() * ventana) + min;
    }

    /**
     * TODO: Vamos a imprimir una matriz de manera ordenada por espacios tanto la columna como la fila
     * @param matriz variable en el parametro
     */
    public static void imprimirUnaMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%3d ", matriz[i][j]); //  damos 3 espacios  para los numeros negativos dentro de la matriz de esta forma es más ordenado
            }
            System.out.println();
        }
    }
    public static char solicitarCaracterSN(String mensaje) {
        char c = '0';
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while (flag) {
            // Pedimos el carácter por pantalla.
            System.out.println(mensaje);

            String cadena = sc.next();

            // Comprobamos que la longitud sea de 1 solo carácter.
            if (cadena.length() == 1) {
                c = cadena.toUpperCase().charAt(0);

                // Comprobamos si es S o N.
                if (c == 'S' || c == 'N') {
                    // Si llegamos hasta aquí, el dato es correcto.
                    flag = false;
                } else {
                    // 2. Mensaje de error específico (carácter incorrecto).
                    System.out.println("Error: Respuesta no válida. Debe introducir 'S' o 'N'.");
                }
            } else {
                // 2. Mensaje de error específico (longitud incorrecta).
                System.out.println("Error: Debe introducir un solo carácter ('S' o 'N').");
            }
        }

        return c;
    }

    public static char solicitarCaracter(String mensaje) {
        char c = '0';
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while (flag) {
            // Pedimos el carácter por pantalla.
            System.out.println(mensaje);

            try {
                // Obtenemos el primer carácter de la línea.
                c = sc.next().charAt(0);
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto.
                flag = false;
            }
            // Si se lanza la excepción (porque el usuario no escribió nada).
            catch (StringIndexOutOfBoundsException e) { // Es más específico que IndexOutOfBoundsException
                // 2. Mensaje de error específico.
                System.out.println("Error: No ha introducido ningún carácter. Inténtelo de nuevo.");
            }

        }

        return c;
    }

    public static Year solicitarYear(String mensaje) {
        Year year = null;
        boolean flag = true;

        while (flag) {
            System.out.println(mensaje);
            try {
                int valor = sc.nextInt();  // leer el año como número entero
                year = Year.of(valor);    // convertirlo a Year
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe introducir un año válido (solo números).");
                sc.nextLine(); // limpiar buffer
            } catch (DateTimeException e) {
                System.out.println("Error: Año fuera de rango permitido.");
            }
        }

        return year;
    }
    public static void main(String[] args) {
        int a = MiEntradaSalida.leerEnteroPositivo("Introduce un numero");
        System.out.printf("Numero introducido es %d", a);
    }

}
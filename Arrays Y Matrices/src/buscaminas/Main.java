package buscaminas;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Matriz oculta (terreno real)
        int[][] mapaOculto = new int[5][5];

        // Matriz visible (interfaz del jugador)
        char[][] mapaVisible = new char[5][5];

        // Inicializamos y generamos las matrices
        imprimirMatriz(mapaOculto, false, mapaVisible); // Rellena con '?'
        System.out.println(); // Salto de línea estético
        imprimirMatriz(mapaOculto, true, mapaVisible);  // Rellena con 0 y 1 de fondo

        int vidas = 3;

        // Bucle principal del juego
        while (vidas > 0) {
            System.out.println("Introduce fila (0-4):");
            int fila = sc.nextInt();

            System.out.println("Introduce columna (0-4):");
            int columna = sc.nextInt();

            // SOLUCIÓN: Validar que el usuario no se salga del mapa
            if (fila < 0 || fila >= 5 || columna < 0 || columna >= 5) {
                System.out.println("Coordenadas incorrectas. Intenta de nuevo.");
                continue; // Vuelve al inicio del bucle
            }

            // Escaneamos la posición elegida
            escanearMatriz(mapaOculto, mapaVisible, fila, columna);

            // Si encuentra un mutante, pierde una vida.
            if (mapaOculto[fila][columna] == 1) {
                vidas--;
                System.out.println("¡Mutante encontrado!");
                System.out.println("Vidas restantes: " + vidas);
            }

            // Mostrar tablero actualizado
            System.out.println("\nTABLERO:");
            for (int i = 0; i < mapaVisible.length; i++) {
                for (int j = 0; j < mapaVisible[i].length; j++) {
                    System.out.print(mapaVisible[i][j] + " "); // Espacio extra para que sea más legible
                }
                System.out.println();
            }
        }

        System.out.println("GAME OVER");
    }

    public static void imprimirMatriz(int[][] mapaOculto, boolean generar, char[][] mapaVisible) {
        for (int i = 0; i < mapaOculto.length; i++) {
            for (int j = 0; j < mapaOculto[i].length; j++) {
                if (generar) {
                    mapaOculto[i][j] = (int) (Math.random() * 2);
                } else {
                   mapaVisible[i][j] = '?';
                    System.out.print(mapaVisible[i][j] + " ");
                }
            }
            if (!generar) {
                System.out.println();
            }
        }
    }

    public static void escanearMatriz(int[][] matrizOculta, char[][] matrizVisible, int fila, int columna) {
        if (matrizOculta[fila][columna] == 1) {
            matrizVisible[fila][columna] = 'M';
        } else {
            System.out.println("¡Terreno seguro!");

            // SOLUCIÓN: Llamamos al método, que ahora DEVUELVE un entero con el conteo
            int mutantesCerca = casillasAdyacentes(matrizOculta, fila, columna);

            // SOLUCIÓN: Convertimos el int a char y lo guardamos en la matriz visible
            matrizVisible[fila][columna] = (char) (mutantesCerca + '0');
        }
        // SOLUCIÓN: Eliminado el bucle for gigante que recorría toda la matriz sin sentido aquí.
    }

    public static int casillasAdyacentes(int[][] matrizOculta, int fila, int columna) {
        int contador = 0;

        /*
         * SOLUCIÓN PRO: Bucle para revisar las 8 casillas de alrededor.
         * En vez de escribir 8 'if', iteramos desde -1 hasta +1 tanto en filas como en columnas.
         */
        for (int f = -1; f <= 1; f++) {
            for (int c = -1; c <= 1; c++) {

                // Ignorar la propia casilla en la que estamos parados (cuando el desvío es 0,0)
                if (f == 0 && c == 0) continue;

                int nuevaFila = fila + f;
                int nuevaColumna = columna + c;

                // Comprobar que la nueva posición existe (no nos salimos por los bordes)
                if (nuevaFila >= 0 && nuevaFila < matrizOculta.length &&
                        nuevaColumna >= 0 && nuevaColumna < matrizOculta[0].length) {

                    // Si dentro del límite hay un 1, sumamos al contador
                    if (matrizOculta[nuevaFila][nuevaColumna] == 1) {
                        contador++;
                    }
                }
            }
        }

        // El método ahora termina devolviendo el resultado numérico
        return contador;
    }

    public static void levantarCasillaOculta(char[][] matrizVisible, int[][] matrizInvisible) {
        for (int i = 0; i < matrizVisible.length; i++) {
            for (int j = 0; j < matrizVisible[i].length; j++) {
                if (matrizVisible[i][j] != '?') {
                    System.out.println("Esta coordenada se ha elegido antes");
                } else {
                    matrizVisible[i][j] = (char) (matrizInvisible[i][j] + '0');
                }
            }
        }
    }
}
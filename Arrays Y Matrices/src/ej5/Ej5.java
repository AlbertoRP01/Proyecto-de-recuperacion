package ej5;

public class Ej5 {
    static void main(String[] args) {
        int[][] matriz = new int[6][6];
        int mayor = 0;
        imprimirMatriz(matriz);
        int tamanoSubcuadricula = 3;
        int filaLimite = matriz.length - tamanoSubcuadricula;
        int columnaLimite = matriz.length - tamanoSubcuadricula;
        for (int i = 0; i <= filaLimite; i++) {
            for (int j = 0; j <= columnaLimite; j++) {

                int sumaActual = 0;

                // BUCLES INTERNOS: Suman siempre EXACTAMENTE 3 filas y 3 columnas
                // a partir de la coordenada de anclaje (i, j).
                for (int f = i; f < i + tamanoSubcuadricula; f++) {
                    for (int c = j; c < j + tamanoSubcuadricula; c++) {
                        sumaActual += matriz[f][c];
                    }
                }

                // Aquí comprobarías si 'sumaActual' es la mayor que has visto hasta ahora.
                if (sumaActual > mayor){
                    mayor = sumaActual;

                }
            }
        }
        System.out.println(mayor);
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random() * 100);
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

    }
}
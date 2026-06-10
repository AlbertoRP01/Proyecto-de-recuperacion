package ej2;

public class Ej2 {
    public static void main() {
        int[][] matriz = {
                {  5,  -3,   8,   0},
                { -12,  7,  -4,   9},
                {  2,   0, -15,   6},
                { -8,  11,   3,  -1}
        };
        System.out.println(sumaMatriz(matriz));
    }

    public static int sumaMatriz(int[][] matriz) {
        int total = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] < 0) {
                    total += matriz[i][j] * -1;
                } else {
                    total += matriz[i][j];
                }
            }
        }
        return total;
    }
}

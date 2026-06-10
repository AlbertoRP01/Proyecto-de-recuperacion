package ej3;

public class Ej3 {


    public static void main(String[] args) {

        // Matriz de 4x4 que representa los sensores
        boolean[][] sensores = {
                {false, false, true, false},
                {true, true, true, true}, // <- ¡Alerta! Esta fila está comprometida
                {false, false, false, false},
                {true, false, false, true}
        };

        // 1. Probando el conteo de intrusos
        int totalIntrusos = contarIntrusos(sensores);
        System.out.println("Sensores activados en total: " + totalIntrusos);
        // Debería imprimir: 7

        // 2. Probando la alerta de bloqueo
        boolean bloquearSector = alertaBloqueo(sensores);

        if (bloquearSector) {
            System.out.println("¡PROTOCOLO DE BLOQUEO ACTIVADO! Fila comprometida.");
        } else {
            System.out.println("El sector es seguro. No es necesario bloquear.");
        }
    }

    private static boolean alertaBloqueo(boolean[][] sensores) {
        for (boolean[] sensore : sensores) {
            int contador = 0;

            for (boolean b : sensore) {
                if (b) {
                    contador++;
                }
            }
            if (contador == sensore.length) {
                return true;
            }
        }
        return false;
    }

    private static int contarIntrusos(boolean[][] sensores) {
        int totalDeSensores = 0;
        for (int i = 0; i < sensores.length; i++) {
            for (int j = 0; j < sensores[i].length; j++) {
                if (sensores[i][j]) {
                    totalDeSensores++;
                }
            }
        }
        return totalDeSensores;
    }
}
// ========================================================
// DESARROLLA TUS MÉTODOS AQUÍ DEBAJO
// ========================================================
    
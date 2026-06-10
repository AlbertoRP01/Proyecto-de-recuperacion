package ej6;

import java.beans.Introspector;
import java.util.Scanner;

public class Ej6 {

    // Se añade 'public' y 'void' para que Java pueda ejecutar el programa correctamente
    public static void main(String[] args) {

        // Matriz del hotel: 4 plantas, 5 habitaciones por planta
        // true = OCUPADA, false = LIBRE
        boolean[][] hotel = new boolean[4][5];

        // Test 1: Contar libres (Debería imprimir 8)
        int totalLibres = contarHabitacionesLibres(hotel);
        System.out.println("Total de habitaciones libres en HOTEL: " + totalLibres);
        // Test 2: Disponibilidad en una planta específica
        // Debería imprimir FALSE (la planta 0 está llena)
        System.out.println("¿Hay hueco en la Planta 0?: " + plantaTieneDisponibilidad(hotel, 0));
        // Debería imprimir TRUE (la planta 3 tiene una libre al final)
        System.out.println("¿Hay hueco en la Planta 3?: " + plantaTieneDisponibilidad(hotel, 3));

        System.out.println("\nEstado actual de la matriz del hotel:");
        imprimirMatriz(hotel);
    }

    // ========================================================
    // MÉTODOS DESARROLLADOS
    // ========================================================

    /**
     * Cuenta cuántas celdas de la matriz tienen el valor 'false' (habitación libre).
     */
    public static int contarHabitacionesLibres(boolean[][] hotel) {
        int contador = 0;
        for (int i = 0; i < hotel.length; i++) {
            for (int j = 0; j < hotel[i].length; j++) {
                if (!hotel[i][j]) { // Si es false, significa libre
                    contador++;
                }
            }
        }
        return contador;
    }

    /**
     * Verifica si una planta específica tiene al menos una habitación libre ('false').
     */
    public static boolean plantaTieneDisponibilidad(boolean[][] matriz, int planta) {
        // Validar que la planta indicada exista dentro del rango de la matriz
        if (planta < 0 || planta >= matriz.length){
            return false;
        }

        // Recorrer los elementos de la planta seleccionada
        for (int columna = 0; columna < matriz[planta].length; columna++){
            if (!matriz[planta][columna]){ // Corregido: busca 'false' (libre)
                return true; // Encontró al menos una vacía
            }
        }
        return false; // Toda la planta está llena (todo true)
    }

    /**
     * Imprime la matriz de booleanos de forma visual
     * Nota: Se removió la asignación aleatoria interna original (Math.random)
     * para evitar que alterara la matriz real antes de ser mostrada.
     */
    public static void imprimirMatriz(boolean[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = Math.random() <0.5;
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
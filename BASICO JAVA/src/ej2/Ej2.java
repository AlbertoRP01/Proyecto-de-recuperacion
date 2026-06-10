package ej2;

import java.util.Scanner;

public class Ej2 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecciona una opcion");
        int opcion =  Integer.parseInt(sc.nextLine());
        String resultado = switch (opcion) {
            case 1 -> "Habitaciones";
            case 2 -> "Zonas comunes";
            case 3 -> "Piscina";
            case 4 -> "Exteriores";
            default -> "Opcion no valida de 1-4";
        };
        System.out.println(resultado);
    }
}
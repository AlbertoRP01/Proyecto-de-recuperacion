package ej1;

import java.util.Scanner;

public class Ej1 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el precio del articulo");
        double precio1 = Double.parseDouble(sc.nextLine());
        System.out.println("Introduce el precio del articulo");
        double precio2 = Double.parseDouble(sc.nextLine());
        System.out.println("Introduce el codigo de descuento");
        char codigoDescuento = sc.nextLine().charAt(0);
        if (codigoDescuento == 'D') {
            double precioTotal = precio1 + precio2;
            double descuento = precioTotal * 0.1;
            double resultado = precioTotal - descuento;
            System.out.printf("precio total es %.2f", resultado);
        } else {
            double precioTotal = precio1 + precio2;
            System.out.printf("El precio total es %.2f ", precioTotal);
        }
    }
}

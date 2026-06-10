package ej3;

import java.util.Scanner;

public class Ej3 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dias = 0;
        int largos = 0;
        int largoTemporal = 0;
        while (largoTemporal>= 0) {
            System.out.println("Introduce un numero de largos");
            largoTemporal = Integer.parseInt(sc.nextLine());
            largos += largoTemporal;
            dias++;
        }
        System.out.println("dias entrnados "+ dias + " Largos " + largos);
    }
}

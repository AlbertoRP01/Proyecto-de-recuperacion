package ej4;

import java.util.Scanner;

public class Ej4 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el salario bruto");
        double salarioBruto = Double.parseDouble(sc.nextLine());
        System.out.println("Introduce el porcentaje de IRPF");
        int irpf = Integer.parseInt(sc.nextLine());
        System.out.println("El salario neto es de  " + calcularSalarioNeto(salarioBruto, irpf));
    }

    private static double calcularSalarioNeto(double salarioBruto, int irpf) {
        double rentencion = salarioBruto * (irpf / 100.0);
        return salarioBruto - rentencion;
    }
}

package ej1;

public class Ej1 {
    static void main(String[] args) {
        double[] temperaturas = {12.5, -2.0, 5.4, -5.3, 0.0, 8.1};
        int dias = 0;
        System.out.println("Los dias registrados a baja temperaturas en los parques nacionales stavanger son: " + registrarTemperaturaDias(temperaturas, dias));
        System.out.println("Los dias registrados a baja temperatura en los parques nacionales stavanger son " + registrarTemperaturaDias2(temperaturas, dias));
    }

    private static int registrarTemperaturaDias(double[] temperaturas, int dias) {
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] < 0) {
                dias++;
            }
        }
        return dias;
    }

    private static int registrarTemperaturaDias2(double[] temperaturas, int dias) {

        for (double temperatura : temperaturas) {
            if (temperatura < 0) {
                dias++;
            }
        }
        return dias;
    }
}

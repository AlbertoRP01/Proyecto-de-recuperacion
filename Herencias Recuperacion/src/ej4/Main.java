package ej4;

public class Main {
    static void main(String[] args) {
        PasaporteSalud pasaporteSalud = new PasaporteSalud();
        pasaporteSalud.imprimirCabecera();
        pasaporteSalud.exportarPdf();
        pasaporteSalud.enviarDatosApi();

        System.out.println("-----------------------------------");

        PasaporteSalud segundoPasaporte = new PasaporteSalud();
        segundoPasaporte.imprimirCabecera();
        segundoPasaporte.exportarPdf();
        segundoPasaporte.enviarDatosApi();
    }

}

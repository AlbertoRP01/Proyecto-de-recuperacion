package ej4;

public class PasaporteSalud extends DocumentoMedico implements Exportable, SincronizableOMS {

    public PasaporteSalud() {
        super();
    }

    @Override
    public void exportarPdf() {
        System.out.println("Exportando el pasaporte de salud del paciente " + getPacienteId() + " a formato PDF");
    }

    @Override
    public void enviarDatosApi() {
        System.out.println("Sincronizando de forma segura los datos del paciente " + getPacienteId() + " con la API de la OMS (CIE-11).");
    }


}

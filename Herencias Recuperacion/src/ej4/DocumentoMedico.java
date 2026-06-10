package ej4;

public abstract class DocumentoMedico {
    private static int contadorId = 0;
    private int pacienteId;

    public DocumentoMedico() {
       contadorId ++;
       this.pacienteId = contadorId;

    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public void imprimirCabecera(){
        System.out.println("=== DOCUMENTO MÉDICO ===");
        System.out.println("ID Paciente: " + pacienteId);
    }

}

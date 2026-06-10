package ej1;

public class SobreMesa extends Ordenador{
    protected String formatoTorre;

    public SobreMesa(String marca, int memoriaRam, String formatoTorre) {
        super(marca, memoriaRam);
        this.formatoTorre = formatoTorre;
    }
}

package ej1;

public abstract class Entidad {
    private String nombre;

    public Entidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public abstract String emitirSonido();

}

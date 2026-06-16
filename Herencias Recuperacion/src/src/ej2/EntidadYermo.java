package ej2;

public abstract class EntidadYermo {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public EntidadYermo(String nombre) {
        this.nombre = nombre;
    }

    public abstract void atacar(String nombre);


}

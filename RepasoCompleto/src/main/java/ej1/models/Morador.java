package ej1.models;

import ej1.Entidad;

public class Morador extends Entidad {

    public Morador(String nombre) {
        super(nombre);
    }

    @Override
    public String emitirSonido() {
        return "¡Por el refugio!";
    }
}

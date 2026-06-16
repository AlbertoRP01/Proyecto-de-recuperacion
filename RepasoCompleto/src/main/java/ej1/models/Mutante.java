package ej1.models;

import ej1.Entidad;

public class Mutante extends Entidad {
    public Mutante(String nombre) {
        super(nombre);
    }

    @Override
    public String emitirSonido() {
        return "¡Aplastar!";
    }
}

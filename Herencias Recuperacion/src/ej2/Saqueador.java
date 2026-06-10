package ej2;

public class Saqueador extends EntidadYermo {
    public Saqueador(String nombre) {
        super(nombre);
    }

    @Override
    public void atacar(String nombre) {
        System.out.println("El saqueador " + nombre + " dispara su rifle de tubo");
    }

}

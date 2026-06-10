package ej2;

public class  Sanguinario extends EntidadYermo {
    public Sanguinario(String nombre) {
        super(nombre);
    }

    @Override
    public void atacar(String nombre) {
        System.out.println("El sanguinario " + nombre + " ataca con sus garras ignorando la armadura");
    }

}

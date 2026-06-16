package ej2;

public class Main {
    static void main(String[] args) {
        Sanguinario sanguinario = new Sanguinario("Paco");
        Saqueador saqueador = new Saqueador("Jose");

        System.out.println("___ prueba saqueador ___");
        saqueador.atacar(saqueador.getNombre());

        System.out.println("___ Prueba Sanguinario ___");
        sanguinario.atacar(sanguinario.getNombre());
    }


}

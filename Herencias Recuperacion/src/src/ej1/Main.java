package ej1;

public class Main {
    static void main(String[] args) {
        Portatil miPortatil = new Portatil("Lenovo LOQ",  16, 6);
        SobreMesa sobreMesa = new SobreMesa("Custom PC", 32, "ATX");

        System.out.println("\n___ Probando Sobremesas ___");

        miPortatil.encender();
        miPortatil.mostarBarria();

        System.out.println("\n___ Probando Sobremesa___");
        sobreMesa.encender();
    }




}

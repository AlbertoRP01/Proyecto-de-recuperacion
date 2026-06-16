package ej1;

public class Portatil extends Ordenador {
    protected int autonomiaBateria;

    public Portatil(String marca, int memoriaRam, int autonomiaBateria) {
        super(marca, memoriaRam);
        this.autonomiaBateria = autonomiaBateria;
    }
    public void mostarBarria(){
        System.out.println("Autonomia restante: " + autonomiaBateria + " horas");
    }


}

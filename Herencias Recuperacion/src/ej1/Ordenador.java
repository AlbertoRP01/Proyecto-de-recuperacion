package ej1;

public abstract class Ordenador {
        protected String marca;
        protected int memoriaRam;

    public Ordenador(String marca, int memoriaRam) {
        this.marca = marca;
        this.memoriaRam = memoriaRam;
    }
    public  void encender(){
        System.out.println("iniciando sistema con " + memoriaRam + " GB " + " de RAM" );
    }
}

package el_cadete_y_el_comandante;

public  class Soldado {
    private int puntosDeVida;

    public Soldado(int puntosDeVida) {
        this.puntosDeVida = puntosDeVida;
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }


     public void atacar() {
        System.out.println("Ataque media distancia");
    }


}


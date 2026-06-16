package el_cadete_y_el_comandante;

public class Francotirador extends Soldado {
    public Francotirador(int puntosDeVida) {
        super(puntosDeVida);
    }

    @Override
    public void atacar() {
        System.out.println("Ataque a distancia larga");
        super.atacar();
    }

}

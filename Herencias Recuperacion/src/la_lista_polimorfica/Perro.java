package la_lista_polimorfica;

public class Perro extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("guau, guau, guau");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Perro:\n");
        return sb.toString();
    }

}

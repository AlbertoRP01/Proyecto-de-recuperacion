package la_lista_polimorfica;

public class Gato extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("miau, miau, miau");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gato:\n");
        return sb.toString();
    }

}

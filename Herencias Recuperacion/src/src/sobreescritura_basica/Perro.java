package sobreescritura_basica;

public class Perro extends Animal{
    @Override
    public void hacerSonido() {
        System.out.println("guau, guau, guau");
    }

}

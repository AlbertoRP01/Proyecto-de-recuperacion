package abstraccion_geometrica;

public class Circulo extends Figura{
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return this.radio = Math.PI * Math.pow(radio,2);
    }

}

package abstraccion_geometrica;

public class Main {
    public static void main(String[] args) {
        Figura cuadrado = new Cuadrado(20.4);
        Figura circulo = new Circulo(15.3);

        System.out.println("El area calculada del circulo es de " + circulo.calcularArea());
        System.out.println("El area calculado del cuadrado es de " + cuadrado.calcularArea());
    }

}

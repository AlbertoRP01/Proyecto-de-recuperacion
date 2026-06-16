package especializacion_con_instanceof;

public class Coche extends Vehiculo {
    private int numeroPuertas;

    public Coche(String marca, int velocidadMax, int numeroPuertas) {
        super(marca, velocidadMax);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Coche:\n")
                .append("Marca: ").append(getMarca() + "\n")
                .append("Numero de puertas: ").append(getNumeroPuertas() + "\n")
                .append("Velocidad Maxima: ").append(getVelocidadMax() + "\n");
        return sb.toString();
    }

}

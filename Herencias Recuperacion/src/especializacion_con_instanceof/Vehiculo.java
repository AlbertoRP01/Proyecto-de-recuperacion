package especializacion_con_instanceof;

public class Vehiculo {
    private String marca;
    private int velocidadMax;

    public Vehiculo(String marca, int velocidadMax) {
        this.marca = marca;
        this.velocidadMax = velocidadMax;
    }

    public String getMarca() {
        return marca;
    }

    public int getVelocidadMax() {
        return velocidadMax;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehiculo:").append("\n")
                .append("marca:\t").append(getMarca()).append("\n")
                .append("velocidad maxima\t").append(getVelocidadMax() + ".");
        return sb.toString();
    }

}

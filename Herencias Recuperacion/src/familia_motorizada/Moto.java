package familia_motorizada;

public class Moto extends Vehiculo{
    private boolean tieneSidecar;

    public Moto(String marca, int velocidadMax, boolean tieneSidecar) {
        super(marca, velocidadMax);
        this.tieneSidecar = tieneSidecar;
    }

    public boolean isTieneSidecar() {
        return tieneSidecar;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Moto:\n")
                .append("Marca: ").append(getMarca()+ "\n")
                .append("tieneSidecar= ").append(isTieneSidecar());
        return sb.toString();
    }

}

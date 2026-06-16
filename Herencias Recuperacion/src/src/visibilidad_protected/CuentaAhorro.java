package visibilidad_protected;

public class CuentaAhorro extends CuentaBancaria {

    public CuentaAhorro(double saldo) {
        super(saldo);
    }
    public void aplicarIntereses(){
        this.saldo = saldo * 1.05;
        System.out.printf("Saldo tras aplicar intereses: %.2f€%n", saldo);
    }


}

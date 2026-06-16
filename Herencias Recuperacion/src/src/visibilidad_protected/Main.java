package visibilidad_protected;

public class Main {
    public static void main(String[] args) {
        CuentaAhorro miCuenta = new CuentaAhorro(1000.0);

        System.out.println("Saldo inicial: " + miCuenta.getSaldo() + "€");

        // Aplicamos el 5% de interés
        miCuenta.aplicarIntereses();

    }


}

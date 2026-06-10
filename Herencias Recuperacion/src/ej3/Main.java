package ej3;

public class Main {
    static void main() {

        PagoTarjeta pagoTarjeta = new PagoTarjeta();
        PagoEfectivo pagoEfectivo = new PagoEfectivo();
        cobrarEstancia(pagoTarjeta,40 );
        cobrarEstancia(pagoEfectivo, 50);
    }
    public static void cobrarEstancia(ProcesadorPago pago, double total){
        pago.preocesarPago(total);
    }

}

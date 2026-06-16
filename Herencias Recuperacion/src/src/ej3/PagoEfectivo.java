package ej3;

public class
PagoEfectivo  implements ProcesadorPago{


    @Override
    public boolean preocesarPago(double cantidad) {
        System.out.println("toma el cambio "+ cantidad);
        return true;

    }

}

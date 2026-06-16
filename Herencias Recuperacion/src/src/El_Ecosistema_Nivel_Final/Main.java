package El_Ecosistema_Nivel_Final;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Creamos el ArrayList polimórfico (puede almacenar cualquier hijo de Producto)
        ArrayList<Producto> carrito = new ArrayList<>();

        // Llenamos el carrito con diferentes tipos de productos
        carrito.add(new Electronica("Auriculares Bluetooth", 50.0));   // IVA 21% -> 60.5
        carrito.add(new Alimentacion("Pack Leche de Avena", 6.0));       // IVA 4%  -> 6.24
        carrito.add(new Libro("El nombre del viento", 22.0));          // IVA 0%  -> 22.0
        carrito.add(new Electronica("Teclado Mecánico", 80.0));       // IVA 21% -> 96.8

        double precioTotalCarrito = 0.0;

        System.out.println("=== DETALLE DEL CARRITO DE LA COMPRA ===");

        // Recorremos el carrito aplicando Polimorfismo puro
        for (Producto prod : carrito) {
            double precioFinalProducto = prod.calcularPrecioFinal();
            precioTotalCarrito += precioFinalProducto;

            // Mostramos el desglose de cada producto formateando a dos decimales
            System.out.printf("- %s | Precio Base: %.2f€ | Precio con IVA: %.2f€%n",
                    prod.getNombre(), prod.getPrecioBase(), precioFinalProducto);
        }


        System.out.println("========================================");
        System.out.printf("TOTAL A PAGAR (Impuestos incluidos): %.2f€%n", precioTotalCarrito);
    }
}
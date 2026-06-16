package El_Ecosistema_Nivel_Final;

// Clase Electronica (21% de IVA)
class Electronica extends Producto {
    public Electronica(String nombre, double precioBase) {
        super(nombre, precioBase);
    }

    @Override
    public double calcularPrecioFinal() {
        return this.precioBase * 1.21; // Multiplicar por 1.21 añade el 21%
    }
}

// Clase Alimentacion (4% de IVA)
class Alimentacion extends Producto {
    public Alimentacion(String nombre, double precioBase) {

        super(nombre, precioBase);
    }

    @Override
    public double calcularPrecioFinal() {
        return this.precioBase * 1.04; // Añade el 4%


    }
}

// Clase Libro (0% de IVA)
class Libro extends Producto {
    public Libro(String nombre, double precioBase) {

        super(nombre, precioBase);
    }

    @Override
    public double calcularPrecioFinal() {
        return this.precioBase; // No se aplican impuestos
    }
}
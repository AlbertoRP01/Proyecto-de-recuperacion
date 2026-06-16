package El_Ecosistema_Nivel_Final;
public abstract class Producto {
    protected String nombre;
    protected double precioBase;

    public Producto(String nombre, double precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    // Método abstracto que cada subclase DEBE implementar
    public abstract double calcularPrecioFinal();

    // Getters básicos
    public String getNombre() { return nombre; }
    public double getPrecioBase() { return precioBase; }

}
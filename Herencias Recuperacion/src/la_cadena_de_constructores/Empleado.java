package la_cadena_de_constructores;

public class Empleado extends Persona{
    private double sueldo;

    public Empleado(String nombre, double sueldo) {
        super(nombre);
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }


}

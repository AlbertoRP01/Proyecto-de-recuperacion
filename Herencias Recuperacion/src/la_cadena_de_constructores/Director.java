package la_cadena_de_constructores;

public class Director extends Empleado{
   private String departamento;

    public Director(String nombre, double sueldo, String departamento) {
        super(nombre, sueldo);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void mostrarDatos() {
        System.out.println("\n--- Datos del Director ---");
        System.out.println("Nombre (desde Persona): " + getNombre());
        System.out.println("Sueldo (desde Empleado): $" + getSueldo());
        System.out.println("Departamento (desde Director): " + getDepartamento());
    }

}

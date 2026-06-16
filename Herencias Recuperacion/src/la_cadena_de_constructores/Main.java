package la_cadena_de_constructores;

public class Main {
    public static void main(String[] args) {
        // 1. Creamos el objeto Director pasando los datos de los 3 niveles:
        // "Alejandro" -> Va para Persona (Abuelo)
        // 4500.50     -> Va para Empleado (Padre)
        // "I+D"       -> Se queda en Director (Hijo)
        Director director = new Director("Alejandro", 4500.50, "I+D");

        // 2. Llamamos al método que corregimos con los Getters para mostrar todo en consola
        director.mostrarDatos();
    }

}
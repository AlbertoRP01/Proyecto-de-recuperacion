package EXAMENFINAL;

/**
 * 📚 CHULETA DE EXAMEN: MÉTODOS PREDEFINIDOS Y ESTÁNDAR EN JAVA
 * * Este archivo contiene toda la teoría práctica y plantillas necesarias para superar
 * las preguntas del examen de Programación sobre la clase Object, herencia, la interfaz
 * Comparable, métodos default/static en interfaces y el operador instanceof.
 * * Código funcional listo para compilar, estudiar y reutilizar en tus exámenes.
 */

import java.util.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChuletaMetodosPredefinidos {


    public static void main(String[] args) {
        System.out.println("=== 📚 EJECUCIÓN DE PRUEBA DE LA CHULETA DE EXAMEN ===");

        // 1. Demostración de equals, hashCode y toString con herencia
        System.out.println("\n--- 1. Clase Object (toString, equals, hashCode) ---");
        Gerente g1 = new Gerente("Carlos García", "12345678A", 2500.0, "IT");
        Gerente g2 = new Gerente("Carlos García", "12345678A", 2500.0, "IT");

        System.out.println("Método toString() sobrescrito (Padre + Hijo):");
        System.out.println(g1);

        System.out.println("\n¿g1.equals(g2) por DNI?: " + g1.equals(g2));
        System.out.println("hashCode g1: " + g1.hashCode());
        System.out.println("hashCode g2: " + g2.hashCode());

        // 2. Demostración de la interfaz Comparable
        System.out.println("\n--- 2. Interfaz Comparable (Ordenación) ---");
        List<Jugador> equipo = new ArrayList<>();
        equipo.add(new Jugador("Zaira", 450));
        equipo.add(new Jugador("Alberto", 999));
        equipo.add(new Jugador("Mario", 720));

        System.out.println("Antes de ordenar (por orden alfabético definido en compareTo):");
        for (Jugador j : equipo) System.out.println("  " + j.getNombre() + " (" + j.getPuntuacion() + ")");

        Collections.sort(equipo); // Llama internamente al método compareTo()

        System.out.println("Después de ordenar:");
        for (Jugador j : equipo) System.out.println("  " + j.getNombre() + " (" + j.getPuntuacion() + ")");

        // 3. Métodos Modernos en Interfaces (Java 8+)
        System.out.println("\n--- 3. Métodos default y static en Interfaces ---");
        // Uso de método static de la interfaz (Directamente con el nombre de la interfaz)
        String dniPrueba = "12345678Z";
        boolean esValido = Validador.esDniValido(dniPrueba);
        System.out.println("¿Es válido el DNI '" + dniPrueba + "' usando método static?: " + esValido);

        // Uso de método default a través de un objeto que implementa la interfaz
        g1.configurarImpresora(); // Método abstracto implementado
        g1.imprimirAviso();       // Método default heredado automáticamente

        // 4. Herramientas del Sistema: instanceof
        System.out.println("\n--- 4. Operador instanceof (Listas Polimórficas) ---");
        List<Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(new Empleado("Ana López", "87654321B", 1800.0));
        listaEmpleados.add(g1); // Carlos García es Gerente, que hereda de Empleado

        for (Empleado emp : listaEmpleados) {
            System.out.println("Procesando a: " + emp.nombre);
            if (emp instanceof Gerente) {
                // Truco de examen: Comprobar el tipo real antes de castear de forma segura
                Gerente gerenteReal = (Gerente) emp;
                gerenteReal.repartirBono();
            } else {
                System.out.println("  Este empleado no es un Gerente, no tiene derecho a bono especial.");
            }
        }
    }
}

// ============================================================================
// 1. LOS REYES DE LA CLASE OBJECT & HERENCIA
// ============================================================================

class Empleado {
    protected String nombre;
    protected String dni;
    protected double sueldo;


    public Empleado(String nombre, String dni, double sueldo) {
        this.nombre = nombre;
        this.dni = dni;
        this.sueldo = sueldo;
    }

    // A) toString() en la clase Padre
    @Override
    public String toString() {
        return "Empleado: " + nombre + " [DNI: " + dni + "]";
    }

    // B) Plantilla oficial de equals(Object obj) - ¡APRÉNDETELA DE MEMORIA!
    @Override
    public boolean equals(Object obj) {
        // 1. ¿Son exactamente el mismo objeto en la misma posición de memoria?
        if (this == obj) return true;

        // 2. ¿El otro objeto es nulo o pertenece a una clase distinta?
        if (obj == null || this.getClass() != obj.getClass()) return false;

        // 3. Casteo (Conversión) seguro porque ya sabemos el tipo exacto
        Empleado otroEmpleado = (Empleado) obj;

        // 4. Comparación lógica de los atributos clave (en este caso, el DNI)
        // Nota: Para tipos primitivos usa == y para objetos (String) usa .equals()
        return this.dni != null && this.dni.equals(otroEmpleado.dni);
    }

    // C) Regla de Oro de hashCode()
    @Override
    public int hashCode() {
        // Obligatorio: si usas un atributo en equals(), úsalo en hashCode()
        return Objects.hash(dni);
    }
}

class Gerente extends Empleado implements Imprimible {
    private String departamento;


    public Gerente(String nombre, String dni, double sueldo, String departamento) {
        super(nombre, dni, sueldo); // Llamada obligatoria al constructor del padre
        this.departamento = departamento;
    }

    // Truco de examen en toString() con Herencia: usar super.toString()
    @Override
    public String toString() {
        // Reutilizamos el texto construido por el padre y le concatenamos lo del hijo
        return super.toString() + " - Sueldo: " + this.sueldo + "€ - Dept: " + this.departamento;
    }

    // Método específico de Gerente para la demostración de instanceof
    public void repartirBono() {
        System.out.println("  💰 ¡Éxito! Bono especial de Gerencia repartido para el departamento de " + departamento);
    }

    // Implementación obligatoria del método abstracto de la interfaz Imprimible
    @Override
    public void configurarImpresora() {
        System.out.println("  Configurando impresora multifunción para la planta de dirección.");
    }
}

// ============================================================================
// 2. LA INTERFAZ PREDEFINIDA ESTRELLA: Comparable<T>
// ============================================================================

class Jugador implements Comparable<Jugador> {
    private String nombre;
    private int puntuacion;


    public Jugador(String nombre, int puntuacion) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
    }

    public String getNombre() { return nombre; }
    public int getPuntuacion() { return puntuacion; }

    /**
     * Regla matemática de compareTo:
     * Devolver < 0 : 'this' va ANTES que 'otro' (Menor)
     * Devolver 0   : son IGUALES
     * Devolver > 0 : 'this' va DESPUÉS que 'otro' (Mayor)
     */
    @Override
    public int compareTo(Jugador otro) {
        // OPCIÓN A: Ordenar alfabéticamente por Nombre (A-Z)
        return this.nombre.compareTo(otro.nombre);

        // OPCIÓN B: Ordenar numéricamente por puntuación (Menor a Mayor)
        // Para usar esta opción, desmarca la línea de abajo y comenta la de arriba:
        // return Integer.compare(this.puntuacion, otro.puntuacion);

        // OPCIÓN C: Ordenar numéricamente INVERSO (Mayor a Menor)
        // return Integer.compare(otro.puntuacion, this.puntuacion);
    }
}

// ============================================================================
// 3. MÉTODOS MODERNOS EN INTERFACES (Java 8+)
// ============================================================================

interface Imprimible {
    // A) Método abstracto clásico (OBLIGATORIO sobrescribir en las clases)
    void configurarImpresora();


    // B) Método default (OPCIONAL de sobrescribir, ya lleva lógica integrada)
    default void imprimirAviso() {
        System.out.println("  [Aviso Default] Impresión iniciada con la configuración estándar del sistema.");
    }
}

interface Validador {
    // C) Método static (No se hereda por las clases, pertenece a la interfaz)
    static boolean esDniValido(String dni) {
        return dni != null && dni.length() == 9;
    }

}
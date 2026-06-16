package ej5;

import java.beans.Introspector;
import java.util.Scanner;

public class Main {
    private static  Scanner sc;
    static void main(String[] args) {
        sc  = new Scanner(System.in);
        int numeroHabitacion = 0;
        boolean esAsignado = false;
        Recepcionista recepcionista = new Recepcionista("Alvaro");
        Recepcionista recepcionista1 = new Recepcionista("María José");
        PersonalLimpieza personalLimpieza = new PersonalLimpieza("Eva");
        PersonalLimpieza personalLimpieza1 = new PersonalLimpieza("Luis");
        Empleado[] empleados = new Empleado[5];
        try {
            annadirEmpleado(empleados, recepcionista);
            annadirEmpleado(empleados, personalLimpieza1);
            annadirEmpleado(empleados, personalLimpieza);
            annadirEmpleado(empleados, recepcionista1);
        } catch (EmpleadoException e) {
            System.out.println(e.getMessage());
        }
        for (Empleado e : empleados ){
            if ( e instanceof Asignable a  ){
                esAsignado = true;
                System.out.println("Introduce el numero de la habitacion");
                numeroHabitacion = Integer.parseInt(sc.nextLine());
                System.out.println( "El id "+ e.getIdEmpleado() + " El empleado " + e.getNombreEmpleado() + " La tarea asignada es limpiar  la habitacion " + a.asignarHabitacion(numeroHabitacion));
                System.out.println("Introduce el numero de la habitacion");
                numeroHabitacion = Integer.parseInt(sc.nextLine());
                System.out.println("el id  " +e.getIdEmpleado() + "   El empleado " + e.getNombreEmpleado() + " La tarea asignada es limpiar  la habitacion " + a.asignarHabitacion(numeroHabitacion));
            }else {
                esAsignado = false;
            }
        }
    }

    public static void annadirEmpleado(Empleado[] empleados, Empleado empleado) throws EmpleadoException {
        // 1. Validar que el empleado recibido no sea nulo (la condición que faltaba)
        if (empleado == null) {
            throw new EmpleadoException("El empleado a añadir no puede ser nulo");
        }

        // Variable para controlar si encontramos espacio
        boolean insertado = false;

        // 2. Recorrer el array buscando un hueco libre
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i] == null) {
                empleados[i] = empleado;
                System.out.println("Empleado añadido");
                insertado = true;
                break; // Salimos del bucle inmediatamente al insertar
            }
        }

        // 3. Si terminó el bucle y no se insertó, significa que el array está lleno
        if (!insertado) {
            throw new EmpleadoException("La plantilla de empleados está llena");
        }
    }


}

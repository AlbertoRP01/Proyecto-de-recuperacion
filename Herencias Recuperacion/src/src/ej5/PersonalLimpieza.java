package ej5;

import ej4.SincronizableOMS;

public class PersonalLimpieza extends Empleado implements Asignable{
    public PersonalLimpieza(String nombreEmpleado) {
        super(nombreEmpleado);
    }

    @Override
    public  int asignarHabitacion(int numero) {

        return numero;
    }


}

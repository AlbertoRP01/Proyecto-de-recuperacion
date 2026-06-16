package ej5;

public abstract class Empleado {
    private static int contador = 0;
    private int idEmpleado;
    private String nombreEmpleado;

    public Empleado(String nombreEmpleado) {
        contador++;
        this.idEmpleado = contador;
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }


}

package ej4.model;

public class Paciente implements Comparable<Paciente> {
    private String id;
    private int edad;
    private int dosisVacuna;

    public Paciente(String id, int edad, int dosisVacuna) {
        this.id = id;
        this.edad = edad;
        this.dosisVacuna = dosisVacuna;
    }

    public String getId() {
        return id;
    }

    public int getEdad() {
        return edad;
    }

    public int getDosisVacuna() {
        return dosisVacuna;
    }


    @Override
    public int compareTo(Paciente o) {
        int resultado = 0;
        if (this.getDosisVacuna() == o.getDosisVacuna()) {
            if (this.edad > o.getEdad()) {
                resultado = 1;
            } else if (o.getEdad() > this.getEdad()) {
                resultado = -1;
            }
        } else {
            if (this.dosisVacuna < o.getDosisVacuna()) {
                resultado = 1;
            } else if (o.getDosisVacuna() < this.getDosisVacuna()) {
                resultado = -1;
            }
        }
        return resultado;
    }
}

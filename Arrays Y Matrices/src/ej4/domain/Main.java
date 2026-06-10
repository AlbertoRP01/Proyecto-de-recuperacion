package ej4.domain;

import ej4.model.Paciente;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static void main(String[] args) {
        Paciente[] pacientes = new Paciente[5];
        pacientes = new Paciente[]{
                new Paciente("PAC-01", 28, 1),
                new Paciente("PAC-02", 45, 2),
                new Paciente("PAC-03", 62, 3),
                new Paciente("PAC-04", 19, 1),
                new Paciente("PAC-05", 34, 2)

        };

        Arrays.sort(pacientes, Comparator.comparingInt(Paciente::getEdad));
        for (Paciente paciente : pacientes){

            System.out.println("Id " + paciente.getId()+ " Edad " + paciente.getEdad()+ " dosis de la vacuna " +paciente.getDosisVacuna());
        }
    }
}

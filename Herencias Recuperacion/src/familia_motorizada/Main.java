package familia_motorizada;

import java.util.Arrays;

public class Main {
    static void main(String[] args) {
        Vehiculo coche = new Coche("Toyota", 120, 4);
        Vehiculo moto = new Moto("Suzuki", 80, true);
        Vehiculo[] vehiculos = new Vehiculo[5];
        addVehiculo(vehiculos, coche);
        addVehiculo(vehiculos, moto);
       imprimirVehiculo(vehiculos);

    }

    public static void addVehiculo(Vehiculo[] vehiculos, Vehiculo vehioculo) {
        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] == null) {
                vehiculos[i] = vehioculo;
                System.out.println("Se ha añadido correctamente");
                return; // ◄ CRUCIAL: Detiene el método para que no llene todo el array
            }
        }
        System.out.println("El array está lleno, no se pudo añadir");
    }
    public static void imprimirVehiculo(Vehiculo[] vehiculos){
        for (int i = 0; i < vehiculos.length;  i++){
            if (vehiculos[i] != null) { // ◄ Evita imprimir las posiciones vacías
                System.out.print(vehiculos[i] + " ");
            }
        }
        System.out.println();
    }


}

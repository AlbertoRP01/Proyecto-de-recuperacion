package especializacion_con_instanceof;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        Vehiculo coche = new Coche("Toyota", 120, 4);
        Vehiculo moto = new Moto("Suzuki", 80, true);
        List<Vehiculo> vehiculos = new ArrayList<>();
        addVehiculo(vehiculos, coche);
        addVehiculo(vehiculos, moto);
        for (Vehiculo v : vehiculos) {
            if (v instanceof Moto) {
                System.out.println("Este vehiculo es una moto");
            }else {
                System.out.println("Este vehiculo no es una moto");
            }
        }

    }

    public static void addVehiculo(List<Vehiculo> vehiculos, Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }


}

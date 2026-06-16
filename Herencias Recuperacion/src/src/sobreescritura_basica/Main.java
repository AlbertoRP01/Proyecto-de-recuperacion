package sobreescritura_basica;

// Se eliminó el import de Vehiculo por no ser necesario aquí

public class Main {
    // CORRECCIÓN: Se añade 'public' para que el programa pueda ejecutarse
    public static void main(String[] args) {
        Animal perro = new Perro();
        Animal gato = new Gato();

        Animal[] animales = new Animal[5];

        addAnimales(animales, gato);
        addAnimales(animales, perro);

        System.out.println("\n--- Sonidos de los objetos individuales ---");
        gato.hacerSonido();
        perro.hacerSonido();

        System.out.println("\n--- Contenido del Array ---");
        imprimirAnimal(animales);
    }

    public static void addAnimales(Animal[] animales, Animal animal) {
        for (int i = 0; i < animales.length; i++) {
            if (animales[i] == null) {
                animales[i] = animal;
                System.out.println("Se ha añadido correctamente");
                return;
            }
        }
        System.out.println("El array está lleno, no se pudo añadir");
    }

    public static void imprimirAnimal(Animal[] animales){
        for (int i = 0; i < animales.length;  i++){
            if (animales[i] != null) {
                // Nota: Esto imprimirá la referencia en memoria o el método toString() si lo has sobrescrito en Animal
                System.out.print(animales[i] + " ");
            }
        }
        System.out.println();
    }

}
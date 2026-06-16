package la_lista_polimorfica;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    // CORRECCIÓN: Se añade 'public' para que el programa pueda ejecutarse
    public static void main(String[] args) {
        Animal perro = new Perro();
        Animal perro2 = new Perro();
        Animal gato = new Gato();
        Animal gato2 = new Gato();

        List<Animal> animales = new ArrayList<>();


        addAnimales(animales, gato);
        addAnimales(animales, perro);
        addAnimales(animales, perro2);
        addAnimales(animales, gato2);

        Collections.shuffle(animales);

        System.out.print("Lista desordenada: ");
        System.out.println(animales);
        System.out.println("--------------------------------");


        for (Animal a : animales){
            a.hacerSonido();
        }

    }

   public static void addAnimales(List<Animal> animales, Animal animal){
       animales.add(animal);
   }


}
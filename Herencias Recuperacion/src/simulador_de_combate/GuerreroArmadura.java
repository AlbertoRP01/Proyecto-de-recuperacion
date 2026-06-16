package simulador_de_combate;

public class GuerreroArmadura extends Personaje {

    public GuerreroArmadura(String nombre, int vida) {
        super(nombre, vida); // Llama al constructor de la clase padre (Personaje)
    }

    // Sobrescritura Avanzada: Modifica la lógica del daño
    @Override
    public void recibirDano(int dano) {
        // Reducimos el daño a la mitad mediante división entera
        int danoReducido = dano / 2;

        System.out.print("[ARMADURA] ¡La armadura de " + this.nombre + " absorbe parte del impacto! -> ");

        // Invocamos el comportamiento base utilizando 'super' pero pasándole el daño mitigado
        super.recibirDano(danoReducido);
    }


}
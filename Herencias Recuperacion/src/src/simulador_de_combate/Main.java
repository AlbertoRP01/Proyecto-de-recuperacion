package simulador_de_combate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIO DEL SIMULADOR DE COMBATE ===\n");

        // Creamos un personaje común y corriente
        Personaje villano = new Personaje("Orco Mutante", 100);

        // Creamos al guerrero con armadura
        Personaje guerrero = new GuerreroArmadura("Arthur", 100);

        System.out.println("--- Ronda 1: Ataque de 40 de daño global ---");
        // El orco recibirá los 40 puntos íntegros
        villano.recibirDano(40);

        // El guerrero activará su lógica sobrescrita y solo recibirá 20
        guerrero.recibirDano(40);

        System.out.println("\n--- Ronda 2: Ataque crítico de 60 de daño global ---");
        villano.recibirDano(60);
        guerrero.recibirDano(60);
    }


}
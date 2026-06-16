package el_cadete_y_el_comandante;

public class Main {
    public static void main(String[] args) {
        // 🪖 Creación de objetos usando polimorfismo
        Soldado soldadoComun = new Soldado(100);
        Soldado soldadoElite = new Francotirador(120);

        System.out.println("--- ⚔️ INICIO DEL COMBATE ⚔️ ---");

        // 1. Ataque del soldado común (ejecuta el método de la clase padre)
        System.out.println("\n[Acción del Soldado Común]:");
        soldadoComun.atacar();

        // 2. Ataque del soldado élite (ejecuta el método de la clase hija + padre)
        System.out.println("\n[Acción del Soldado Élite]:");
        soldadoElite.atacar();

        // 3. Uso correcto y elegante de 'instanceof' (Pattern Matching)
        System.out.println("\n[Verificación de Inteligencia]:");
        if (soldadoElite instanceof Francotirador f) {
            System.out.println("🎯 ¡Confirmado! El soldado de élite es un Francotirador.");
            // Aquí usaríamos métodos exclusivos de la variable 'f' si existieran
        }

        if (soldadoComun instanceof Francotirador) {
            // Este bloque no se ejecutará porque soldadoComun es solo un Soldado
        }
    }

}
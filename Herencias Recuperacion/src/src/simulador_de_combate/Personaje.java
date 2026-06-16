package simulador_de_combate;
public class Personaje {
    protected String nombre;
    protected int vida;

    public Personaje(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = vida;
    }

    // Método estándar: resta el daño directamente de la vida
    public void recibirDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) this.vida = 0; // Evitamos que la vida sea negativa

        System.out.println(this.nombre + " ha recibido " + dano + " puntos de daño. Vida restante: " + this.vida);
    }

    // Getters para comprobar el estado
    public String getNombre() { return nombre; }
    public int getVida() { return vida; }

}

import java.util.Random;

public class Pokemon {
    protected String nombre;
    protected int vida;
    protected Random azar = new Random();

    public Pokemon(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = vida;
    }

    public Pokemon() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Random getAzar() {
        return azar;
    }

    public void setAzar(Random azar) {
        this.azar = azar;
    }

    public void perderVida(int atacar) {
        vida -= atacar;
    }

    public boolean esCrictico() {
        int atacar = azar.nextInt(100);

        return atacar % 10 == 0;
    }

    public int atacar() {

        int ataque = azar.nextInt(21) + 20;
        if (esCrictico()) {
            System.out.println("El " + nombre + " ha conseguido un ataque critico ");
            ataque=(int)(ataque*1.5);
        }

        return ataque;
    }


}
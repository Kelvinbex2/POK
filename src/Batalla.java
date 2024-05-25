import java.util.ArrayList;
import java.util.List;

public class Batalla {
    protected List<Pokemon> pok;
    protected List<Jugador> jug;
    protected String nivel;

    public Batalla(String nivel) {
        this.pok = new ArrayList<>();
        this.jug = new ArrayList<>();
        this.nivel = nivel;
    }

    public List<Pokemon> getPok() {
        return pok;
    }

    public void setPok(List<Pokemon> pok) {
        this.pok = pok;
    }

    public List<Jugador> getJug() {
        return jug;
    }

    public void setJug(List<Jugador> jug) {
        this.jug = jug;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void crearJugad(Jugador jugador) {
        if (jug.size() < 2) {
            jug.add(jugador);
        }else{
            System.out.println("Solo puedes añadir dos jugadores");
        }
        
    }

    public void elminarJud(Jugador hJugador) {
        jug.remove(hJugador);
    }


    public void crearPok(Pokemon pokemon) {
        pok.add(pokemon);
    }


    public void eliminarPok(Pokemon pokemon) {
        pok.remove(pokemon);
    }
}

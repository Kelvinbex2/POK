import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static ArrayList<Batalla> batallas = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static Batalla ba;

    public static void main(String[] args) throws Exception {
        ba = new Batalla("Kelvin");
        batallas.add(ba);
        crearMenu();
    }

    public static void crearMenu() {

        int op = 0;
        do {
            System.out.print("1.Crear jugador\n2.Crear pok\n3.Eliminar Jug\n4.Elimnar Pok\n5.jugar\n0.Salri\nelegin: ");
            op = Entrada.leerEntero();
            switch (op) {
                case 1:
                    crearJugad();
                    break;
                case 2:
                    crearPok();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    jugar();
                    break;
                case 0:
                    System.out.println("Salindo!!!!!!!!!");
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (op != 0);
    }

    private static void crearPok() {
        System.out.print("1.Papa\n2.Sir\nelige: ");
        int opc = Entrada.leerEntero();

        Pokemon pokemon = FactoriaPokemon.factorPokemon(opc);

        System.out.print("Nombre: ");
        String nombre = Entrada.leerString();
        System.out.print("Vida: ");
        int vida = Entrada.leerEntero();
        pokemon.setNombre(nombre);
        pokemon.setVida(vida);
        ba.crearPok(pokemon);

    }

    private static void crearJugad() {
        System.out.print("1.Host\n2.Out\nElige: ");
        int opc = Entrada.leerEntero();

        Jugador jugador = FactoriaJug.crearJug(opc);

        System.out.print("Nombre: ");
        String nombre = Entrada.leerString();
        LocalDate date = creardate();

        jugador.setNombre(nombre);
        jugador.setFecha(date);
        ba.crearJugad(jugador);
    }

    public static LocalDate creardate() {
        System.out.print("YYYY: ");
        int anio = Entrada.leerEntero();
        System.out.print("MM: ");
        int mm = Entrada.leerEntero();
        System.out.print("DD: ");
        int dd = Entrada.leerEntero();

        return LocalDate.of(anio, mm, dd);
    }

    private static void jugar() {
        if (ba.getJug().size() < 2 || ba.getPok().isEmpty()) {
            System.out.println("No hay suficientes jugadores o Pokémon para comenzar la batalla.");
            return;
        }
    
        Jugador jugador1 = ba.getJug().get(0);
        Jugador jugador2 = ba.getJug().get(1);
    
        System.out.println("Comienza la batalla entre " + jugador1.getNombre() + " y " + jugador2.getNombre());
    
        Pokemon pokemonJugador1 = elegirPokemon(jugador1);
        Pokemon pokemonJugador2 = elegirPokemon(jugador2);
    
        System.out.println("El jugador " + jugador1.getNombre() + " ha seleccionado a " + pokemonJugador1.getNombre());
        System.out.println("El jugador " + jugador2.getNombre() + " ha seleccionado a " + pokemonJugador2.getNombre());
    
        // Inicia la batalla
        while (pokemonJugador1.getVida() > 0 && pokemonJugador2.getVida() > 0) {
            pausa();
            // Turno del jugador 1
            System.out.println(jugador1.getNombre() + " ataca a " + jugador2.getNombre());
            int damage1 = pokemonJugador1.atacar();
            pokemonJugador2.perderVida(damage1);
            System.out.println(jugador2.getNombre() + " tiene " + pokemonJugador2.getVida() + " puntos de vida.");
    
            if (pokemonJugador2.getVida() <= 0) {
                System.out.println(jugador2.getNombre() + " ha sido derrotado. ¡" + jugador1.getNombre() + " gana!");
                break;
            }
    
            pausa();
            // Turno del jugador 2
            System.out.println(jugador2.getNombre() + " ataca a " + jugador1.getNombre());
            int damage2 = pokemonJugador2.atacar();
            pokemonJugador1.perderVida(damage2);
            System.out.println(jugador1.getNombre() + " tiene " + pokemonJugador1.getVida() + " puntos de vida.");
    
            if (pokemonJugador1.getVida() <= 0) {
                System.out.println(jugador1.getNombre() + " ha sido derrotado. ¡" + jugador2.getNombre() + " gana!");
                break;
            }
        }
    }
    

    private static Pokemon elegirPokemon(Jugador jugador1) {
        System.out.print("Selecione un pokemon: \n");
        List<Pokemon> pokemons = ba.getPok();
        for (int i = 0; i < pokemons.size(); i++) {
            System.out.println((1 + i) + ". " + pokemons.get(i).getNombre());
        }

        int opc = 0;
        do {
            System.out.print("Elige un numero: ");
            opc = Entrada.leerEntero();
        } while (opc < 1 || opc > pokemons.size());

        return pokemons.get(opc - 1);
    }

    public static void pausa() {
        System.out.println("\n\t\t Pulsar para continuar\n");
        String teclado = "";
        teclado = sc.nextLine();
    }

}

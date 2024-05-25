
public class FactoriaPokemon {
    public static Pokemon factorPokemon(int opc) {
        switch (opc) {
            case 1:
                return new Papa();
            case 2:
                return new Sir();
            default:
                throw new IllegalArgumentException("Opción no válida");
        }
    }
    
}

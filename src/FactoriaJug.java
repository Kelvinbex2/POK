public class FactoriaJug {

    public static Jugador crearJug(int opc) {

        switch (opc) {
            case 1:
                return new Host();
            case 2:
                return new Out();

            default:
            throw new IllegalArgumentException("Opción no válida");
        }

    }
}

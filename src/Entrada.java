import java.util.Scanner;

public class Entrada {
    static Scanner sc = new Scanner(System.in);

    public static String leerString() {
        String opc = "";
        try {
            opc = sc.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return opc;
    }

    public static int leerEntero() {
        int opc = 0;
        try {
            opc = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Error" + e);
        } finally {
            sc.nextLine();/// para limpiar el buffer
        }

        return opc;
    }

}

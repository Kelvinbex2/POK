import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Jugador {
    protected String nombre;
    protected String id;
    protected LocalDate fecha; // para generar el id

    public Jugador(String nombre, LocalDate fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.id = generarId();

    }

    public Jugador() {
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String generarId() {
        String[] a = nombre.split(" ");
        String id = a[a.length - 1];
        String ids = id.substring(0, Math.min(id.length(), 4));

        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = fecha.format(dt);

        return ids + "-" + date;
    }

    

}

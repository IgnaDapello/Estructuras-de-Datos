/**
 * Representa un equipo en un torneo con nombre y puntaje.
 */
public class Equipo {
    private String nombre;
    private int puntaje;
    private Equipo siguiente;

    /**
     * Constructor para la clase Equipo.
     *
     * @param nombre  Nombre del equipo.
     * @param puntaje Puntaje del equipo.
     */
    public Equipo(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.siguiente = null;
    }

    /**
     * Obtiene el nombre del equipo.
     *
     * @return El nombre del equipo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el puntaje del equipo.
     *
     * @return El puntaje del equipo.
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * Obtiene el siguiente equipo en la secuencia.
     *
     * @return El siguiente equipo.
     */
    public Equipo getSiguiente() {
        return siguiente;
    }

    /**
     * Establece el siguiente equipo en la secuencia.
     *
     * @param siguiente El siguiente equipo.
     */
    public void setSiguiente(Equipo siguiente) {
        this.siguiente = siguiente;
    }
}

/**
 * Clase principal que demuestra el uso de la TablaPosiciones.
 */
public class Main {
    public static void main(String[] args) {
        // Crear una instancia de la TablaPosiciones
        TablaPosiciones tabla = new TablaPosiciones();

        // Insertar equipos de prueba
        insertarEquiposDePrueba(tabla);

        // Ordenar y mostrar la tabla de posiciones utilizando diferentes algoritmos
        System.out.println("Tabla de Posiciones (Ordenada por QuickSort):");
        tabla.ordenarTablaPosiciones();
        tabla.mostrarTablaPosiciones();

        System.out.println("\nTabla de Posiciones (Ordenada por Selección):");
        tabla.ordenarPorSeleccion();
        tabla.mostrarTablaPosiciones();

        System.out.println("\nTabla de Posiciones (Ordenada por Burbuja):");
        tabla.ordenarPorBurbuja();
        tabla.mostrarTablaPosiciones();

        // Mantener la consola abierta para ver la salida
        esperarEntradaUsuario();
    }

    /**
     * Inserta equipos de prueba en la tabla de posiciones.
     *
     * @param tabla La tabla de posiciones.
     */
    private static void insertarEquiposDePrueba(TablaPosiciones tabla) {
        tabla.insertarEquipo("Inter de Miami", 15);
        tabla.insertarEquipo("Aldosivi", 10);
        tabla.insertarEquipo("River", 20);
        tabla.insertarEquipo("Real Madrid", 18);
        tabla.insertarEquipo("Platense", 8);
        tabla.insertarEquipo("Nueva Chicago", 12);
        tabla.insertarEquipo("Central Cordoba", 7);
    }

    /**
     * Espera la entrada del usuario para mantener la consola abierta.
     */
    private static void esperarEntradaUsuario() {
        System.out.println("Presiona Enter para salir...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

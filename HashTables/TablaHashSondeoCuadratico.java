
package hashtables.hashtables;

public class TablaHashSondeoCuadratico {
    private Integer[] tabla; // Matriz que almacena valores enteros (int)

    // Constructor de la clase
    public TablaHashSondeoCuadratico(int tamano) {
        tabla = new Integer[tamano];
    }

    // Insertar un valor en la tabla hash con manejo de colisiones mediante sondeo
    // cuadrático.
    public void insertar(int valor) {
        int indice = funcionHash(valor);
        int i = 1;
        while (tabla[indice] != null) {
            indice = (indice + i * i) % tabla.length; // Sondeo Cuadrático
            i++;
        }
        tabla[indice] = valor;
        System.out.println("Inserción exitosa. Valor: " + valor);
    }

    // Buscar un valor en la tabla hash con manejo de colisiones mediante sondeo
    // cuadrático.
    public boolean buscar(int valor) {
        int indice = funcionHash(valor);
        int indiceInicial = indice;
        int i = 1;
        while (tabla[indice] != null) {
            if (tabla[indice] == valor) {
                System.out.println("Búsqueda exitosa. Valor encontrado: " + valor);
                return true;
            }
            indice = (indice + i * i) % tabla.length;
            i++;
            if (indice == indiceInicial) {
                break;
            }
        }
        System.out.println("Búsqueda fallida. Valor no encontrado: " + valor);
        return false;
    }

    private int funcionHash(int valor) {
        // Se calcula tomando el valor modulo el tamaño de la tabla que verifica que el
        // índice esté dentro del
        return valor % tabla.length;
    }

    // Eliminar un valor de la tabla hash con sondeo cuadrático.
    public void eliminar(int valor) {
        // Calcula el índice inicial usando la función hash
        int indice = funcionHash(valor);
        int indiceInicial = indice;
        int i = 1;
        while (tabla[indice] != null) {
            if (tabla[indice] == valor) {
                tabla[indice] = null;
                System.out.println("Eliminación exitosa. Valor eliminado: " + valor);
                return;
            }
            indice = (indice + i * i) % tabla.length;
            i++;
            if (indice == indiceInicial) {
                break;
            }
        }
        System.out.println("Eliminación fallida. Valor no encontrado: " + valor);
    }
}
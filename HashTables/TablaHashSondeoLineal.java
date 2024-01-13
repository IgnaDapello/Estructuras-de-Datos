package hashtables.hashtables;

public class TablaHashSondeoLineal {
    private Integer[] tabla; // Matriz que almacena valores enteros

    // Constructor de la clase.
    public TablaHashSondeoLineal(int tamano) {
        // Recibe el tamaño deseado para la tabla hash y crea una matriz de ese tamaño.
        tabla = new Integer[tamano];
    }

    // Insertar un valor en la tabla hash con manejo de colisiones mediante sondeo
    // lineal.
    public void insertar(int valor) {
        int indice = funcionHash(valor);
        // Calcula el índice utilizando una función hash
        while (tabla[indice] != null) {
            indice = (indice + 1) % tabla.length; // Sondeo Lineal
        }
        tabla[indice] = valor;
        System.out.println("Inserción exitosa. Valor: " + valor);
    }

    public boolean buscar(int valor) {
        int indice = funcionHash(valor);
        int indiceInicial = indice;
        while (tabla[indice] != null) {
            if (tabla[indice] == valor) {
                System.out.println("Búsqueda exitosa. Valor encontrado: " + valor);
                return true;
            }
            indice = (indice + 1) % tabla.length;
            if (indice == indiceInicial) {
                break;
            }
        }
        System.out.println("Búsqueda fallida. Valor no encontrado: " + valor);
        return false;
    }

    // Calcula el índice de la tabla hash para un valor dado.
    private int funcionHash(int valor) {
        // Se calcula tomando el valor modulo el tamaño de la tabla
        return valor % tabla.length;
    }

    // Permite eliminar un valor de la tabla hash con manejo de colisiones mediante
    // sondeo lineal.
    public void eliminar(int valor) {
        int indice = funcionHash(valor);
        int indiceInicial = indice;
        // Si el contenedor correspondiente está ocupado, realiza un sondeo lineal
        // para buscar y eliminar el valor.
        while (tabla[indice] != null) {
            if (tabla[indice] == valor) {
                tabla[indice] = null;
                System.out.println("Eliminación exitosa. Valor eliminado: " + valor);
                return;
            }
            indice = (indice + 1) % tabla.length;
            if (indice == indiceInicial) {
                break;
            }
        }
        System.out.println("Eliminación fallida. Valor no encontrado: " + valor);
    }
}
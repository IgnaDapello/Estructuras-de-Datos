package hashtables.hashtables;

import java.util.LinkedList;

public class TablaHashAbierto {

    private LinkedList<Integer>[] tabla; // matriz de listas enlazadas

    // constructor de la clase.
    public TablaHashAbierto(int tamano) {
        // Recibe el tamaño deseado para la tabla hash y crea una matriz de listas
        // enlazadas con ese tamaño.
        tabla = new LinkedList[tamano];
        for (int i = 0; i < tamano; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    // permite insertar un valor en la tabla hash.
    public void insertar(int valor) {
        int indice = funcionHash(valor);
        tabla[indice].add(valor);
    }

    // buscar un valor en la tabla hash.
    public boolean buscar(int valor) {
        int indice = funcionHash(valor);
        return tabla[indice].contains(valor);
    }

    // método privado que calcula el índice de la tabla hash para un valor dado.
    private int funcionHash(int valor) {
        return valor % tabla.length;
    }

    // eliminar un valor de la tabla hash.
    public void eliminar(int valor) {
        int indice = funcionHash(valor);
        // calcula el índice utilizando la función hash y luego verifica si el valor se
        // encuentra en la lista enlazada correspondiente.
        if (tabla[indice].contains(valor)) {
            tabla[indice].remove(Integer.valueOf(valor)); // Si lo encuentra, lo elimina de la lista.
        }
    }

    // Método para imprimir la tabla hash
    public void imprimirTabla() {
        for (int i = 0; i < tabla.length; i++) {
            System.out.print("Índice " + i + ": ");
            for (int valor : tabla[i]) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }
}

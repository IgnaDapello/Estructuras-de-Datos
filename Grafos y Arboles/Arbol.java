package tp1taller2;

import java.util.HashSet;
import java.util.Set;

public class Arbol {

    private int[][] matriz;
    private ArbolNodo raiz;

    // Constructor de la clase Arbol
    public Arbol(int raiz, int[][] matriz) {
        this.matriz = matriz;
        boolean[] verticeUsado = new boolean[this.matriz.length];

        // Inicializa el arreglo verticeUsado para llevar un seguimiento de los vértices visitados
        for (int i = 0; i < this.matriz.length; i++) {
            verticeUsado[i] = false;
        }

        this.raiz = new ArbolNodo(raiz);
        verticeUsado[raiz] = true;
        Set<ArbolNodo> nodos = new HashSet<>();
        nodos.add(this.raiz);

        // Inicia el procesamiento del árbol
        this.procesarArbol(nodos, verticeUsado);
    }

    // Método privado para procesar el árbol de forma recursiva
    private void procesarArbol(Set<ArbolNodo> nodos, boolean[] verticeUsado) {
        Set<ArbolNodo> nodosTemp = new HashSet<>();

        for (ArbolNodo nodo : nodos) {
            for (int i = 0; i < this.matriz.length; i++) {
                if (this.matriz[nodo.getValor()][i] != 0 && !verticeUsado[i]) {
                    nodosTemp.add(nodo.insertarHojas(i));
                    verticeUsado[i] = true;
                }
            }
        }

        // Si hay nodos temporales, continúa procesando el árbol
        if (!nodosTemp.isEmpty()) {
            this.procesarArbol(nodosTemp, verticeUsado);
        }
    }

    // Método público para imprimir el árbol
    public void imprimirArbol() {
        System.out.println("Árbol de Rutas:");

        if (raiz != null) {
            imprimirArbol(raiz, 0);
        } else {
            System.out.println("El árbol está vacío.");
        }
    }

    // Método privado para imprimir el árbol de forma recursiva
    private void imprimirArbol(ArbolNodo nodo, int nivel) {
        // Indentación para visualizar la jerarquía del árbol
        for (int i = 0; i < nivel; i++) {
            System.out.print("  ");
        }

        // Imprimir información del nodo actual
        System.out.println(nodo);

        // Imprimir los hijos recursivamente
        for (ArbolNodo hijo : nodo.obtenerHojas()) {
            imprimirArbol(hijo, nivel + 1);
        }
    }
}
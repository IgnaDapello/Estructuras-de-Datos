package tp1taller2;

import java.util.ArrayList;
import java.util.List;

public class ArbolNodo {

    private int valor; // Valor del nodo
    private List<ArbolNodo> hojas; // Lista de nodos hijos

    // Constructor de la clase ArbolNodo
    public ArbolNodo(int valor) {
        this.valor = valor; // Inicializa el valor del nodo
        this.hojas = new ArrayList<>(); // Inicializa la lista de nodos hijos
    }

    // Método para insertar un nuevo nodo hijo y devolverlo
    public ArbolNodo insertarHojas(int valor) {
        ArbolNodo nodo = new ArbolNodo(valor);
        this.hojas.add(nodo); // Agrega el nuevo nodo a la lista de nodos hijos
        return nodo; // Devuelve el nodo recién creado
    }

    // Método para obtener la lista de nodos hijos
    public List<ArbolNodo> obtenerHojas() {
        return this.hojas;
    }

    // Método para obtener el valor del nodo
    public int getValor() {
        return valor;
    }

    // Método toString para representar el nodo como una cadena
    @Override
    public String toString() {
        return "Nodo " + (valor + 1);
    }
}
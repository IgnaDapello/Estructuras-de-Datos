package tp1taller2;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Grafos {

    private final int numVertices; // Número de vértices en el grafo
    public int[][] grafo; // Matriz de adyacencia para representar el grafo

    // Constructor de la clase Grafo
    public Grafos(int numVertices) {
        this.numVertices = numVertices; // Inicializa el número de vértices
        this.grafo = new int[numVertices][numVertices]; // Inicializa la matriz de adyacencia
        inicializarGrafo();
    }

    private void inicializarGrafo() {
        for (int i = 0; i < numVertices; i++) {
            Arrays.fill(grafo[i], 0);
        }
    }

    // Método para ingresar una arista al grafo con peso
    public void ingresarArista(int v1, int v2, int peso) {
        if (validarVertices(v1, v2)) {
            grafo[v1][v2] = peso;
        } else {
            System.out.println("Error: Vértices no válidos.");
        }
    }

    // Método para imprimir el grafo
    public void imprimirGrafo() {
        String ANSI_GRAY = "\u001B[47m"; // Código ANSI para el color de fondo gris
        String ANSI_RESET = "\u001B[40m"; // Restablecer el color de fondo a negro

        // Imprime los encabezados de las columnas (nombres de los vértices)
        System.out.printf(ANSI_GRAY + "\td%d", 1);
        for (int i = 1; i < grafo.length; i++) {
            System.out.printf("\td%d", i + 1);
        }
        System.out.println(ANSI_RESET);

        // Imprime la matriz de adyacencia
        for (int i = 0; i < grafo.length; i++) {
            System.out.printf(ANSI_GRAY + "d%d\t" + ANSI_RESET, i + 1);
            for (int j = 0; j < grafo[i].length; j++) {
                System.out.printf("%d\t", grafo[i][j]);
            }
            System.out.println();
        }
    }

    // Método para obtener la matriz de adyacencia
    public int[][] obtenerMatrizAdyacencia() {
        return grafo.clone();
    }

    // Método para encontrar el camino mínimo sin peso desde un vértice dado
    public void caminoMinimoSinPeso(int num) {
        int[] distancia = new int[this.numVertices];
        boolean[] verticeUsado = new boolean[this.numVertices];

        for (int i = 0; i < this.numVertices; i++) {
            distancia[i] = Integer.MAX_VALUE;
            verticeUsado[i] = false;
        }
        distancia[num] = 0;

        for (int i = 0; i < this.numVertices - 1; i++) {
            int u = distanciaMinima(distancia, verticeUsado);
            verticeUsado[u] = true;

            for (int j = 0; j < this.numVertices; j++) {
                if (!verticeUsado[j] && grafo[u][j] > 0 && distancia[u] != Integer.MAX_VALUE
                        && distancia[u] + 1 < distancia[j]) {
                    distancia[j] = distancia[u] + 1;
                }
            }
        }

        printSolution(distancia, num);
    }

    // Método para encontrar el camino mínimo con el algoritmo de Dijkstra
    public void dijkstra(int inicio, int fin) {
        int[] dist = new int[this.numVertices];
        boolean[] verticeYaProcesado = new boolean[this.numVertices];

        for (int i = 0; i < this.numVertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            verticeYaProcesado[i] = false;
        }
        dist[inicio] = 0;

        for (int count = 0; count < this.numVertices - 1; count++) {
            int u = distanciaMinima(dist, verticeYaProcesado);
            verticeYaProcesado[u] = true;

            for (int v = 0; v < this.numVertices; v++) {
                if (!verticeYaProcesado[v] && this.grafo[u][v] > 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + this.grafo[u][v] < dist[v]) {
                    dist[v] = dist[u] + this.grafo[u][v];
                }
            }
        }

        System.out.println("Distancia desde d" + inicio + " hasta d" + (fin + 1) + " es: " + dist[fin]);
    }

    private void printSolution(int[] distancia, int n) {
        for (int i = 0; i < this.numVertices; i++) {
            System.out.println("Distancia entre d" + (n + 1) + " y d" + (i + 1) + " : " + distancia[i]);
        }
    }

    private int distanciaMinima(int[] distancia, boolean[] verticeUsado) {
        int min = Integer.MAX_VALUE;
        int min_index = 0;

        for (int i = 0; i < this.numVertices; i++) {
            if (!verticeUsado[i] && distancia[i] <= min) {
                min = distancia[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public int getNumVertices() {
        return numVertices;
    }

    private boolean validarVertices(int v1, int v2) {
        return v1 >= 0 && v1 < numVertices && v2 >= 0 && v2 < numVertices;
    }

    public static void main(String[] args) {
        Grafos grafo = new Grafos(13);

        grafo.ingresarArista(0, 1, 200);
        grafo.ingresarArista(0, 8, 290);
        grafo.ingresarArista(0, 12, 250);
        grafo.ingresarArista(1, 2, 190);
        grafo.ingresarArista(1, 5, 360);
        grafo.ingresarArista(2, 0, 300);
        grafo.ingresarArista(2, 4, 190);
        grafo.ingresarArista(2, 5, 250);
        grafo.ingresarArista(3, 2, 180);
        grafo.ingresarArista(4, 5, 300);
        grafo.ingresarArista(4, 9, 400);
        grafo.ingresarArista(5, 10, 350);
        grafo.ingresarArista(5, 11, 300);
        grafo.ingresarArista(6, 0, 150);
        grafo.ingresarArista(6, 2, 250);
        grafo.ingresarArista(6, 3, 300);
        grafo.ingresarArista(7, 0, 220);
        grafo.ingresarArista(7, 6, 200);
        grafo.ingresarArista(8, 7, 180);
        grafo.ingresarArista(8, 12, 180);
        grafo.ingresarArista(9, 3, 200);
        grafo.ingresarArista(10, 4, 200);
        grafo.ingresarArista(10, 9, 700);
        grafo.ingresarArista(11, 1, 150);
        grafo.ingresarArista(12, 1, 200);
        grafo.ingresarArista(12, 11, 100);

        System.out.println("Grafo generado con la siguiente matriz de adyacencia: ");
        grafo.imprimirGrafo();

        int origen = ingresarValor("Ingrese el nodo origen para calcular el camino mínimo");
        System.out.println("Caminos sin peso a todos los nodos:");
        grafo.caminoMinimoSinPeso(origen - 1);

        System.out.println("Calculo del camino mínimo con algoritmo de Dijkstra");
        int inicio = ingresarValor("Ingrese el nodo de origen");
        int fin = ingresarValor("Ingrese el nodo de destino");
        grafo.dijkstra(inicio - 1, fin - 1);

        int raiz = ingresarValor("Árbol: Ingresar nodo raíz");
        Arbol arbol = new Arbol(raiz - 1, grafo.obtenerMatrizAdyacencia());
        arbol.imprimirArbol();
    }

    private static int ingresarValor(String msg) {
        int res = 0;
        boolean correcto = false;
        Scanner sc = new Scanner(System.in);

        try {
            while (!correcto) {
                System.out.println(msg);
                res = sc.nextInt();

                if (res < 1 || res > 13) {
                    System.out.println("Valor incorrecto, ingrese números del 1 al 13");
                } else {
                    correcto = true;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Ingrese un número del 1 al 13");
            res = ingresarValor(msg);
        }

        return res;
    }
}

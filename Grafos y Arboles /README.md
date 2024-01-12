 <h2 style="color: orange;">Proyecto Árboles y Grafos en Java</h2>


---

# Situación Problemática

Imagina que estás planificando un viaje por una red de ciudades y quieres encontrar la ruta más eficiente entre dos puntos. Cada ciudad se representa como un nodo en un grafo, y las conexiones entre ciudades se establecen mediante aristas con pesos que indican la distancia entre ellas.

Para resolver este problema, creé un proyecto en Java que aborda la creación y manipulación de árboles y grafos. El objetivo principal es encontrar el camino más corto entre dos ciudades, considerando la red de conexiones y sus distancias.

---
## Conceptos de Java y POO Utilizados
Encapsulamiento: Uso de encapsulamiento para proteger y gestionar el acceso a los datos de las clases.
Herencia: Aplicación de herencia en la relación entre la clase ArbolNodo y Arbol.
Polimorfismo: La clase ArbolNodo es polimórfica ya que puede tener múltiples hijos.
Estructuras de Datos: Manipulación eficiente de estructuras como listas y matrices para representar conexiones entre nodos.
Recursividad: Aplicación de llamadas recursivas para el procesamiento y la impresión jerárquica de árboles.

Clases y Funcionalidades

### 1. Clase `Grafos`

La clase `Grafos` permite la creación y manipulación de grafos dirigidos representados mediante una matriz de adyacencia. Conceptos clave:

- **Matriz de Adyacencia:** Representación eficiente de las conexiones entre vértices.
- **Cálculo de Caminos Mínimos:** Implementa algoritmos para encontrar caminos mínimos entre nodos, tanto sin peso como con el algoritmo de Dijkstra.

### 2. Clase `ArbolNodo`

La clase `ArbolNodo` representa un nodo en una estructura de árbol. Se utiliza para construir un árbol a partir de la matriz de adyacencia del grafo. Conceptos clave:

- **Estructura de Árbol:** Representa jerárquicamente la relación entre los nodos.
- **Recorrido de Árbol:** Implementa un método para imprimir el árbol de manera jerárquica.

### 3. Clase `Arbol`

La clase `Arbol` utiliza la clase `ArbolNodo` para construir un árbol a partir de un grafo y procesarlo. Conceptos clave:

- **Procesamiento de Árbol:** Utiliza la matriz de adyacencia del grafo para construir y procesar un árbol jerárquico.
- **Impresión de Árbol:** Muestra la estructura del árbol de rutas.

---

## Uso del Proyecto

1. **Configuración Inicial:** Crea una instancia de la clase `Grafos` y agrega las aristas entre nodos con pesos.

2. **Cálculo de Caminos Mínimos:** Utiliza la clase `Grafos` para calcular caminos mínimos sin peso y con el algoritmo de Dijkstra.

3. **Construcción y Procesamiento del Árbol:** Crea un árbol jerárquico a partir de la matriz de adyacencia y procesa sus nodos.

---

## Ejemplo de Uso

```java
// Crear grafo
Grafos grafo = new Grafos(13);

// Agregar aristas
// ...

// Calcular caminos mínimos
grafo.caminoMinimoSinPeso(4);
grafo.dijkstra(2, 9);

// Construir y procesar árbol
int raiz = 7;
Arbol arbol = new Arbol(raiz - 1, grafo.obtenerMatrizAdyacencia());
arbol.ImprimirArbol();

# Tabla de Posiciones de Torneo de Fútbol

Este proyecto implementa una tabla de posiciones para un torneo de fútbol. Los equipos se pueden insertar en la tabla junto con sus respectivos puntajes, y se proporcionan algoritmos de ordenamiento personalizados para organizar la tabla.

## Contenido del Proyecto

1. **Equipo.java**: Define la clase `Equipo`, que representa un equipo de fútbol con un nombre y un puntaje.

2. **TablaPosiciones.java**: Contiene la clase `TablaPosiciones`, que implementa la tabla de posiciones y proporciona métodos para insertar equipos, mostrar la tabla y ordenarla utilizando algoritmos de ordenamiento personalizados (quicksort, selección y burbuja).

3. **Main.java**: Clase principal que demuestra el uso de la `TablaPosiciones`. Inserta equipos de prueba, ordena la tabla utilizando diferentes algoritmos y muestra los resultados.

## Temas Abordados

El proyecto cubre los siguientes temas:

- **Estructuras de Datos**:
  - Uso de listas enlazadas para mantener la secuencia de equipos en la tabla de posiciones.
  - Implementación de nodos para representar equipos.

- **Algoritmos de Ordenamiento**:
  - Quicksort: Un algoritmo de ordenamiento recursivo basado en la técnica de divide y vencerás.
  - Selección: Un algoritmo de ordenamiento simple que selecciona repetidamente el elemento más pequeño.
  - Burbuja: Un algoritmo de ordenamiento que compara e intercambia elementos adyacentes.

- **Recursividad**:
  - La implementación de Quicksort utiliza recursividad para ordenar subconjuntos de la lista.

## Ejecución del Proyecto

1. Compila los archivos Java utilizando el comando `javac`:

    ```bash
    javac Main.java
    ```

2. Ejecuta el programa con el comando `java`:

    ```bash
    java Main
    ```

Esto mostrará la tabla de posiciones ordenada utilizando diferentes algoritmos.

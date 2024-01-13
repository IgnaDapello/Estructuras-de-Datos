# Proyecto Estructuras de Datos: Grafos y Tablas Hash

Este proyecto implementa diversas estructuras de datos, como grafos y tablas hash, utilizando Java. A continuación, se detallan los conceptos de programación orientada a objetos (POO) y Java utilizados en el desarrollo.

## Conceptos de POO y Java Utilizados

- **Encapsulamiento:** Las clases han sido diseñadas con atributos privados y métodos públicos para promover la encapsulación.
- **Herencia:** Se ha aplicado herencia en la implementación de las clases relacionadas con grafos.
- **Polimorfismo:** La interfaz común `TablaHash` permite la implementación de diferentes métodos de manejo de colisiones.
- **Colecciones en Java:** Se han utilizado las clases `LinkedList` e `Integer[]` para implementar estructuras de datos específicas.

## Enunciado del Problema

La Biblioteca Nacional de Santander posee una colección diversa de datos y busca implementar un sistema de almacenamiento dinámico eficiente mediante tablas hash. El enunciado del problema incluye los siguientes puntos:

1. Implementar una función hash `H(x) = x mod 10` en Java.
2. Implementar manejo de colisiones mediante sondeo lineal y cuadrático.
3. Utilizar hashing abierto con listas para evitar colisiones.

## Solución Implementada

### Clases y Funcionalidades

1. **`Grafo.java`**: Representa un grafo dirigido. Incluye métodos para calcular caminos mínimos utilizando el algoritmo de Dijkstra.

2. **`TablaHashSondeoLineal.java`**: Implementa una tabla hash con manejo de colisiones mediante sondeo lineal.

3. **`TablaHashSondeoCuadratico.java`**: Implementa una tabla hash con manejo de colisiones mediante sondeo cuadrático.

4. **`TablaHashAbierto.java`**: Implementa una tabla hash con manejo de colisiones mediante hashing abierto.

5. **`HashTables.java`**: Contiene el programa principal que interactúa con las tablas hash a través de un menú de opciones.

### Uso del Programa

1. Selecciona la opción para insertar valores en una tabla específica.
2. Realiza búsquedas y eliminaciones utilizando diferentes métodos de manejo de colisiones.
3. Observa la salida en la consola para ver el resultado de cada operación.

---

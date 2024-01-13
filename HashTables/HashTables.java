package hashtables.hashtables;

import java.util.Scanner;


public class HashTables {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            TablaHashSondeoLineal tablaSondeoLineal = new TablaHashSondeoLineal(10); // Crear una tabla de sondeo lineal
            TablaHashSondeoCuadratico tablaSondeoCuadratico = new TablaHashSondeoCuadratico(10); // Crear una tabla de sondeo cuadrático
            TablaHashAbierto tablaHashAbierto = new TablaHashAbierto(10); // Crear una tabla hash abierto

            while (true) {
                mostrarMenu();
                int opcion = obtenerOpcionValida(scanner);

                if (opcion == 10) {
                    System.out.println("Saliendo del programa.");
                    break;
                }

                System.out.print("Ingrese el valor: ");
                int valor = scanner.nextInt();

                realizarAccion(opcion, valor, tablaSondeoLineal, tablaSondeoCuadratico, tablaHashAbierto);
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("Menú de Opciones:");
        System.out.println("1. Insertar valor en Tabla Lineal");
        System.out.println("2. Insertar valor en Tabla Cuadrática");
        System.out.println("3. Insertar valor en Tabla Hash Abierto");
        System.out.println("4. Buscar valor en Tabla Lineal");
        System.out.println("5. Buscar valor en Tabla Cuadrática");
        System.out.println("6. Buscar valor en Tabla Hash Abierto");
        System.out.println("7. Eliminar valor en Tabla Lineal");
        System.out.println("8. Eliminar valor en Tabla Cuadrática");
        System.out.println("9. Eliminar valor en Tabla Hash Abierto");
        System.out.println("10. Salir");
    }

    private static int obtenerOpcionValida(Scanner scanner) {
        int opcion;
        do {
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            if (opcion < 1 || opcion > 10) {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion < 1 || opcion > 10);
        return opcion;
    }

    private static void realizarAccion(int opcion, int valor, TablaHashSondeoLineal tablaSondeoLineal,
            TablaHashSondeoCuadratico tablaSondeoCuadratico, TablaHashAbierto tablaHashAbierto) {
        switch (opcion) {
            case 1 -> tablaSondeoLineal.insertar(valor);
            case 2 -> tablaSondeoCuadratico.insertar(valor);
            case 3 -> tablaHashAbierto.insertar(valor);
            case 4 -> System.out.println("Buscar en Tabla Lineal: " + tablaSondeoLineal.buscar(valor));
            case 5 -> System.out.println("Buscar en Tabla Cuadrática: " + tablaSondeoCuadratico.buscar(valor));
            case 6 -> System.out.println("Buscar en Tabla Hash Abierto: " + tablaHashAbierto.buscar(valor));
            case 7 -> tablaSondeoLineal.eliminar(valor);
            case 8 -> tablaSondeoCuadratico.eliminar(valor);
            case 9 -> tablaHashAbierto.eliminar(valor);
            default -> System.out.println("Opción no válida. Intente nuevamente.");
        }
    }
}
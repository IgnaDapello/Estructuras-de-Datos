/**
 * Representa una tabla de posiciones que mantiene un registro de equipos y sus puntajes.
 */
public class TablaPosiciones {
    private Equipo cabeza;

    /**
     * Inserta un nuevo equipo en la tabla de posiciones.
     *
     * @param nombre  Nombre del equipo.
     * @param puntaje Puntaje del equipo.
     */
    public void insertarEquipo(String nombre, int puntaje) {
        Equipo nuevoEquipo = new Equipo(nombre, puntaje);

        if (cabeza == null) {
            cabeza = nuevoEquipo;
        } else {
            Equipo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoEquipo);
        }
    }

    /**
     * Muestra la tabla de posiciones en la consola.
     */
    public void mostrarTablaPosiciones() {
        Equipo actual = cabeza;
        while (actual != null) {
            System.out.println(actual.getNombre() + ": " + actual.getPuntaje() + " puntos");
            actual = actual.getSiguiente();
        }
    }

    /**
     * Ordena la tabla de posiciones por puntaje utilizando el algoritmo quicksort.
     */
    public void ordenarTablaPosiciones() {
        cabeza = quicksort(cabeza);
    }

    private Equipo quicksort(Equipo inicio) {
        if (inicio == null || inicio.getSiguiente() == null) {
            return inicio;
        }

        Equipo pivot = inicio;
        Equipo menorCabecera = null;
        Equipo menor = null;
        Equipo mayorCabecera = null;
        Equipo mayor = null;

        Equipo actual = inicio.getSiguiente();
        while (actual != null) {
            Equipo siguiente = actual.getSiguiente();
            if (actual.getPuntaje() > pivot.getPuntaje()) {
                if (mayorCabecera == null) {
                    mayorCabecera = actual;
                    mayor = actual;
                } else {
                    mayor.setSiguiente(actual);
                    mayor = actual;
                }
            } else {
                if (menorCabecera == null) {
                    menorCabecera = actual;
                    menor = actual;
                } else {
                    menor.setSiguiente(actual);
                    menor = actual;
                }
            }
            actual = siguiente;
        }

        if (menor != null) {
            menor.setSiguiente(null);
            menorCabecera = quicksort(menorCabecera);
            menor = getUltimoEquipo(menorCabecera);
            menor.setSiguiente(pivot);
            inicio = menorCabecera;
        } else {
            inicio = pivot;
        }

        if (mayor != null) {
            mayor.setSiguiente(null);
            mayorCabecera = quicksort(mayorCabecera);
            pivot.setSiguiente(mayorCabecera);
        }

        return inicio;
    }

    private Equipo getUltimoEquipo(Equipo equipo) {
        if (equipo == null || equipo.getSiguiente() == null) {
            return equipo;
        }

        Equipo actual = equipo;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        return actual;
    }

    /**
     * Ordena la tabla de posiciones por puntaje utilizando el algoritmo de selección.
     */
    public void ordenarPorSeleccion() {
        cabeza = seleccionSort(cabeza);
    }

    private Equipo seleccionSort(Equipo inicio) {
        if (inicio == null || inicio.getSiguiente() == null) {
            return inicio;
        }

        Equipo cabezaOrdenada = null; // Cabeza de la lista ordenada
        Equipo actual = inicio;

        while (actual != null) {
            Equipo menor = encontrarMenor(actual); // Encuentra el menor elemento en la lista no ordenada
            actual = eliminarEquipo(actual, menor); // Elimina el elemento menor de la lista no ordenada
            cabezaOrdenada = insertarAlPrincipio(cabezaOrdenada, menor); // Inserta el elemento menor al principio de la lista ordenada
        }

        return cabezaOrdenada;
    }

    private Equipo encontrarMenor(Equipo inicio) {
        Equipo menor = inicio;
        Equipo actual = inicio.getSiguiente();

        while (actual != null) {
            if (actual.getPuntaje() < menor.getPuntaje()) {
                menor = actual;
            }
            actual = actual.getSiguiente();
        }

        return menor;
    }

    private Equipo eliminarEquipo(Equipo inicio, Equipo equipoEliminar) {
        if (inicio == equipoEliminar) {
            return inicio.getSiguiente();
        }

        Equipo actual = inicio;
        while (actual != null && actual.getSiguiente() != equipoEliminar) {
            actual = actual.getSiguiente();
        }

        if (actual != null) {
            actual.setSiguiente(equipoEliminar.getSiguiente());
        }

        return inicio;
    }

    private Equipo insertarAlPrincipio(Equipo inicio, Equipo equipoInsertar) {
        equipoInsertar.setSiguiente(inicio);
        return equipoInsertar;
    }

    /**
     * Ordena la tabla de posiciones por puntaje utilizando el algoritmo de burbuja.
     */
    public void ordenarPorBurbuja() {
        cabeza = burbujaSort(cabeza);
    }

    private Equipo burbujaSort(Equipo inicio) {
        if (inicio == null || inicio.getSiguiente() == null) {
            return inicio;
        }

        boolean intercambio;
        do {
            intercambio = false;
            Equipo actual = inicio;
            Equipo anterior = null;

            while (actual != null && actual.getSiguiente() != null) {
                Equipo siguiente = actual.getSiguiente();

                if (actual.getPuntaje() > siguiente.getPuntaje()) {
                    // Realiza el intercambio
                    if (anterior != null) {
                        anterior.setSiguiente(siguiente);
                    } else {
                        inicio = siguiente;
                    }

                    actual.setSiguiente(siguiente.getSiguiente());
                    siguiente.setSiguiente(actual);

                    intercambio = true;
                }

                anterior = actual;
                actual = siguiente;
            }
        } while (intercambio);

        return inicio;
    }
}

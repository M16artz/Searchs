package ed.u2.searchs.algorithms;

import ed.u2.searchs.model.Nodo;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author M16artz : Miguel Armas
 * @author RichardC022 : Richard Cajas
 * @author Mzero11 : Mateo Silva
 */
public class BusquedaLista {

    public static Nodo primeraOcurrencia(Nodo cabeza, int key) {
        if (cabeza == null) return null;

        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getDato() == key) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public static Nodo ultimaOcurrenciaSLL(Nodo head, int key) {
        if (head == null) return null;

        Nodo actual = head;
        Nodo last = null;

        while (actual != null) {
            if (actual.getDato() == key) {
                last = actual;
            }
            actual = actual.getSiguiente();
        }
        return last;
    }

    public static List<Nodo> encontrarTodos(Nodo head, Predicate<Nodo> p) {
        List<Nodo> resultado = new ArrayList<>();
        if (head == null) return resultado;

        Nodo current = head;
        while (current != null) {
            if (p.test(current)) {
                resultado.add(current);
            }
            current = current.getSiguiente();
        }
        return resultado;
    }
}

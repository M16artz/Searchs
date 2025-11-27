package ed.u2.searchs.domain;

import ed.u2.searchs.model.Nodo;

public class Busqueda {


    public static int ultimaOcurrenciaArray(int[] a, int key) {
        if (a == null) return -1;

        int last = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                last = i;
            }
        }
        return last;
    }


    public static Nodo ultimaOcurrenciaSLL(Nodo head, int key) {
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
}

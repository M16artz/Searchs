package ed.u2.searchs.algorithms;

import ed.u2.searchs.model.Nodo;

/**
 *
 * @author M16artz : Miguel Armas
 * @author RichardC022 : Richard Cajas
 * @author Mzero11 : Mateo Silva
 */
public class ListaEnlazada {
    private Nodo cabeza;
    private int dimension;
    
    public void insertar(int valor) {
        Nodo auxNodo = new Nodo(valor);
        if (estaVacio()) {
            cabeza = auxNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(auxNodo);
        }
        dimension++;
        System.out.println("Insertado: " + valor);
    }
    
    public boolean estaVacio() {
        return cabeza == null;
    }

    public int size() {
        return dimension;
    }
}

package ed.u2.searchs.model;

/**
 * Paso 1: Primera Ocurrencia en Lista Enlazada Simple (SLL)
 * Implementa búsqueda lineal para encontrar la primera ocurrencia de un elemento
 */
public class BusquedaSLL {
    
    /**
     * Busca la primera ocurrencia de key en la lista enlazada
     * 
     * @param head Nodo cabeza de la lista enlazada
     * @param key  Valor a buscar
     * @return Nodo con la primera ocurrencia, o null si no existe
     * 
     * Casos borde considerados:
     * - Lista vacía (head == null) → retorna null
     * - Un solo nodo (match/no match)
     * - Duplicados en posición 0 (inicio), medio, final
     * - Elemento no existe → retorna null
     */
    public static Node findFirst(Node head, int key) {
        // Caso borde: lista vacía
        if (head == null) {
            return null;
        }
        
        // Búsqueda lineal: recorrer la lista desde head
        Node current = head;
        while (current != null) {
            if (current.value == key) {
                return current; // Retornar nodo de la primera ocurrencia
            }
            current = current.next; // Avanzar al siguiente nodo
        }
        
        // No se encontró el elemento
        return null;
    }
}

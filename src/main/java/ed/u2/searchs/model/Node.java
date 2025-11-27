package ed.u2.searchs.model;

/**
 * Nodo para lista enlazada simple (Singly Linked List)
 */
public class Node {
    public int value;    // Valor almacenado
    public Node next;    // Referencia al siguiente nodo
    
    /**
     * Constructor para crear un nodo
     * @param value Valor a almacenar en el nodo
     */
    public Node(int value) {
        this.value = value;
        this.next = null;
    }
    
    /**
     * Constructor con valor y siguiente nodo
     * @param value Valor a almacenar
     * @param next Siguiente nodo en la lista
     */
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
    
    @Override
    public String toString() {
        return "Node(" + value + ")";
    }
}

package ed.u2.searchs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para búsqueda de primera ocurrencia en Lista Enlazada Simple
 */
class BusquedaSLLTest {
    
    @Test
    void testListaVacia() {
        Node head = null;
        assertNull(BusquedaSLL.findFirst(head, 5), "Lista vacía debe retornar null");
    }
    
    @Test
    void testUnSoloNodoMatch() {
        Node head = new Node(7);
        Node result = BusquedaSLL.findFirst(head, 7);
        assertNotNull(result, "Debe encontrar el nodo");
        assertEquals(7, result.value, "El valor debe ser 7");
    }
    
    @Test
    void testUnSoloNodoNoMatch() {
        Node head = new Node(7);
        assertNull(BusquedaSLL.findFirst(head, 5), "Nodo sin match debe retornar null");
    }
    
    @Test
    void testDuplicadosEnInicio() {
        // Lista: 3 a 3 a 5 a 7 a 3
        Node head = new Node(3);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(3);
        
        Node result = BusquedaSLL.findFirst(head, 3);
        assertNotNull(result, "Debe encontrar el primer nodo");
        assertSame(head, result, "Debe retornar el primer nodo (head)");
    }
    
    @Test
    void testDuplicadosEnMedio() {
        // Lista: 1 a 2 a 5 a 5 a 5 a 8
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(5);
        Node primerCinco = head.next.next; // Guardamos referencia al primer 5
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(8);
        
        Node result = BusquedaSLL.findFirst(head, 5);
        assertNotNull(result, "Debe encontrar el nodo");
        assertSame(primerCinco, result, "Debe retornar el primer 5");
    }
    
    @Test
    void testDuplicadosAlFinal() {
        // Lista: 1 a 2 a 3 a 9 a 9
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(9);
        Node primerNueve = head.next.next.next; // Guardamos referencia al primer 9
        head.next.next.next.next = new Node(9);
        
        Node result = BusquedaSLL.findFirst(head, 9);
        assertNotNull(result, "Debe encontrar el nodo");
        assertSame(primerNueve, result, "Debe retornar el primer 9");
    }
    
    @Test
    void testElementoNoExiste() {
        // Lista: 1 a 2 a 3 a 4 a 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        
        assertNull(BusquedaSLL.findFirst(head, 10), "Elemento inexistente debe retornar null");
    }
    
    @Test
    void testPrimerNodo() {
        // Lista: 10 a 20 a 30 a 40
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        
        Node result = BusquedaSLL.findFirst(head, 10);
        assertNotNull(result, "Debe encontrar el nodo");
        assertSame(head, result, "Debe retornar el head");
    }
    
    @Test
    void testUltimoNodo() {
        // Lista: 10 a 20 a 30 a 40
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        Node ultimo = head.next.next.next;
        
        Node result = BusquedaSLL.findFirst(head, 40);
        assertNotNull(result, "Debe encontrar el nodo");
        assertSame(ultimo, result, "Debe retornar el último nodo");
    }
}

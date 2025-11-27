package ed.u2.searchs.view;

import ed.u2.searchs.model.BusquedaArray;
import ed.u2.searchs.model.BusquedaSLL;
import ed.u2.searchs.model.Node;

/**
Esta es la clasemain para el funcionamiento de as bsuquedas
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== TALLER 7: PASO 1 - PRIMERA OCURRENCIA ===\n");
        
        // Busqueda en array 
        System.out.println("1. BÚSQUEDA EN ARRAY");
        System.out.println("   " + "=".repeat(40));
        
        int[] arr = {3, 7, 1, 9, 3, 5, 3};
        System.out.println("   Array: " + arrayToString(arr));
        
        int key1 = 3;
        int index1 = BusquedaArray.indexOfFirst(arr, key1);
        System.out.println("   Buscar: " + key1 + " → Índice: " + index1);
        
        int key2 = 9;
        int index2 = BusquedaArray.indexOfFirst(arr, key2);
        System.out.println("   Buscar: " + key2 + " → Índice: " + index2);
        
        int key3 = 99;
        int index3 = BusquedaArray.indexOfFirst(arr, key3);
        System.out.println("   Buscar: " + key3 + " → Índice: " + index3 + " (no existe)\n");
        
        // BÚSQUEDA EN LISTA ENLAZADA
        System.out.println("2. BÚSQUEDA EN LISTA ENLAZADA (SLL)");
        System.out.println("   " + "=".repeat(40));
        
        // Crear lista: 10 a 20 a 30 a 20 a 40
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(40);
        
        System.out.println("   Lista: " + linkedListToString(head));
        
        int keyS1 = 20;
        Node result1 = BusquedaSLL.findFirst(head, keyS1);
        System.out.println("   Buscar: " + keyS1 + " → Nodo: " + 
            (result1 != null ? result1 + " (primera ocurrencia)" : "null"));
        
        int keyS2 = 40;
        Node result2 = BusquedaSLL.findFirst(head, keyS2);
        System.out.println("   Buscar: " + keyS2 + " → Nodo: " + 
            (result2 != null ? result2 : "null"));
        
        int keyS3 = 99;
        Node result3 = BusquedaSLL.findFirst(head, keyS3);
        System.out.println("   Buscar: " + keyS3 + " → Nodo: " + 
            (result3 != null ? result3 : "null (no existe)"));
        
        System.out.println("\n=== EJECUTA LOS TESTS CON: mvn test ===");
    }
    
    private static String arrayToString(int[] arr) {
        if (arr == null || arr.length == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
    
    private static String linkedListToString(Node head) {
        if (head == null) return "null";
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        return sb.toString();
    }
}

package ed.u2.searchs.view;

import ed.u2.searchs.algorithms.BubbleSort;
import ed.u2.searchs.algorithms.BusquedaArreglos;
import ed.u2.searchs.algorithms.BusquedaLista;
import ed.u2.searchs.model.Nodo;
import java.util.List;

/**
 *
 * @author M16artz : Miguel Armas
 * @author RichardC022 : Richard Cajas
 * @author Mzero11 : Mateo Silva
 */
public class SortingDemo {

    public static void main(String[] args) {
        // 1. Datasets
        int[] A = {8, 3, 6, 3, 9}; // Desordenado
        int[] B = {5, 4, 3, 2, 1}; // Inverso
        int[] C = {1, 2, 3, 4, 5}; // Ordenado
        int[] D = {2, 2, 2, 2};    // Duplicados
        int[] E ={1,2,3,3,4,5,6,3,7,8,9,3};
        //Valores de prueba sugeridos
        int[] keys = {7, 5, 2, 42};

        System.out.println("=================================================");
        System.out.println("       PRUEBAS CON ARREGLOS");
        System.out.println("=================================================\n");
        
        testArray("Arreglo A (Desordenado)", A, keys);
        testArray("Arreglo B (Inverso)", B, keys);
        testArray("Arreglo C (Ordenado)", C, keys);
        testArray("Arreglo D (Duplicados)", D, keys);

        // --- PRUEBA BINARIA ---
        //El prerequisito es qu esté ordenado, por eso usamos el Arreglo C
        //tambien se puede aplicar un metodo de ordenamiento antes de ejecutar
        System.out.println("--- Prueba Búsqueda Binaria (Solo en C - Ordenado) ---");
        printArray(C);
        for (int k : keys) {
            //int[] CAux=C.clone();
            // BubbleSort.sort(CAux);
            //enviariamos CAux en lugar de C
            int idx = BusquedaArreglos.binarySearch(C, k);
            System.out.println("BinarySearch de " + k + " en C: " + idx);
        }

        System.out.println("\n=================================================");
        System.out.println("    VERSUS: SECUENCIAL vs CENTINELA (Trazas)");
        System.out.println("=================================================");
        printArray(A);
        // Usamos Arreglo A: {8, 3, 6, 3, 9}
        // Buscar el 9 (está al final, peor caso de éxito)
        int keyVersus = 9; 
        System.out.println("--- Buscando clave: " + keyVersus + " en A ---");
        
        int idxSec = BusquedaArreglos.busquedaSecuencialTrazas(A, keyVersus);
        
        int idxCen = BusquedaArreglos.busquedaPorCentinelaTrazas(A, keyVersus);
        
        System.out.println("--> Resultado índices: Secuencial=" + idxSec + ", Centinela=" + idxCen);

        System.out.println("\n==========================================================");
        System.out.println("    VERSUS: SECUENCIAL vs CENTINELA (Trazas) (No esxite el valor");
        System.out.println("==========================================================");
        printArray(A);
        // Usamos Arreglo A: {8, 3, 6, 3, 9}
        // Buscar el 9 (está al final, peor caso de éxito)
        int keyVersusNoExiste = 5; 
        System.out.println("--- Buscando clave: " + keyVersusNoExiste + " en A ---");
        
        int idxSecNoExiste = BusquedaArreglos.busquedaSecuencialTrazas(A, keyVersusNoExiste);
        
        int idxCenNoExiste = BusquedaArreglos.busquedaPorCentinelaTrazas(A, keyVersusNoExiste);
        
        System.out.println("--> Resultado índices: Secuencial=" + idxSecNoExiste + ", Centinela=" + idxCenNoExiste);
        if(idxCenNoExiste==A.length)
            System.out.println("Como el index devuelto es igual al tamaño del arreglo: "+A.length+", el elemento no está en el arreglo");
        
        // --- PRUEBA LOWER/UPPER BOUND ---
        //La prueba se realizará con D : {2, 2, 2, 2} donde todos son duplicados
        System.out.println("\n--- Prueba Lower/Upper Bound (Duplicados en D) ---");
        int[]DAux=D.clone();
        BubbleSort.sort(DAux);

        int lb = BusquedaArreglos.lowerBound(DAux, 2);
        System.out.println("LowerBound de 2 en D: " + lb + " (Debería ser 0)");

        int ub = BusquedaArreglos.upperBound(DAux, 2);
        System.out.println("UpperBound de 2 en D: " + ub + " (Debería ser 3)");
          // --- PRUEBA TODAS LAS COINCIDENCIAS DENTRO DEL ARREGLO ---
        //La prueba se realizará con E: {1,2,3,3,4,5,6,3,7,8,9,3} donde todos son duplicados
        System.out.println("\n=================================================");
        System.out.println("    PRUEBAS TODAS LAS COINCIDENCIAS ARREGLO ");
        System.out.println("=================================================\n");
        printArray(E);
        List<Integer> ac=BusquedaArreglos.findAll(E, n->n==3);
        System.out.print("FindAll (iguales a 3)(=3): ");
        System.out.println("Todos los indices donde hay coincidencias");
        System.out.print("[");
        for (Integer a : ac) {
            System.out.print(a+(", "));
        }
        System.out.println("\b\b]");
        System.out.println();
        System.out.println("\n=================================================");
        System.out.println("    PRUEBAS CON LISTA ENLAZADA (SLL) ");
        System.out.println("=================================================\n");
        // Construcción manual de 3 -> 1 -> 3 -> 2
        Nodo head = new Nodo(3);
        head.setSiguiente(new Nodo(1));
        head.getSiguiente().setSiguiente(new Nodo(3));
        head.getSiguiente().getSiguiente().setSiguiente(new Nodo(2));

        System.out.println("Lista: [3 => 1 => 3 => 2]");

        // Casos de prueba SLL
        int sllKey = 3;
        Nodo first = BusquedaLista.primeraOcurrencia(head, sllKey);
        System.out.println("First Match (3): " + (first != null ? "Hash " + System.identityHashCode(first) : "null"));

        Nodo last = BusquedaLista.ultimaOcurrenciaSLL(head, sllKey);
        System.out.println("Last Match (3): " + (last != null ? "Hash " + System.identityHashCode(last) : "null"));

        // FindAll
        List<Nodo> menores = BusquedaLista.encontrarTodos(head, n -> n.getDato() < 3);
        System.out.print("FindAll (menores a 3)(<3): ");
        for (Nodo n : menores) {
            System.out.print(n.getDato() + (n.getSiguiente()!=null?" =>":" "));
        }
        System.out.println();
    }

    private static void testArray(String nombre, int[] array, int[] keys) {
        System.out.println("Devolverá el indice del valor, en caso de no existir devolverá -1");
        System.out.println("Dataset: " + nombre);
        printArray(array);
        for (int k : keys) {
            int i1 = BusquedaArreglos.primeraOcurrencia(array, k);
            int i2 = BusquedaArreglos.ultimaOcurrenciaArray(array, k);
            System.out.printf("   Clave %2d -> First: %2d | Last: %2d%n", k, i1, i2);
        }
        System.out.println();
    }

    private static void printArray(int[] a) {
        System.out.print("   Contenido: [ ");
        if (a != null) {
            for (int x : a) {
                System.out.print(x + " ");
            }
        }
        System.out.println("]");
    }
}

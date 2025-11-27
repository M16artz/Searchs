package ed.u2.searchs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para búsqueda de primera ocurrencia en Arrays
 * Cubre todos los casos borde especificados
 */
class BusquedaArrayTest {
    
    @Test
    void testArrayVacio() {
        int[] arr = {};
        assertEquals(-1, BusquedaArray.indexOfFirst(arr, 5), "Array vacío debe retornar -1");
    }
    
    @Test
    void testArrayNull() {
        int[] arr = null;
        assertEquals(-1, BusquedaArray.indexOfFirst(arr, 5), "Array null debe retornar -1");
    }
    
    @Test
    void testUnSoloElementoMatch() {
        int[] arr = {7};
        assertEquals(0, BusquedaArray.indexOfFirst(arr, 7), "Un elemento que hace match debe retornar 0");
    }
    
    @Test
    void testUnSoloElementoNoMatch() {
        int[] arr = {7};
        assertEquals(-1, BusquedaArray.indexOfFirst(arr, 5), "Un elemento sin match debe retornar -1");
    }
    
    @Test
    void testDuplicadosEnInicio() {
        int[] arr = {3, 3, 5, 7, 3};
        assertEquals(0, BusquedaArray.indexOfFirst(arr, 3), "Duplicados en inicio debe retornar índice 0");
    }
    
    @Test
    void testDuplicadosEnMedio() {
        int[] arr = {1, 2, 5, 5, 5, 8};
        assertEquals(2, BusquedaArray.indexOfFirst(arr, 5), "Duplicados en medio debe retornar primer índice");
    }
    
    @Test
    void testDuplicadosAlFinal() {
        int[] arr = {1, 2, 3, 9, 9};
        assertEquals(3, BusquedaArray.indexOfFirst(arr, 9), "Duplicados al final debe retornar primer índice");
    }
    
    @Test
    void testElementoNoExiste() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(-1, BusquedaArray.indexOfFirst(arr, 10), "Elemento inexistente debe retornar -1");
    }
    
    @Test
    void testPrimerElemento() {
        int[] arr = {10, 20, 30, 40};
        assertEquals(0, BusquedaArray.indexOfFirst(arr, 10), "Primer elemento debe retornar 0");
    }
    
    @Test
    void testUltimoElemento() {
        int[] arr = {10, 20, 30, 40};
        assertEquals(3, BusquedaArray.indexOfFirst(arr, 40), "Último elemento debe retornar último índice");
    }
}

package ed.u2.searchs;

/**
 * Paso 1: Primera Ocurrencia en Arrays
 * Implementa búsqueda lineal para encontrar la primera ocurrencia de un elemento
 */
public class BusquedaArray {
    
    /**
     * Busca la primera ocurrencia de key en el array
     * 
     * @param a   Array de enteros donde buscar
     * @param key Valor a buscar
     * @return Índice de la primera ocurrencia, o -1 si no existe
     * 
     * Casos borde considerados:
     * - Array vacío → retorna -1
     * - Un solo elemento (match/no match)
     * - Duplicados en posición 0, medio, final
     * - Elemento no existe → retorna -1
     */
    public static int indexOfFirst(int[] a, int key) {
        // Caso borde: array vacío o null
        if (a == null || a.length == 0) {
            return -1;
        }
        
        // Búsqueda lineal: recorrer de inicio a fin
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i; // Retornar índice de la primera ocurrencia
            }
        }
        
        // No se encontró el elemento
        return -1;
    }
}

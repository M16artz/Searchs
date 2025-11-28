package ed.u2.searchs.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

/**
 *
 * @author M16artz : Miguel Armas
 * @author RichardC022 : Richard Cajas
 * @author Mzero11 : Mateo Silva
 */
public class BusquedaArreglos {

    public static int primeraOcurrencia(int[] a, int key) {

        if (a == null || a.length == 0) return -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int ultimaOcurrenciaArray(int[] a, int key) {

        if (a == null || a.length == 0) return -1;

        int last = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                last = i;
            }
        }
        return last;
    }

    public static List<Integer> findAll(int[] a, IntPredicate p) {
        List<Integer> results = new ArrayList<>();

        if (a == null) return results;

        for (int i = 0; i < a.length; i++) {
            if (p.test(a[i])) {
                results.add(i);
            }
        }
        return results;
    }
/**
     * Búsqueda Secuencial Clásica con contador de Trazas (Comparaciones).
     * Sirve para comparar rendimiento contra el Centinela.
     */
    public static int busquedaSecuencialTrazas(int[] a, int key) {
        if (a == null || a.length == 0) return -1;
        
        int comparaciones = 0;
        
        for (int i = 0; i < a.length; i++) {
            // Contamos la verificación del bucle (i < a.length) que acaba de pasar
            comparaciones++; 
            
            // Contamos la verificación del dato (a[i] == key)
            comparaciones++; 
            
            if (a[i] == key) {
                System.out.println("   [Secuencial] Comparaciones Totales (Bucle + If): " + comparaciones);
                return i; 
            }
        }
        
        // Si llegamos aquí, el bucle hizo una última comparación (i < a.length)
        comparaciones++; 
        
        System.out.println("   [Secuencial] Comparaciones Totales (Bucle + If): " + comparaciones);
        return -1; 
    }
    
    public static int busquedaPorCentinelaTrazas(int[] arreglo, int valor) {
        if (arreglo == null || arreglo.length == 0) return -1;

        int[] auxiliar = new int[(arreglo.length + 1)];
        int comparaciones = 0;
        
        for (int i = 0; i < arreglo.length; i++) {
            auxiliar[i] = arreglo[i];
        }
        auxiliar[arreglo.length] = valor; 
        
        int i = 0;
        comparaciones++; 
        while (auxiliar[i] != valor) {
            comparaciones++;
            i++;
        }
        
        System.out.println("   [Centinela] Comparaciones realizadas: " + comparaciones);
        
        return i;
    }

    public static int binarySearch(int[] a, int key) {
        if (a == null || a.length == 0) return -1;

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (a[mid] == key) {
                return mid;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int lowerBound(int[] arreglo, int valor) {
        if (arreglo == null || arreglo.length == 0) return -1;
        
        int bajo = 0;
        int alto = arreglo.length;

        while (bajo < alto) {
            int medio = bajo + (alto - bajo) / 2;
            if (arreglo[medio] < valor) {
                bajo = medio + 1;
            } else {
                alto = medio;
            }
        }
        //verificar si el índice encontrado realmente es el valor
        if (bajo < arreglo.length && arreglo[bajo] == valor) {
            return bajo;
        }
        return -1;
    }

    public static int upperBound(int[] arreglo, int valor) {
        if (arreglo == null || arreglo.length == 0) return -1;

        int bajo = 0;
        int alto = arreglo.length;

        while (bajo < alto) {
            int medio = bajo + (alto - bajo) / 2;
            if (arreglo[medio] <= valor) {
                bajo = medio + 1;
            } else {
                alto = medio;
            }
        }
        // Nota: UpperBound suele retornar el primer elemento MAYOR que el valor.
        // Si quieres la última ocurrencia exacta, chequea bajo-1.
        if (bajo > 0 && arreglo[bajo - 1] == valor) {
            return bajo - 1; 
        }
        return -1;
    }
}

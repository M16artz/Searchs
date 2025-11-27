package ed.u2.searchs.model;
/**
 *
 * @author MikelMZ : Miguel Armas
 */
public class BusquedaSecuencial {

    public int busquedaPorCentinela(int[] arreglo, int valor) {
        int[] auxiliar = new int[(arreglo.length + 1)];
        for (int i = 0; i < arreglo.length; i++) {
            auxiliar[i] = arreglo[i];
        }
        auxiliar[arreglo.length] = valor;
        int i = 0;
        
        while (auxiliar[i] != valor) {
            i++;
        }

        if (i < arreglo.length) {
            return i; 
        } else {
            return -1;
        }
    }
    
    public int busquedaPorCentinelaTrazas(int[] arreglo, int valor) {
        int[] auxiliar = new int[(arreglo.length + 1)];
        int comparaciones=0; 
        for (int i = 0; i < arreglo.length; i++) {
            auxiliar[i] = arreglo[i];
        }
        auxiliar[arreglo.length] = valor;
        int i = 0;
        comparaciones++;
        while (auxiliar[i] != valor) {
            i++;
            comparaciones++;
        }
        System.out.println("Se hiceron: "+comparaciones+" Comparaciones");
        if (i < arreglo.length) {
            return i; 
        } else {
            return -1;
        }
    }
}

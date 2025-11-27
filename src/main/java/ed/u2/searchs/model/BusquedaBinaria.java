package ed.u2.searchs.model;

import ed.u2.searchs.domain.BubbleSort;

/**
 *
 * @author MikelMZ : Miguel Armas
 */
public class BusquedaBinaria {
    public int lowerBound(int[] arreglo,int valor){
        BubbleSort.sort(arreglo);
        int bajo=0;
        int alto=arreglo.length;
        
        while(bajo<alto){
            int medio=bajo+(alto-bajo)/2;
            if(arreglo[medio]<valor){
                bajo=medio+1;
            }else{
                alto=medio; 
            }
        }
        return bajo;
    }
    
    public int upperBound(int[] arreglo,int valor){
        BubbleSort.sort(arreglo);
        int bajo=0;
        int alto=arreglo.length;
        
        while(bajo<alto){
            int medio=bajo+(alto-bajo)/2;
            if(arreglo[medio]<=valor){
                bajo=medio+1;
            }else{
                alto=medio; 
            }
        }
        return bajo;
    }
}

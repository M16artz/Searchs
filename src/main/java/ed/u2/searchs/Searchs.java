/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ed.u2.searchs;

import ed.u2.searchs.model.Nodo;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;


/**
 *
 * @author PC
 */



public class Searchs {
    public static List<Integer> finAll(int[] a, IntPredicate p){
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (p.test(a[i])) {
                results.add(i);
            }
        }
        return results;
    }

    public static List<Nodo> finAll(Nodo head, Predicate<Nodo> p) {
        List<Nodo> resultado = new ArrayList<>();
        Nodo current = head;

        while (current != null) {
            if (p.test(current)){
                resultado.add(current);
            }
            current = current.getSiguiente();
        }
        return resultado;
    }

}

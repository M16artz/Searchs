package ed.u2.searchs.view;

import ed.u2.searchs.domain.Busqueda;
import ed.u2.searchs.model.Nodo;

public class Test_Busqueda {

    public static void main(String[] args) {

        System.out.println("=== Prueba Array ===\n");

        int[] datos = {1, 7, 3, 7, 9, 6, 8, 9, 9 ,8};
        int key = 3;

        int pos = Busqueda.ultimaOcurrenciaArray(datos, key);
        System.out.println("Ultima ocurrencia de " + key + " = " + pos);

        System.out.println("\n=== Prueba Lista Enlazada SLL ===\n");

        // Crear listaa
        Nodo n1 = new Nodo(3, null);
        Nodo n2 = new Nodo(1, null);
        Nodo n3 = new Nodo(3, null);
        Nodo n4 = new Nodo(2, null);
        Nodo n5= new Nodo( 2, null);

        n1.setSiguiente(n2);
        n2.setSiguiente(n3);
        n3.setSiguiente(n4);
        n4.setSiguiente(n5);

        Nodo last = Busqueda.ultimaOcurrenciaSLL(n1, 3);

        if (last != null) {
            System.out.println("Ultima ocurrencia de 3 en SLL = " + last.getDato());
        } else {
            System.out.println("No encontrado en la lista");
        }
    }
}

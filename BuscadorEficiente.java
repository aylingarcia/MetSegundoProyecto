import java.util.ArrayList;
import java.util.HashMap;

public class BuscadorEficiente {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> nuevaLista;
        nuevaLista = new HashMap<>();
        int n = 1000000;
        int[] aux = new int[n];
        // llenado 
        for (int i=0; i<aux.length; i++) {
            aux[i] = (int)(Math.random()*1000);
        }
        long t, t1 =0;
        t = System.currentTimeMillis();
        // ordenamiento 
        quicksort(aux, 0, aux.length-1);
        // agregar a base de datos
        ArrayList<Integer> enterosIguales = new ArrayList<>();
        enterosIguales.add(aux[0]);
        nuevaLista.put(aux[0],enterosIguales);
        for (int i=1; i<aux.length; i++) {
            int ultimoAgregado = aux[i-1];
            int actual = aux[i];
            if (!nuevaLista.containsKey(actual)){
                enterosIguales = new ArrayList<>();
                enterosIguales.add(actual);
                nuevaLista.put(actual, enterosIguales);
            } else {
                enterosIguales.add(actual);
            }
        }
        int numero1 = 80;
        int contador = 0;
        if (nuevaLista.containsKey(numero1))
            contador = nuevaLista.get(numero1).size();
        int numero2 = 5;
        for (int i =0; i<300; i++)
            contador = nuevaLista.get(numero2).size();

        t1 = System.currentTimeMillis();
        System.out.println("tarda: " + (t1-t));
    }

    static void quicksort(int arreglo[],int primero,int ultimo){
        int central,i,j;
        int pivote;
        central=(primero+ultimo)/2;
        pivote=arreglo[central];
        i=primero;
        j=ultimo;
        do{
            while(arreglo[i]<pivote) i++;
            while(arreglo[j]>pivote) j--;
            if(i<=j){
                int temp;
                temp=arreglo[i];
                arreglo[i]=arreglo[j];
                arreglo[j]=temp;
                i++;
                j--;
            }
        }

        while(i<=j);
        if(primero<j)
            quicksort(arreglo,primero,j); 
        if(i<ultimo)
            quicksort(arreglo,i,ultimo); 
    }

}

public class BuscadorNormal {
    public static void main(String[] args) {
        int n = 1000000;
        int[] aux = new int[n];
        // llenado 
        for (int i=0; i<aux.length; i++) {
            aux[i] = (int)(Math.random()*1000);
        }
        long t, t1 =0;
        t = System.currentTimeMillis();
        // busqueda 

        int numero = 50;
        int contador = 0;
        for (int i=0; i<aux.length; i++) {
            if (aux[i]==numero)
                contador++;
        }

        int numero2 = 15;
        int contador2 = 0;
        for (int i=0; i<aux.length; i++) {
            if (aux[i]==numero2)
                contador2++;
        }
        System.out.println(contador2);
        int numero3 = 8;
        int contador3 = 0;
        for (int i=0; i<aux.length; i++) {
            if (aux[i]==numero3)
                contador3++;
        }
        int numero4 = 306;
        int contador4 = 0;
        for (int i=0; i<aux.length; i++) {
            if (aux[i]==numero4)
                contador4++;
        }
        int numero5 = 407;
        int contador5 = 0;
        for (int i=0; i<aux.length; i++) {
            if (aux[i]==numero5)
                contador5++;
        }
        for (int i=0; i<aux.length; i++) {
            if (aux[i]==numero5)
                contador5++;
        }
        for (int i=0; i<aux.length; i++) {
            if (aux[i]==numero5)
                contador5++;
        }
        for (int j =0; j<300; j++)
            for (int i=0; i<aux.length; i++) {
                if (aux[i]==numero5)
                    contador5++;
            }
        System.out.println(contador);
        t1 = System.currentTimeMillis();
        System.out.println("tiempo que tarda: " + (t1-t));
    }
}
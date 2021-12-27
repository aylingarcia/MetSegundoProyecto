package clases;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.HashMap;

public class Pedido {
    private HashMap<Platillo, Integer> platillos;
    private double                     costo;
    /**
     * la orden debe ser la que contiene los especiales agregados al final!
     */
    public Pedido() {
        platillos = new HashMap<>();
        costo = 0;
    }

    public void agregarPlatillo(Platillo p) {
        try {
            validarPlatillo(p);
            int ac = 1;
            if (platillos.containsKey(p))
                ac += platillos.get(p);
            platillos.put(p, ac);
            aumentarCosto(p.getCosto());
        } catch (Exception e) {
            // aqui debemos retornar el mensaje y seguir almacenando el platillo editando
        }
    }
    private void aumentarCosto(double c) {
        costo += c;
    }

    public double getCosto() {
        return costo;
    }

    private void validarPlatillo(Platillo p) throws Exception {
        if (p.getComponentes().size()==1) 
            throw new Exception(
                "error debe tener almenos 2 componentes para ser considerado"
                );
    }

    public HashMap<Platillo, Integer> getInformacion() {
        return platillos;
    }
    
    public ArrayList<Platillo> getPlatillos() {
        ArrayList<Platillo> lista = new ArrayList();
        Platillo[] p = new Platillo[platillos.keySet().size()];
        p = platillos.keySet().toArray(p);
        for (Platillo n: p) {
            lista.add(n);
        }
        return lista;
    }
}
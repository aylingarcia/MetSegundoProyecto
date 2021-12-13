package clases;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.HashMap;

public class Pedido {
    private HashMap<Platillo, Integer> platillos;

    /**
     * la orden debe ser la que contiene los especiales agregados al final!
     */
    public Pedido() {
        platillos = new HashMap<>();
    }

    public void agregarPlatillo(Platillo p) {
        try {
            validarPlatillo(p);
            if (!platillos.containsKey(p))
                platillos.put(p, 1);
            else {
                int ac = platillos.get(p);
                platillos.put(p, ac+1);
            }
        } catch (Exception e) {
            // aqui debemos retornar el mensaje y seguir almacenando el platillo editando
        }
    }

    public int calcularTiempo() {
        return 0;
    }

    private void validarPlatillo(Platillo p) throws Exception {
        if (p.getComponentes().size()==1) 
            throw new Exception(
                "error debe tener almenos 2 componentes para ser considerado"
                );
    }
}
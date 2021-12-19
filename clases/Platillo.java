package clases;

import java.util.HashMap;
import java.util.ArrayList;

import java.io.Serializable;

public class Platillo implements Serializable{
    // no debe tener en la caracteristicas 
    protected final ArrayList<Componente> caracteristicas;
    // referente a una caracteristica de un platillo en especifico
    // tal que silpancho tiene carne de apanado ...
    // caso de que no lo tenga entonces no podria llamarse silpancho
    protected HashMap<Componente, Integer> componentes;
        
    public Platillo(Componente... principal) {
        caracteristicas = new ArrayList<>();
        componentes = new HashMap<>();
        for (Componente c: principal) {
            caracteristicas.add(c);
            componentes.put(c, 1);
        }
    }

    public boolean existeComponente(Componente componente) {
        return componentes.containsKey(componente);
    }
    public boolean insertarComponente(Componente c) {
        boolean esValido = !existeComponente(c);
        if (esValido)
            componentes.put(c, 1);
        return esValido;
    }
    
    public void aumentarComponente(int n, Componente c) {
        int actual = componentes.get(c);
        if (componentes.containsKey(c))
            componentes.put(c, actual+n);
        if (componentes.get(c)<=0) {
            componentes.put(c, 1);
        }
    }
    
    public double calcularCosto() {
        System.out.println(componentes.values().toString());
        return 0;
    }
    
    public void removeComponente(Componente c) {
        // remove a componente pero si es que 
        // pertenece a las caracreristicas entonces no podemos quitarlo
        if (!caracteristicas.contains(c))
            componentes.remove(c);
    }
    
    public int getCantComponente(Componente c) {
        return componentes.get(c);
    }
    public HashMap<Componente, Integer> getComponentes() {
        return componentes;
    }
}
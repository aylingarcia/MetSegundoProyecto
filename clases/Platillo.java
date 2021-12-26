package clases;

import java.util.HashMap;
import java.util.ArrayList;

public class Platillo {
    // no debe tener en la caracteristicas 
    private String titulo;
    protected final ArrayList<Componente> caracteristicas;
    // referente a una caracteristica de un platillo en especifico
    // tal que silpancho tiene carne de apanado ...
    // caso de que no lo tenga entonces no podria llamarse silpancho
    protected HashMap<Componente, Integer> componentes;
    private double costo;
        
    public Platillo(String t, Componente... principal) {
        caracteristicas = new ArrayList<>();
        costo = 0;
        titulo = t;
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
    
    public double getCosto() {
        return costo;
    }
    
    public void removeComponente(Componente c) {
        // remove a componente pero si es que 
        // pertenece a las caracreristicas entonces no podemos quitarlo
        if (!caracteristicas.contains(c)) {
            aumentarCosto(-c.getCosto()*componentes.get(c));
            componentes.remove(c);
        }
    }
    private void aumentarCosto(double c) {
        costo += c;
    }
    
    public int getCantComponente(Componente c) {
        return componentes.get(c);
    }
    public HashMap<Componente, Integer> getComponentes() {
        return componentes;
    }
    public String getTitulo() {
        return titulo;
    }
}
package clases;

import java.util.HashMap;

public class Platillo {
    //private final Componente caracteristica;
    // referente a una caracteristica de un platillo en especifico
    // tal que silpancho tiene carne de apanado ...
    protected HashMap<Componente, Integer> componentes;
    
    
    public boolean existe(String componente) {
        return false;
    }
    public boolean insertarComponente(Componente c) {
        return true;
    }
}
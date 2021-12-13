package clases;

public class Componente {
    protected String nombre;
    protected String estado;
    protected double costo;
    
    public Componente(String id,String est, double c) {
        nombre = id;
        costo = c;
        estado = est;
    }
    
    public String getNombre() {
        return nombre;
    }
    public double getCosto() {
        return costo;
    }
    public String getEstado() {
        return estado;
    }
}
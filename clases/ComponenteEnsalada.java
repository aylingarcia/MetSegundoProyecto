package clases;

public class ComponenteEnsalada extends Componente{
    public ComponenteEnsalada(String n, String s, double c) {
        super(n, s, c);
    }
    public ComponenteEnsalada(String n, double c) {
        super(n, null, c);
    }
}
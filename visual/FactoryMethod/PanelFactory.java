package visual.FactoryMethod;


import javax.swing.JPanel;

import visual.*;

public abstract class PanelFactory {
    
    protected VentanaPrincipal frameEstatico;
    
    public PanelFactory(VentanaPrincipal frame) {
        frameEstatico = frame;
    }
    
    public abstract JPanel crearPanel();
    
    
}

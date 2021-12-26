package visual.FactoryMethod;

import javax.swing.JPanel;

import visual.PanelesEdicion.*;
import visual.VentanaPrincipal;

public class PanelEdicionAutomaticoFactory 
extends PanelFactory
{
    
    public PanelEdicionAutomaticoFactory(VentanaPrincipal frame) {
        super(frame);
    }
    
    public JPanel crearPanel() {
        return new PanelEdicionAutoServicio();
    }
}
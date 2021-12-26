package visual.FactoryMethod;

import javax.swing.JPanel;

import visual.PanelesAYUDA.*;
import visual.VentanaPrincipal;

public class PanelAyudaFactory extends PanelFactory {
    
    public PanelAyudaFactory(VentanaPrincipal frame) {
        super(frame);
    }
    
    public JPanel crearPanel() {
        return new PanelAyuda();
    }
}

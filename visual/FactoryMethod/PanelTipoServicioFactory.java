package visual.FactoryMethod;

import javax.swing.JPanel;

import visual.PanelesFinales.*;
import visual.VentanaPrincipal;

public class PanelTipoServicioFactory extends PanelFactory {
    public PanelTipoServicioFactory(VentanaPrincipal frame) {
        super(frame);
    }
    
    public JPanel crearPanel() {
        return new PanelTipoServicio(frameEstatico);
    }
}
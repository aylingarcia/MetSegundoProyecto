package visual.FactoryMethod;

import javax.swing.JPanel;

import visual.PanelesUsuario.*;
import visual.VentanaPrincipal;

public class PanelInicioFactory extends PanelFactory {
    
    public PanelInicioFactory(VentanaPrincipal frame) {
        super(frame);
    }
    
    public JPanel crearPanel() {
        return new PanelInicioSesion(frameEstatico);
    }
}
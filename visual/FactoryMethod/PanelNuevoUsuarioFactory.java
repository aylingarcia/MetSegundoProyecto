package visual.FactoryMethod;

import visual.PanelesUsuario.*;
import visual.VentanaPrincipal;

import javax.swing.JPanel;

public class PanelNuevoUsuarioFactory extends PanelFactory {
    
    public PanelNuevoUsuarioFactory(VentanaPrincipal frame) {
        super(frame);
    }
    
    public JPanel crearPanel() {
        return new PanelCreacionUsuario(frameEstatico);
    }
}

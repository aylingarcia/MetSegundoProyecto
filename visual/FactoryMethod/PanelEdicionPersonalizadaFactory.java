package visual.FactoryMethod;

import javax.swing.JPanel;
import visual.PanelesEdicion.*;

public class PanelEdicionPersonalizadaFactory extends PanelFactory 
{
    public JPanel crearPanel() {
        return new Edicion();
    }
}
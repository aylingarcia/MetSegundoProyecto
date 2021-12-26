package visual.FactoryMethod;

import javax.swing.JPanel;

import visual.VentanaPrincipal;
import visual.PanelesAYUDA.*;

public class PanelAyudaMicrofonoFactory extends PanelAyudaFactory {
    public PanelAyudaMicrofonoFactory(VentanaPrincipal frame) {
        super(frame);
    }
    public JPanel crearPanel() {
        return new PanelAyudaMicrofono();
    }
}
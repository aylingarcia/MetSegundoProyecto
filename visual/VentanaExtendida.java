package visual;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaExtendida extends JFrame {
    public VentanaExtendida() {
        super("Ventana Extendida");
        crearVentana();
        setVisible(true);
    }
    private void crearVentana() {
        Container containerPane = getContentPane();
        
        JLabel label = new JLabel("este es tu label");
        containerPane.add(label);
        
        pack();
    }
}

package visual;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaP extends JFrame{
    private String title;
    private JPanel panelActual;
    private MiMenuBar menuBar;
    
    public VentanaP() {
        // constructor para tener un panel inicial?
    }

    public void setVentana(String titulo, JPanel panel) {
        setTitle(titulo);
        
        Container contenedora = super.getContentPane();
        if (panelActual != null) {
            remove(panelActual);
            panelActual = panel;
        }
        contenedora.add(panel);
        this.panelActual = panel;
        repaint();
        pack();
        if (!isActive()) {
            setVisible(true);
        }
    }

    public void agregarMenu(MiMenuBar menu) {
        if (menuBar!=null) {
            menuBar.removeAll();
        }
        menuBar = menu;
        setJMenuBar(menu);
        menuBar.setVentana(this);
        pack();
        repaint();
        if (!isActive())
            setVisible(true);
    }

    private void borrarLoQueHay() {
        removeAll();
    }
}

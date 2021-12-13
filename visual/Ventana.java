package visual;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ventana {
    private JFrame frame;
    public Ventana() {
        crearVentana();
    }
    
    private void crearVentana() {
        frame = new JFrame("Ventana");
        
        Container containerPane = frame.getContentPane();
        JLabel label = new JLabel("este es tu label");
        containerPane.add(label);
        
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        
        JMenu usuario = new JMenu("Usuario");
        menuBar.add(usuario);
        
        JMenuItem itemUsuario = new JMenuItem("Agregar");
        usuario.add(itemUsuario);
        
        frame.pack();
        frame.setVisible(true);
    }
}
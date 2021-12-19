package visual;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import paquetes.PaqueteListener.*;

public class MiMenuBar extends JMenuBar {
    private final String version = "1.0.1";
    
    private JMenu menu;
    private JMenuItem item;
    private ReconocedorVoz micro;
    private VentanaP actual;
    
    
    
    public MiMenuBar(boolean usuarioValido) {
        crearMenu(usuarioValido);
        micro = new ReconocedorVoz();
    }
    
    private void agregar() {
        menu.add(item);
    }
    
    private void crearMenu(boolean conUsuario) {
        menu = new JMenu("Inicio");
        item = new JMenuItem("Hacer Pedido");
        agregar();
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                // te lleva a la pantalla de inicio
            }
        });
        item = new JMenuItem("Cerrar");
        agregar();
        item.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                cerrarApp();
            }
        });
        add(menu);
        menu = new JMenu("Microfono");
        item = new JMenuItem("Habilitar");
        item.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                habilitarMicrofono();
            }
        });
        agregar();
        item = new JMenuItem("Desabilitar");
        item.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                desabilitarMicrofono();
            }
        });
        agregar();
        add(menu);
        if (conUsuario) {
            // aqui agregamos la opcion usuario
            menu = new JMenu("Usuario");
            item = new JMenuItem("Cerrar Sesion");
            agregar();
            item = new JMenuItem("Ver Cuenta");
            agregar();
            add(menu);
        }
        menu = new JMenu("Ayuda");
        item = new JMenuItem("Informacion");
        agregar();
        item.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                verInformacion();
            }
        });
        item = new JMenu("FAQ");
        JMenuItem item2 = new JMenuItem("Pedido");
        item.add(item2);
        item2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                abrirFAQ();
            }
        });
        item2 = new JMenuItem("Platillo");
        item.add(item2);
        item2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                abrirFAQ();
            }
        });
        item2 = new JMenuItem("Pedido Automatico");
        item.add(item2);
        item2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                abrirFAQ();
            }
        });
        item2 = new JMenuItem("Pedido Personalizado");
        item.add(item2);
        item2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                abrirFAQ();
            }
        });
        agregar();
        add(menu);
    }
    
    private void cerrarApp() {
        System.exit(0);
    }
    private void habilitarMicrofono() {
        try {
            micro.iniciar();
        } catch (javax.speech.EngineException ee) {}
    }
    private void desabilitarMicrofono() {
        micro.terminar();
    }
    public void verInformacion() {
        JOptionPane.showMessageDialog(null, "Version + "+ version + "\n NOMBRE DE LA APP");
    }
    
    private void abrirFAQ() {
        actual.setVentana("FAQ", new panelAyuda());
    }
    public void setVentana(VentanaP frame) {
        actual = frame;
    }
}

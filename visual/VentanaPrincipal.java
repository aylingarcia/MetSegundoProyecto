package visual;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import clases.*;

public class VentanaPrincipal extends JFrame {
    private final String version = "1.0.1";
    private JPanel panelActual;
    private ManejoEventos eventos;
    private Pedido pedido;

    public VentanaPrincipal() {
        eventos = new ManejoEventos(this);
        eventos.generarVentanaprincipal();
        crearMenu(false);
    }
    
    private void setPedido(Pedido p) {
        pedido = p;
    }
    
    public void setVentana(JPanel panel) {
        config();
        Container contenedora = getContentPane();
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

    public void crearMenu(boolean conUsuario) {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Inicio");
        JMenuItem item = new JMenuItem("Hacer Pedido");
        menu.add(item);
        item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    eventos.generarPanelTipoPedido();
                }
            });
            item = new JMenuItem("Iniciar Sesion");
            menu.add(item);
            item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    eventos.generarVentanaprincipal();
                }
            });
        item = new JMenuItem("Cerrar");
        menu.add(item);
        item.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae) {
                    eventos.cerrarApp();
                }
            });
        menuBar.add(menu);
        menu = new JMenu("Microfono");
        item = new JMenuItem("Habilitar");
        item.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae) {
                    eventos.habilitarMicrofono();
                }
            });
        menu.add(item);
        item = new JMenuItem("Desabilitar");
        item.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae) {
                    eventos.desabilitarMicrofono();
                }
            });
        menu.add(item);
        menuBar.add(menu);
        if (conUsuario) {
            // aqui agregamos la opcion usuario
            menu = new JMenu("Usuario");
            item = new JMenuItem("Cerrar Sesion");
            menu.add(item);
            item = new JMenuItem("Ver Cuenta");
            menu.add(item);
            menuBar.add(menu);
        }
        menu = new JMenu("Ayuda");
        item = new JMenuItem("Informacion");
        menu.add(item);
        item.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae) {
                    eventos.verInformacion();
                }
            });
        item = new JMenu("FAQ");
        JMenuItem item2 = new JMenuItem("Pedido");
        item.add(item2);
        item2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae) {
                    eventos.generarVentanaAyuda();
                }
            });
        item2 = new JMenuItem("Platillo");
        item.add(item2);
        item2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae) {
                    eventos.generarVentanaAyuda();
                }
            });
        item2 = new JMenuItem("Pedido Automatico");
        item.add(item2);
        item2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae) {
                    eventos.generarVentanaAyuda();
                }
            });
        item2 = new JMenuItem("Pedido Personalizado");
        item.add(item2);
        item2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae) {
                    eventos.generarVentanaAyuda();
                }
            });
        menu.add(item);
        menuBar.add(menu);
        item2 = new JMenuItem("Microfono");
        item.add(item2);
        item2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                eventos.generarVentanaAyudaMicrofono();
            }
        });
        setJMenuBar(menuBar);
        //config();
        recargarVentana();
    }

    private void borrarLoQueHay() {
        removeAll();
    }

    private void config() {
        setTitle("App");
        setLayout(new BorderLayout());

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        if (!isActive())
            setVisible(true);
        repaint();
        pack();
    }
    public void recargarVentana() {
        setLocationRelativeTo(null);
        setResizable(false);
        repaint();
        pack();
    }

    public String getVersion() {
        return version;
    }
    
    public void generarFactura(Pedido p) {
        eventos.generarFactura(p, u);
    }
}

package visual;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Dimension;

// la forma de cambiar una ventana a otra es:
// tenemos nuestra venta que contiene todo lo que necesitamos en un PANEL

public class Ventana 
    implements ActionListener
{
    private JFrame frame;
    private JMenuBar menu;
    public Ventana() {
        crearVentana();
    }
    
    public void actionPerformed(ActionEvent e) {
        System.out.println("esto es lo que paso" + e.getActionCommand());
    }
    
    private void crearVentana() {
        frame = new JFrame("Edicion de platillo");
        
        Container containerPane = frame.getContentPane();
        JLabel label = new JLabel("este es tu label");
        containerPane.add(label);
        crearMenu();
        frame.setJMenuBar(menu);
        
        // uso de botones 
        JPanel toolbar = new JPanel(new GridLayout(0, 1));
        JButton boton1 = new JButton("boton 1");
        JButton boton2 = new JButton("boton 2");
        toolbar.add(boton1);
        toolbar.add(boton2);
        
        boton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                maximizar();
            }
        });
        
        boton2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                minimizar();
            }
        });
        
        ///toolbar.setLayout(new GridLayout(0, 1));
        JPanel flow = new JPanel();        
        flow.add(toolbar);
        frame.add(flow, BorderLayout.WEST);
        
        //flow.setBorder(new EmptyBorder(0,0,10,0));
        
        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setBorder(new EmptyBorder(12,12,12,12));
        
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void crearMenu() {
        menu = new JMenuBar();
        JMenu opcion1 = new JMenu("File");
        JMenuItem item1Opcion1 = new JMenuItem("Abrir");
        JMenuItem item2Opcion1 = new JMenuItem("Cerrar");
        opcion1.add(item1Opcion1);
        opcion1.add(item2Opcion1);
        
        item1Opcion1.addActionListener(this);
        item2Opcion1.addActionListener(this);
        
        JMenu opcion2 = new JMenu("Usuario");
        JMenuItem item1Opcion2 = new JMenuItem("Cerrar Sesion");
        opcion2.add(item1Opcion2);
        
        item1Opcion2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        }
        );
        
        JMenu help = new JMenu("Help");
        JMenuItem info = new JMenuItem("informacion");
        JMenu otro = new JMenu("dentro");
        JMenuItem i1 = new JMenuItem("dkfaj");
        JMenu otro2 = new JMenu("fjkal");
        otro.add(otro2);
        otro2.add(i1);
        help.add(info);
        help.add(otro);
        
        // agregamos los menu dentro del menu grande
        menu.add(opcion1);
        menu.add(opcion2);
        menu.add(help);
    }
    
    private void maximizar() {
        // maximiza un panel
        frame.pack();
    }
    private void minimizar() {
        //minimiza un panel
        frame.pack();
    }
    
    // manejo de eventos (Event-handling)
}
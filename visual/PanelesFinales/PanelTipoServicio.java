package visual.PanelesFinales;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import visual.VentanaPrincipal;
import visual.PanelesEdicion.*;

public class PanelTipoServicio extends JPanel {
    private VentanaPrincipal frame;

    public PanelTipoServicio(VentanaPrincipal frameContenedor) {
        initComponents();
        frame = frameContenedor;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        botonAutoServicio     = new JButton();
        botonPersonalizado     = new JButton();
        label                 = new JLabel();


        label.setFont(new Font("Tw Cen MT", 2, 14));
        label.setText("TIPO DE SERVICIO DESEADO");

        botonAutoServicio.setText(" Auto-servicio ");
        botonPersonalizado.setText(" Servicio personalizado ");

        botonAutoServicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                cambiarPanel(false);
            }
        });

        botonPersonalizado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                cambiarPanel(true);
            }
        });

        GroupLayout layout = new GroupLayout(this);

        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(botonAutoServicio)
                        .addGap(96, 96, 96)
                        .addComponent(botonPersonalizado))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(label, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(label, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAutoServicio)
                    .addComponent(botonPersonalizado))
                .addContainerGap(150, Short.MAX_VALUE))
        );
    }

    public void cambiarPanel(boolean personalizado) {
        if (personalizado)
            frame.setVentana(new PanelEdicionPersonalizado());
        else
            frame.setVentana(new Edicion());
    }

    // variables 
    private JButton botonAutoServicio;
    private JButton botonPersonalizado;
    private JLabel     label;
}
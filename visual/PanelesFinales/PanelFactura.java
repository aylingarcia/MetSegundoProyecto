package visual.PanelesFinales;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JLabel.*;

import clases.*;

public class PanelFactura extends JPanel {
    private final String TITULO = "Factura";

    /**
     * @param pedido = se necesita un pedido para poder saber 
     *     lo que se mostrara dentro del panel 
     * @param datos = son los datos adicionales necesarios 
     *     dentro de la Factura, nombre, direccion etc.
     */ 
    public PanelFactura(Pedido pedido, String ... datos) {
        initComponents();
    }

    public void initComponents() {
        labelDespedida= new JLabel();
        panel1 =         new JPanel();
        scrollPane =     new JScrollPane();
        tabla =         new JTable();
    
        
        setBackground(new Color(255, 204, 204));
        tabla.setModel(
            new DefaultTableModel(
                new Object[][] {
                    {null, null, null}, 
                    {null, null, null}, 
                    {null, null, null}
                }, 
                new String[] {
                    "costo comida ", "costo delivery", "Total"
                }
                ) {
                    Class[] types = new Class[] {
                        String.class, String.class, String.class
                    };
                    public Class getColumnClass(int index) {
                        return types[index];
                    }
                }
            );
        scrollPane.setViewportView(tabla);

        panel1.setBorder(BorderFactory.createTitledBorder(null, "Factura", 
            TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Century", 0, 14)));
        GroupLayout panel1Layout = new GroupLayout(panel1);
        panel1.setLayout(panel1Layout);

        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );

        panel2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        labelDespedida.setText("GRACIAS por su preferencia, disfrute su pedido");
        labelDespedida.setBackground(new Color(255, 153, 0));
        labelDespedida.setFont(new Font("Constantia", 0,14));
        labelDespedida.setForeground(new Color(102,102,102));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelDespedida, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(156, Short.MAX_VALUE)
                .addComponent(labelDespedida, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
    }

    // variables 
    private JLabel         labelDespedida;
    private JPanel         panel1;
    private JScrollPane scrollPane;
    private JTable         tabla;
    private JPanel         panel2;
}


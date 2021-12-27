package visual.PanelesFinales;

import java.awt.*;
import javax.swing.*;

import clases.*;

public class V extends JFrame {
    public V(JPanel p) {
        initComponents(p);
    }

    private void initComponents(JPanel p) {
        Container container = getContentPane();
        container.add(p);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        try{
            Pedido pedido = new Pedido();
            Platillo p = new Platillo(null);
            p.insertarComponente(new Componente("nombre", "disponible", 50));
            pedido.agregarPlatillo(p);
            EdicionPedido panel = new EdicionPedido(pedido, null);
            Thread hilo = new Thread() {

                    public void run() {
                        V aux = new V(panel);
                    }
                };
        } catch (Exception e) {e.printStackTrace();}
    }
}

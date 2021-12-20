package visual;

import visual.PanelesAYUDA.*;
import visual.PanelesFinales.*;

import clases.*;

import java.awt.*;
import javax.swing.*;

import paquetes.PaqueteListener.*;

public class ManejoEventos {
    private VentanaPrincipal frame;
    private Thread escucha;
    private ReconocedorVoz microfono;
    
    public ManejoEventos(VentanaPrincipal ventana) {
        frame = ventana;
    }
    public void ejecutar(String a) {
        switch (a){
            case "ayuda": 
                generarVentanaAyuda();
                break;
            case "inicio":
                generarVentanaprincipal();
                break;
            case "cerrar" :
                cerrarApp();
                break;
            case "pedido automatico":
                
            case "pedido personalizado":
                
            case "editar pedido":
                
            case "editar platillo":
                
            default: 
                generarVentanaAyudaMicrofono();
                break;
        }
    }

    public void generarVentanaAyuda() {
        JPanel panel = new PanelAyuda();
        frame.setVentana(panel);
    }

    public void generarVentanaprincipal() {
        return;
    }
    
    public void generarPanelPlatillo() {
        JPanel panel = new PanelComponente(new Componente(null, null, 0));
        frame.setVentana(panel);
    }

    public void cerrarApp() {
        System.exit(0);
    }

    public void habilitarMicrofono() {
        if (escucha.isAlive())
            desabilitarMicrofono();
        escucha = new Thread(microfono= new ReconocedorVoz(this));
        escucha.start();
        microfono.run();
    }

    public void desabilitarMicrofono() {
        if (escucha.isAlive()) {
            escucha.stop();
        }
    }
    public void generarVentanaAyudaMicrofono() {
        JPanel panel = new PanelAyudaMicrofono();
        frame.setVentana(panel);
    }

    public void verInformacion() {
        JOptionPane.showMessageDialog(null, "Version + "+ frame.getVersion() + "\n NOMBRE DE LA APP");
    }
}

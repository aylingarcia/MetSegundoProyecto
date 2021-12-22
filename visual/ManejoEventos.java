package visual;

import visual.PanelesAYUDA.*;
import visual.PanelesFinales.*;
import visual.PanelesEdicion.*;
import java.io.IOException;

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
        JPanel panel = new PanelTipoServicio(frame);
        frame.setVentana(panel);
    }

    public void generarPanelPlatillo() {
        JPanel panel = new PanelComponente(new Componente(null, null, 0));
        frame.setVentana(panel);
    }

    public void cerrarApp() {
        System.exit(0);
    }

    public void habilitarMicrofono() {
        try {
            if (escucha !=null)
                escucha.stop();
            escucha = new Thread(microfono= new ReconocedorVoz(this));
            escucha.start();
            microfono.run();
        } catch (IOException ioe) {}
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

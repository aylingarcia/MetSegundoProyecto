package visual;

import visual.FactoryMethod.*;
import java.io.IOException;

import clases.*;

import java.awt.*;
import javax.swing.*;

import paquetes.PaqueteListener.*;

import visual.ventanas.*;

public class ManejoEventos {
    private VentanaPrincipal frame;
    private Thread escucha;
    private ReconocedorVoz microfono;
    private PanelFactory factoryPanel;

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

            case "crear usuario":
                generarPanelCreacionUsuario();
                break;
            default: 
                generarVentanaAyudaMicrofono();
                break;
        }
    }

    public void generarVentanaAyuda() {
        factoryPanel = new PanelAyudaFactory(frame);
        frame.setVentana(factoryPanel.crearPanel());
    }

    public void generarVentanaprincipal() {
        factoryPanel = new PanelInicioFactory(frame);
        frame.setVentana(factoryPanel.crearPanel());
    }

    public void generarPanelTipoPedido() {
        factoryPanel = new PanelTipoServicioFactory(frame);
        frame.setVentana(factoryPanel.crearPanel());
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
        } catch (IOException ioe) {}
    }

    public void generarPanelCreacionUsuario() {
        factoryPanel = new PanelNuevoUsuarioFactory(frame);
        frame.setVentana(factoryPanel.crearPanel());
    }

    public void desabilitarMicrofono() {
        if (escucha.isAlive()) {
            escucha.stop();
            microfono.terminar();
        }
    }

    public void generarVentanaAyudaMicrofono() {
        factoryPanel = new PanelAyudaMicrofonoFactory(frame);
        frame.setVentana(factoryPanel.crearPanel());
    }

    public void verInformacion() {
        JOptionPane.showMessageDialog(null, "Version + "+ frame.getVersion() + "\n NOMBRE DE LA APP");
    }

    public void generarFactura() {
        factura.main(new String[]{});
    }
}

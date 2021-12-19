package paquetes.PaqueteListener;

import javax.speech.*;
import javax.speech.recognition.*;

import java.awt.*;
import javax.swing.*;

/**
 * esta clase se ocupa de realizar acciones para todas 
 * las palabras que nuestro reconocedor capte 
 */

public class EventoSonidos extends ResultAdapter{
    private static ReconocedorVoz reconocedor;
    private String accion;
    
    public void resultAcepted(ResultEvent re) {
        Result res = (Result)(re.getSource());
        ResultToken tokens[] = res.getBestTokens();
        String Frase[]= new String[1];
        Frase[0]="";

        for (int i=0; i < tokens.length; i++){
            accion = tokens[i].getSpokenText();
            Frase[0]+= accion + " "; 
        }
        if (accion.equals("Pedido Automatico")) {
            // aqui debe abrir la ventana que se pidio 
        } else if(accion.equals("Pedido Personalizado")) {
            // qui debe abrir la ventana que se pidio
        } else {
            JOptionPane.showMessageDialog(null, "no existe ese tipo");
        }
    }
}

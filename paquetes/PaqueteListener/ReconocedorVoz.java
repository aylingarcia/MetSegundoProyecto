package paquetes.PaqueteListener;

import javax.speech.Central;
import javax.speech.EngineModeDesc;
import javax.speech.recognition.*;
import java.io.File;

import javax.speech.*;

import java.io.IOException;
import java.io.FileReader;

import java.util.Locale;

import visual.*;

import javax.swing.JOptionPane;

import paquetes.BaseDatos.*;

public class ReconocedorVoz extends ResultAdapter implements Runnable {
    // dada una Ventana Especifica entonces: se agregar opciones especificas
    static Recognizer reconocedorVoz;
    private ManejoEventos eventos;
    private final FileReader gramaticaEstatica;
    private RuleGrammar gramatica;
    private final String path;

    public ReconocedorVoz(ManejoEventos m) throws IOException{
        eventos = m;
        path = new File("").getAbsolutePath()+"/paquetes/PaqueteListener/RuleGrammars";
        gramaticaEstatica = new FileReader(path+"/diccionario.txt");
    }

    @Override
    public void resultAccepted(ResultEvent re) {
        try {
            Result res = (Result)(re.getSource());
            ResultToken tokens[] = res.getBestTokens();
            for (int i=0; i < tokens.length; i++){
                String accion = tokens[i].getSpokenText();
                eventos.ejecutar(accion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void iniciar(String nombreArchivo) {
        try {
            reconocedorVoz = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
            reconocedorVoz.allocate();

            //FileReader gramatica = new FileReader("diccionario.txt");

            RuleGrammar reglaGramatica = reconocedorVoz.loadJSGF(gramaticaEstatica);
            reglaGramatica.setEnabled(true);

            reconocedorVoz.addResultListener(new ReconocedorVoz(eventos));
            reconocedorVoz.commitChanges();
            reconocedorVoz.requestFocus();            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error: " + e.getMessage());
        }
    }

    public void recargarGramatica(String nombreArchivo) {
        try {
            FileReader gramatica = new FileReader(nombreArchivo+".txt");

        } catch (Exception e) {}

    }

    public void terminar() {
        try {
            reconocedorVoz.deallocate();
        } catch (Exception e) {
        }
    }

    @Override
    public void run() {
        iniciar("");
    }
}
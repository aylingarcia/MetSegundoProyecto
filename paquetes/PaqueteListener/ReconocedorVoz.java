package paquetes.PaqueteListener;

import javax.speech.Central;
import javax.speech.EngineModeDesc;
import javax.speech.recognition.*;

import java.io.IOException;
import java.io.FileReader;

import java.util.Locale;

import visual.*;

import javax.swing.JOptionPane;

import paquetes.BaseDatos.*;

public class ReconocedorVoz extends ResultAdapter implements Runnable {
    static Recognizer reconocedorVoz;
    private ManejoEventos eventos;

    public ReconocedorVoz(ManejoEventos m) {
        eventos = m;
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

    public void iniciar() {
        try {
            reconocedorVoz = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
            reconocedorVoz.allocate();

            FileReader gramatica = new FileReader("diccionario.txt");

            RuleGrammar reglaGramatica = reconocedorVoz.loadJSGF(gramatica);
            reglaGramatica.setEnabled(true);

            reconocedorVoz.addResultListener(new ReconocedorVoz(eventos));
            reconocedorVoz.commitChanges();
            reconocedorVoz.requestFocus();            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error: " + e.getMessage());
        }
    }

    public void terminar() {
        try {
            reconocedorVoz.deallocate();
        } catch (Exception e) {
        }
    }

    @Override
    public void run() {
        iniciar();
    }
}
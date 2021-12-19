package paquetes.PaqueteListener;

import javax.speech.*;
import javax.speech.recognition.*;

import java.io.IOException;
import java.io.FileReader;

import java.util.Locale;

public class ReconocedorVoz {
    private static Recognizer reconocedor;
    
    public void iniciar() throws EngineException {
        reconocedor = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));

        reconocedor.allocate();
        try {
            FileReader gramatica =new FileReader("diccionario.txt");

            RuleGrammar rg = reconocedor.loadJSGF(gramatica);
            rg.setEnabled(true);

            reconocedor.addResultListener(new EventoSonidos());

            reconocedor.commitChanges();
            reconocedor.requestFocus();
            reconocedor.resume();
        } catch (java.io.FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (GrammarException ge) {
            ge.printStackTrace();
        } catch (AudioException ae) {
            ae.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    public void terminar() {
        try {
            reconocedor.deallocate();
        } catch (EngineException ee) {
            ee.printStackTrace();
        }
    }
}
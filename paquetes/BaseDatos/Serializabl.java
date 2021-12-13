package PaqueteBD;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

/**
 * tenemos que tener en cuenta los siguienets aspectos:
 * 1. dado un tipo de lista podamos almacenarla
 * 2. un archivo guardado debe poder abrise y compilar las clases 
 * PARA EL USO DE LA SERIALIZACION LA CLASE SERIALIZABLE DEBE SER DE TIPO SERIALIZABLE.
 * OTRO POSIBLE CASO ES CREAR UN CLASE DATOS DE TIPO CONTENEDORA O ENVOLTORIA QUE EXTIENDA LA CLASE SERIALIZABLE
 * Todos los atributos deben ser serializables!! 
 * */
// .ser .bin .txt?
//transforma a un flujo de bytes
class Serializabl {
    private FileOutputStream  outputFile;
    private FileInputStream  inputFile;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    public void serializar(String path, ArrayList<Object> o) {
        try {
            openOutput(path);
            for (int i = 0; i<o.size(); i++) {
                output.writeObject(o.get(i));
            }
        } catch (IOException e) {}
    }

    public void serializar(String path, Object o) {
        try {
            File f = new File(path);
            if (f.length()==0) {
                openOutput(path);
                output.writeObject(o);
                closeOutput();
            } else {
                FileOutputStream outputFile = new FileOutputStream(path, true);
                MiObjetoObjectOutputStream miOb = new MiObjetoObjectOutputStream(outputFile);
                miOb.writeObject(o);
                miOb.close();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public ArrayList<Object> read(String path) {
        Object d = null;
        ArrayList<Object> lista = new ArrayList<>();
        try {
            if (output!=null) {
                openInput(path);
                do {
                    d = (Object)input.readObject();
                    lista.add(d);
                }while(d!=null);
            }
        } catch (IOException ioe) {
            
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        return lista;
    }

    private void openOutput(String path) throws IOException {
        outputFile = new FileOutputStream(path,false);
        output = new ObjectOutputStream(outputFile);
    }

    private void openInput(String path) throws IOException {
        inputFile = new FileInputStream(path);
        input = new ObjectInputStream(inputFile);
    }

    private void closeOutput() throws IOException {
        if (output!=null) output.close();
    }

    private void closeInput() throws IOException {
        if (input!=null) input.close();
    }
}

class MiObjetoObjectOutputStream extends ObjectOutputStream {
    public MiObjetoObjectOutputStream(OutputStream out) throws IOException{
        super(out);
    }
    @Override
    public void writeStreamHeader() throws IOException {
        return;
    }
}
package paquetes.BaseDatos;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;


import java.util.ArrayList;
import java.util.List;



class XMLBeans {
    // extension .xml y .dtd
    // crea directamente un xml schema no es necesario el uso de dtd y xml solo el xml contiene toda la informacion.
    // al escribir sobre el archivo las varialbes deben ser publicas o talvez tener private y get y set
    
    // un archivo xml bean en java tiene su propia syntaxis
    /**
     * que representan todos los elemntos de un objeto bean 
     * <java></java> y <object></object> especiales
     */
    public void write(List o, String path) {
        OutputStream out; 
        try { 
            out = new FileOutputStream(path);
            BufferedOutputStream buffer = new BufferedOutputStream(out);
            java.beans.XMLEncoder encoder = new XMLEncoder(buffer); 
            for(int i = 0; i<o.size(); i++) {
                encoder.writeObject(o.get(i));
            }
            encoder.close(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    }

    public ArrayList<Object> read(String path)  
    throws FileNotFoundException, IOException, Exception 
    { 
        ArrayList<Object> objList = new ArrayList();     
        File file = new File(path); 
        FileInputStream fileIS = new FileInputStream(file); 
        BufferedInputStream buffer = new BufferedInputStream(fileIS);
        XMLDecoder decoder = new XMLDecoder(buffer); 
        Object obj = null; 
        try { 
            while( (obj = decoder.readObject()) != null) 
            { 
                objList.add(obj); 
            } 
        } catch (Exception e) {
        } 
        fileIS.close(); 
        decoder.close();      
        return objList; 
    } 
    
    public void add(Object o, String path) {
        try {
            List aux = (ArrayList)read(path);
            aux.add(o);
            write(aux, path);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {}
        
    }
}
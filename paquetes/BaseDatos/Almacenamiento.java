package paquetes.BaseDatos;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

class Almacenamiento {
    private Serializabl     ser;
    private TextoPlano      tPlano;
    private XMLBeans        tFormato;
    private XML             xml;
    private RegularExp      reg;

    public Almacenamiento() {
        ser = new Serializabl();
        tFormato = new XMLBeans();
        tPlano = new TextoPlano();
        xml = new XML();
        reg = new RegularExp();
    }

    public void almacenar(String path, List o) {
        try {
            if(reg.verifySerializable(path)) {
                this.ser.serializar(path, o);
            } else if(reg.verifyXML(path)) {
                this.tFormato.write(o, path);
            }
        } catch (Exception e) {
            System.out.println("hubo un error con la direccion");
        }
    }

    public void almacenarSF(String path, ArrayList<String[]> o, String[] e) {
        try {
            this.tPlano.write(path, o, true, e);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void almacenarXML(Object ob, String path) {
        xml.buildXML(ob, path);
    }

    public ArrayList<Object> read(String path) {
        if(reg.verifySerializable(path)) {
            return ser.read(path);
        } else if(reg.verifyXML(path)) {
            try {
                return this.tFormato.read(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public ArrayList<String[]> readTPlano(String path) {
        return this.tPlano.read(path);
    }

    public void agregar(String path, Object o) {
        try {
            if(reg.verifySerializable(path)) {
                this.ser.serializar(path, o);
            } else if(reg.verifyXML(path)) {
                this.tFormato.add(o, path);
            }
        } catch (Exception e) {}
    }

    public void agregarSF(String path, ArrayList<String[]> o) {
        try {
            this.tPlano.add(path, o);
        } catch (Exception e) {}
    }

}

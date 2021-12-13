package PaqueteBD;

import java.util.ArrayList;
import java.util.List;

import java.io.*;

/***
 * @author Alexander James ALvarez Rojas
 * */
public class Main
{
    private Almacenamiento almacenamiento= new Almacenamiento();
    private String path;
    // debemos hacer el uso de fields
    // se necesita el uso de un objeto auxiliar 
    public Main(String p) {
        setPath(p);
    }

    public Main() {
        path = "";
    }

    /**
     * el almacenamiento puede guardar estrcuturas de 2 formas:
     * 1. guardar un objeto 
     * 2. guardar una estructura de objetos, se perdera la estrcutura y se tendra que reconstruir a la hora de recuperarla.
     *      existen algunas complicaciones a la hora de realizar el almacenamiento :
     *      1 si se quiere serializar la estructura la calse debe implementar Serializable
     *      2 si se quiere almacenar de otra manera entonces tenemos 2 posibles casos:
     *          las variables internas deben ser publicas para poder hacer las estructuras 
     *          caso contrario es posible que se tenga que realizar una serializacion del objecto para no perder ningun tipo de informacion
     * 3. Al tener un XML se tendra el siguiente formato: Reflexion para poder ver todos los fields y poderlos plasmar
     * en caso de que no podamos reconstruir el objeto se opta por serializarlo
    4. guardar en un texto plano significa tener una lista y no exactamente un objeto 
    de 'n' parametros pero de tipo String o tipo variables int boolean entre otros.
    si se diera un objeto la forma de manejarlo seria la misma a la xml con las restricciones mostradas
     * recuperar una estructura nos devuelve en todo caso una estructura Object[] se tendra que castear y convertir a la estructura deseada
     * pero si la estructura ingresada fue de tipo mapa nos devuelve una estructura de tipo ArrayList
     */
    public void saveEstructureWithoutFormat(List<Object[]> l, String[] eti, String fileName) {
        if (!empty()) {
            ArrayList<String[]> lista = new ArrayList<>();
            for (Object[] li: l) {
                String[] fila = new String[li.length];
                for (int i = 0; i<li.length;i++) {
                    fila[i] = li[i].toString();
                }
                lista.add(fila);
            }
            almacenamiento.almacenarSF(path+fileName, lista, eti);
        }
    }

    public void saveEstructureXMLBeans(List o, String fileName){
        almacenamiento.almacenar(path+fileName, o);
    }

    public void saveEstructureXML(Object o, String fileName) {
        almacenamiento.almacenarXML(o, path+fileName);
    }

    public void saveEstructureSerializable(List l, String fileName) {
        if(!empty()) {
            almacenamiento.almacenar(path+fileName, l);
        }
    }

    public void saveObjectWFormat(Object o, String fileName) {
        if(!empty()) {
            String route = path+fileName;
            almacenamiento.agregar(route, o);
        }
    } 
    
    public void saveObjectXMLBeans(String fileName, Object o) {
        if(!empty()) {
            almacenamiento.agregar(path+fileName, o);
        }
    }

    public void saveObjectSerializable(String fileName, Object o) {
        if(!empty() && (verificarSerializable(o))) {
            almacenamiento.agregar(path+fileName, o);
        }
    }

    public List read(String fileName) {
        if(!empty()) {
            String route = path+fileName; 
            try {
                return almacenamiento.read(route);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public ArrayList<String[]> readWFormat(String fileName) {
        if(!empty()){
            return almacenamiento.readTPlano(path+fileName);
        }
        return null;
    }

    public <E>ArrayList<E> convert(List lista, Class<E> c) {
        ArrayList<E> list = new ArrayList<>();
        try {
            for (int i=0; i<lista.size();i++) {
                list.add(((E)lista.get(i)));
            }
        } catch (ClassCastException cce) {
            cce.printStackTrace();
        }
        return list;
    }

    private boolean verificarSerializable(Object o) {
        Class[] x = o.getClass().getInterfaces();
        for (int i = 0; i<x.length; i++) {
            if(x[i].equals(Serializable.class))
                return true;
        }
        return false;
    }

    private boolean empty() {
        return (path==null);
    }

    public void setPath(String p) {
        try {
            RegularExp reg = new RegularExp();
            reg.verifyPath(p);
            this.path = p;
        } catch (Exception e) {
            System.out.println("la ruta no es valida, debe terminar con '/'");
        }
    }

    public String getPath() {
        return path;
    }
}
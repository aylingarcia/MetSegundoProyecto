package paquetes.BaseDatos;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.*;
import org.w3c.dom.*;

import java.io.File;
import java.io.FileOutputStream;

import java.util.List;
import java.util.ArrayList;

import clases.*;


public class XMLStream {
    private DocumentBuilderFactory factory;
    private DocumentBuilder docBuilder;
    private Document doc;
    private final String pathComponentes = "guardados/Componentes.xml";
    private final String pathPlatillos = "guardados/Platillos.xml";

    public XMLStream() {
        factory = DocumentBuilderFactory.newInstance();
    }

    public ArrayList<Platillo> readPlatillo() {
        ArrayList<Platillo> lista = new ArrayList();
        try {
            File file = new File(pathPlatillos);

            docBuilder = factory.newDocumentBuilder();
            doc = docBuilder.parse(file);

            doc.getDocumentElement().normalize();
            NodeList nodePlatillo = doc.getElementsByTagName("platillo");
            Platillo aux = null;
            
            for (int j = 0; j<nodePlatillo.getLength(); j++) {
                //System.out.println(nodePlatillo.item(j).getChildNodes());
                Element element = (Element)nodePlatillo.item(j);
                String titulo = element.getAttribute("titulo");
                aux = new Platillo(titulo);
                NodeList nList = element.getElementsByTagName("componente");
                //System.out.println(nList);
                for (int i = 0; i<nList.getLength() ; i++) {
                    //System.out.println(nList);
                    Node node = nList.item(i);
                    aux.insertarComponente(rescatarComponente(node));
                }
                lista.add(aux);
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return lista;
    }

    public ArrayList<Componente> readComponente() {
        ArrayList<Componente> lista = new ArrayList();
        try {
            File file = new File(pathComponentes);
            docBuilder = factory.newDocumentBuilder();
            doc = docBuilder.parse(file);

            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("componente");
            for (int i = 0; i<nList.getLength() ; i++) {
                Node node = nList.item(i);
                lista.add(rescatarComponente(node));
            }
        } catch (Exception ioe) {
        }
        return lista;
    }

    private Componente rescatarComponente(Node node) {
        String nombre = "";
        String estado = "";
        double costo = 0;
        try {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element)node;
                nombre = element.getElementsByTagName("nombre").item(0)
                    .getChildNodes().item(0).getNodeValue();
                //nombre = element.getElementsByTagName("nombre").item(0).getTextContent();
                estado = element.getElementsByTagName("estado").item(0)
                    .getChildNodes().item(0).getNodeValue();
                
                costo = Double.parseDouble(element.getElementsByTagName("costo").item(0)
                    .getChildNodes().item(0).getNodeValue());
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return new Componente(nombre, estado, costo);
    }
}

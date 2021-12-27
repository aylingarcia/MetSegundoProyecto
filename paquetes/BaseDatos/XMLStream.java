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

    public void write(String path, List<Object[]> listObj, String[] eti) {
        Document dom;
        Element element = null;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = factory.newDocumentBuilder();
            dom = db.newDocument();
            if(eti.length!=listObj.get(0).length) {
                throw new Exception();
            }
            Element rootEle = dom.createElement("datos");
            for (int j = 0; j<listObj.size();j++) {
                Element rootElement = dom.createElement("object" + j);
                for (int i = 0; i<listObj.get(0).length;i++) {
                    element = dom.createElement(eti[i]);
                    element.appendChild(dom.createTextNode(listObj.get(j)[i].toString()));
                }
                rootElement.appendChild(element);
            }
            dom.appendChild(rootEle);

            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.setOutputProperty(OutputKeys.METHOD, "xml");
            t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            t.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, path+".dtd");
            t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", (listObj.size()+""));

            t.transform(new DOMSource(dom), 
                new StreamResult(new FileOutputStream(path)));
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException te) {
            te.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Error with length of elements and labels");
        }
    }

    public void writePlatillos(Platillo p) {

    }

    public ArrayList<Platillo> readPlatillo() {
        ArrayList<Platillo> lista = new ArrayList();
        try {
            File file = new File(pathPlatillos);

            docBuilder = factory.newDocumentBuilder();
            doc = docBuilder.parse(file);

            doc.getDocumentElement().normalize();
            NodeList nodePlatillo = doc.getElementsByTagName("platillo");
            String titulo = doc.getFirstChild().getNodeValue();
            Platillo aux = new Platillo(titulo);
            
            for (int j = 0; j<nodePlatillo.getLength(); j++) {
                System.out.println(nodePlatillo.item(j));
                Node nodo = nodePlatillo.item(j);
                NodeList nList = ((Element)nodo).getElementsByTagName("componente");
                System.out.println(nList);
                for (int i = 0; i<nList.getLength() ; i++) {
                    System.out.println(nList);
                    Node node = nList.item(i);
                    aux.insertarComponente(rescatarComponente(node));
                }
                lista.add(aux);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        int costo = 0;
        try {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element)node;
                nombre = element.getElementsByTagName("nombre").item(0).getNodeValue();
                //nombre = element.getElementsByTagName("nombre").item(0).getTextContent();
                estado = element.getElementsByTagName("estado").item(0).getNodeValue();
                costo = Integer.valueOf(element.getElementsByTagName("costo").item(0).getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Componente(nombre, estado, costo);
    }
}

package paquetes.BaseDatos;

import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;


import org.w3c.dom.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

class XMLStream {
    /*
    public void write(String path, List<Object[]> listObj, String[] eti) {
        Document dom;
        Element element = null;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
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

    public List read(String path, String tag, String tags[]) {
        ArrayList<String[]> lista = new ArrayList<>();
        try {
            File file = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName(tag);

            for (int i = 0; i<nList.getLength(); i++) {

                Node nNode = nList.item(temp);
                String[] aux = new String[tags.length];
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;
                    for (int j = 0; j<tags.length; j++) {
                        String a = element.getElementsByTagName(tags[j]).getTextContent();
                        aux[j] = a;
                    }
                    lista.add(aux);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }*/
}

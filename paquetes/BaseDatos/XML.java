package paquetes.BaseDatos;

import java.util.ArrayList;
import java.util.List;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;

import javax.xml.bind.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XML {

    public void buildXML(Object o, String path) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(o.getClass());
            
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            File file = new File(path);
            FileOutputStream f = new FileOutputStream(path);
            jaxbMarshaller.marshal(o, f);
        } catch (JAXBException jaxbe) {
            jaxbe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public <E>E readXML(String path, Class<E> e) {
        File xmlFile;
        JAXBContext jaxbContext;
        try {
            xmlFile = new File(path);
            jaxbContext = JAXBContext.newInstance(e);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (E)(jaxbUnmarshaller.unmarshal(xmlFile));
        } catch (JAXBException jaxbe) {
            jaxbe.printStackTrace();
        } catch (ClassCastException cce) {
            cce.printStackTrace();
        }
        return null;
    }
}
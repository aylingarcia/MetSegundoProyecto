package PaqueteBD;
import javax.xml.bind.annotation.*;

@XmlRootElement
class Objeto<E> {
    private E elemento;
    public Objeto(E e) {
        this.elemento = e;
    }
    public E getObjeto() {
        return elemento;
    }
    
    @XmlElement
    public void setElemento(E elemento) {
        this.elemento = elemento;
    }
}
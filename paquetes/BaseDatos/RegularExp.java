package PaqueteBD;

import java.util.regex.*;

class RegularExp {
    /**
     * 1 hace referencia a texto plano
     * 2 hace referencia a texto con formato 
     * 3 hace referencia a tipo serizliable
     */
    private Pattern p; 
    private Matcher m;
    
    public boolean verifyCSV(String cad) {
        p = Pattern.compile(".+\\.csv$");
        m = p.matcher(cad.toLowerCase());
        return m.matches();
    }
    
    public boolean verifyExt(String cad) {
        p = Pattern.compile("/.+\\.[a-z]{2,4}$");
        m = p.matcher(cad.toLowerCase());
        return m.matches();
    }
    
    public void verifyPath(String path) throws Exception {
        p = Pattern.compile(".+\\/$");
        m = p.matcher(path);
        // la ruta debe ser de tipo /alfo/adkf/
        // si se diera lo contrario seria un escape y lo detecta el compilador no es necesario verlo.
        if(!m.matches())     throw new Exception();
    }
    
    public boolean verifyXML(String path) {
        p = Pattern.compile(".+\\.xml$");
        m = p.matcher(path.toLowerCase());
        return m.matches();
    }
    
    public boolean verifySerializable(String path) {
        p = Pattern.compile(".+\\.bin$");
        m = p.matcher(path.toLowerCase());
        if(!m.matches()) {
            p = Pattern.compile(".+\\.ser$");
        }
        m = p.matcher(path.toLowerCase());
        if(!m.matches()) {
            p = Pattern.compile(".+\\.txt$");
        }
        m = p.matcher(path.toLowerCase());
        return m.matches();
    }
}

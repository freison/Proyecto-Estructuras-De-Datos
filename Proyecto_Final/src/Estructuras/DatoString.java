
package Estructuras;

public class DatoString extends Dato {
    // ATRIBUTOS DE LA CLASE.
    private String cadena;
    private String[] cadenas;
    
    // CONSTRUCTOR.
    public DatoString(){
        this.cadena = "";
        this.cadenas = new String[2];
        // super.setIndice(-1);
    }
    
    // GETTERS Y SETTERS.
    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public String[] getCadenas() {
        return cadenas;
    }

    public void setCadenas(String[] cadenas) {
        this.cadenas = cadenas;
    }
}


package Estructuras;

public class DatoString extends Dato {
    // ATRIBUTOS DE LA CLASE.
    private String cadena;
    
    // CONSTRUCTOR.
    public DatoString(){
        this.cadena = "";
        // super.setIndice(-1);
    }
    
    // GETTERS Y SETTERS.
    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
}

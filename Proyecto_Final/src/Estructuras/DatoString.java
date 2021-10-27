
package Estructuras;

public class DatoString extends Dato {
    // ATRIBUTOS DE LA CLASE.
    private String cadena;
    private int indice;
    
    // CONSTRUCTOR.
    public DatoString(){
        this.cadena = "";
        this.indice = -1;
    }
    
    // GETTERS Y SETTERS.
    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
}

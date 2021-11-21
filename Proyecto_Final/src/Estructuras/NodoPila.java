
package Estructuras;

public class NodoPila {
    // ATRIBUTOS DE LA CLASE.
    private Dato elemento;
    private NodoPila siguiente;
    private int indice;
    
    // CONSTRUCTOR.
    public NodoPila(){
        this.siguiente = null;
    }
    
    // GETTERS Y SETTERS.
    public Dato getElemento() {
        return elemento;
    }

    public void setElemento(DatoString elemento) {
        this.elemento = elemento;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }
    
    public int getIndice(){
        return this.indice;
    }
    
    public void setIndice(int indice){
        this.indice = indice;
    }
}

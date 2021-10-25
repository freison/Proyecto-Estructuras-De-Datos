
package Estructuras;

public class NodoPila {
    // ATRIBUTOS DE LA CLASE.
    private DatoString elemento;
    private NodoPila siguiente;
    
    // CONSTRUCTOR.
    public NodoPila(){
        this.siguiente = null;
    }
    
    // GETTERS Y SETTERS.
    public DatoString getElemento() {
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
}

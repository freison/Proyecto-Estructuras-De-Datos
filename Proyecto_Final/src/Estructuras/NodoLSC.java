
package Estructuras;

public class NodoLSC {
    // ATRIBUTOS DE LA CLASE.
    private Dato elemento;
    private NodoLSC siguiente;
    private int indice;
    
    // Constructor sin parametros.
    public NodoLSC(){
        this.siguiente = null;
        this.indice = 0;
    }
    
    // GETTERS Y SETTERS DE LA CLASE.
    public Dato getElemento() {
        return elemento;
    }

    public void setElemento(Dato elemento) {
        this.elemento = elemento;
    }

    public NodoLSC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLSC siguiente) {
        this.siguiente = siguiente;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
} // FIN DE CLASE NODODC.

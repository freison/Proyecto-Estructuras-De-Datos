
package Estructuras;

public class DatoT<T extends Estructura> extends Dato {
    // ATRIBUTOS.
    private T t;
    
    // CONSTRUCTOR.
    public DatoT(){
        this.t = t;
    }
    
    // GETTERS Y SETTERS.

    public T getT() {
        return (T)t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

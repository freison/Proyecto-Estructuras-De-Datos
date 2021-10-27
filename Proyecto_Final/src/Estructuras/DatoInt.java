
package Estructuras;

public class DatoInt extends Dato {
    // ATRIBUTOS DE LA CLASE.
    private int numero;
    
    // CONSTRUCTOR;
    public DatoInt(){
        this.numero = 0;
        super.setIndice(-1);
    }
    
    // GETTERS Y SETTERS.
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}

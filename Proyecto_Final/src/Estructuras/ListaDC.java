
package Estructuras;

public class ListaDC {
    // ATRIBUTOS.
    private NodoDC inicioDC;
    private NodoDC finDC;
    private int longitud;
    
    // CONSTRUCTOR.
    public ListaDC(){
        this.inicioDC = null;
        this.finDC = null;
    }
    
    // GETTERS Y SETTERS.

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public NodoDC getFinDC() {
        return finDC;
    }
    
    // METODOS.
    public boolean isDCEmpty(){
        if(inicioDC == null){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void agregarListaDC(String letra){
        DatoString dato = new DatoString();
        dato.setCadena(letra);
        NodoDC nuevo = new NodoDC();
        nuevo.setElemento(dato);
        
        if(isDCEmpty()){
            inicioDC = nuevo;
            finDC = nuevo;
            finDC.setSiguiente(inicioDC);
            inicioDC.setAnterior(nuevo);
        }
        else if(dato.getCadena().compareToIgnoreCase(
                inicioDC.getElemento().toDatoString().getCadena())<0
                ){
            nuevo.setSiguiente(inicioDC);
            inicioDC = nuevo;
            finDC.setSiguiente(inicioDC);
            inicioDC.setAnterior(finDC);
        }
        else if(dato.getCadena().compareToIgnoreCase(
                finDC.getElemento().toDatoString().getCadena())>=0
                ){
            finDC.setSiguiente(nuevo);
            finDC = finDC.getSiguiente();
            finDC.setSiguiente(inicioDC);
            inicioDC.setAnterior(finDC);
        }
        else{
            NodoDC aux = inicioDC;
            while(aux.getSiguiente().getElemento().toDatoString().getCadena()
                    .compareToIgnoreCase(dato.getCadena())<0){
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            nuevo.setAnterior(aux);
            aux.setSiguiente(nuevo);
            nuevo.getSiguiente().setAnterior(nuevo);
        }
    }
    
    public void agregarListaDC(int numero){
        DatoInt dato = new DatoInt();
        dato.setNumero(numero);
        NodoDC nuevo = new NodoDC();
        nuevo.setElemento(dato);
        
        if(isDCEmpty()) {
            inicioDC = nuevo;
            finDC = nuevo;
            finDC.setSiguiente(inicioDC);
            inicioDC.setAnterior(nuevo);
        }
        else if(dato.toDatoInt().getNumero() < inicioDC.getElemento().toDatoInt().getNumero()){
            nuevo.setSiguiente(inicioDC);
            inicioDC = nuevo;
            finDC.setSiguiente(inicioDC);
            inicioDC.setAnterior(finDC);
        }
        else if(dato.toDatoInt().getNumero() >= finDC.getElemento().toDatoInt().getNumero()){
            finDC.setSiguiente(nuevo);
            finDC = finDC.getSiguiente();
            finDC.setSiguiente(inicioDC);
            inicioDC.setAnterior(finDC);
        }
        else{
            NodoDC aux = inicioDC;
            while(aux.getSiguiente().getElemento().toDatoInt().getNumero() < dato.getNumero()){
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            nuevo.setAnterior(aux);
            aux.setSiguiente(nuevo);
            nuevo.getSiguiente().setAnterior(nuevo);
        }
    }
}

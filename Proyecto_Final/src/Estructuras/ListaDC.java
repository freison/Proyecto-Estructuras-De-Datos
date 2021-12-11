
package Estructuras;

public class ListaDC<T extends Estructura> extends Estructura {
    // ATRIBUTOS.
    private NodoDC inicioDC;
    private NodoDC finDC;
    private NodoDC finx;
    private T t;
    
    // CONSTRUCTOR.
    public ListaDC(){
        super();
        this.inicioDC = null;
        this.finDC = null;
    }
    
    // GETTERS Y SETTERS.

//    public int getLongitud() {
//        return longitud;
//    }
//
//    public void setLongitud(int longitud) {
//        this.longitud = longitud;
//    }

    public NodoDC getFinDC() {
        return finx;
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

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
    
    public void agregarListaDC(String letra, int indice){
        DatoString dato = new DatoString();
        dato.setCadena(letra);
        NodoDC nuevo = new NodoDC();
        nuevo.setElemento(dato);
        
        nuevo.setIndice(indice);
        
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
    
    public void agregarListaDC(int numero, int indice){
        DatoInt dato = new DatoInt();
        dato.setNumero(numero);
        NodoDC nuevo = new NodoDC();
        nuevo.setElemento(dato);
        nuevo.setIndice(indice);
        
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
    
//    public void agregarListaDC(T t){
//        DatoT<T> dato = new DatoT<>();
//        dato.setT(t);
//        NodoDC nuevo = new NodoDC();
//        nuevo.setElemento(dato);
//        
//        if(isDCEmpty()) {
//            inicioDC = nuevo;
//            finDC = nuevo;
//            finDC.setSiguiente(inicioDC);
//            inicioDC.setAnterior(nuevo);
//        }
//        else if(dato.getT().getLongitud() < nuevo.getElemento().toDatoT().getT().getLongitud()){
//            
//        }
//    }
    
    public void mostrarListaDC(){
        String s = "";
        if(!isDCEmpty()){
            NodoDC aux = inicioDC;
            s += aux.getIndice() + " <=> ";
            aux = aux.getSiguiente();
            while(aux != inicioDC){
                s += aux.getIndice() + " <=> ";
                aux = aux.getSiguiente();
            }
            javax.swing.JOptionPane.showMessageDialog(null, s);
        }
    }
    
    public Dato obtenerEspecifico(int indice){
        Dato datoAuxiliar = null;
        boolean flag = false;
        if(!isDCEmpty()){
            NodoDC aux = inicioDC;
            if(aux.getIndice() == indice){
                datoAuxiliar = aux.getElemento();
                flag = true;
            }
            aux = aux.getSiguiente();
            while(aux!=inicioDC && !flag){
                if (aux.getIndice() == indice) {
                    datoAuxiliar = aux.getElemento();
                    flag = true;
                }
                aux = aux.getSiguiente();
            }
        }
        
        return datoAuxiliar;
    }
}

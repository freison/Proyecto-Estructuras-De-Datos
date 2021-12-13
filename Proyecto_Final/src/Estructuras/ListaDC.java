
package Estructuras;

public class ListaDC<T extends Estructura> extends Estructura {
    // ATRIBUTOS.
    private NodoDC inicioDC;
    private NodoDC finDC;
    private NodoDC finx;
    // private T t;
    
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

//    public T getT() {
//        return t;
//    }
//
//    public void setT(T t) {
//        this.t = t;
//    }
    
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
            //
            finDC.setAnterior(inicioDC);
            inicioDC.setSiguiente(finDC);
            //
        }
        else if(dato.getCadena().compareToIgnoreCase(
                inicioDC.getElemento().toDatoString().getCadena())<0
                ){
            nuevo.setSiguiente(inicioDC);
            //
            inicioDC.setAnterior(nuevo);
            //
            inicioDC = nuevo;
            finDC.setSiguiente(inicioDC);
            inicioDC.setAnterior(finDC);
        }
        else if(dato.getCadena().compareToIgnoreCase(
                finDC.getElemento().toDatoString().getCadena())>=0
                ){
            finDC.setSiguiente(nuevo);
            //
            nuevo.setAnterior(finDC);
            //
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
    
    public void agregarListaDC(String letra){
        DatoString dato = new DatoString();
        dato.setCadena(letra);
        NodoDC nuevo = new NodoDC();
        nuevo.setElemento(dato);
        
        nuevo.setIndice(this.getLongitud());
        
        if(isDCEmpty()){
            inicioDC = nuevo;
            finDC = nuevo;
            finDC.setSiguiente(inicioDC);
            inicioDC.setAnterior(nuevo);
            //
            finDC.setAnterior(inicioDC);
            inicioDC.setSiguiente(finDC);
            //
        }
        else if(dato.getCadena().compareToIgnoreCase(
                inicioDC.getElemento().toDatoString().getCadena())<0
                ){
            nuevo.setSiguiente(inicioDC);
            //
            inicioDC.setAnterior(nuevo);
            //
            inicioDC = nuevo;
            finDC.setSiguiente(inicioDC);
            inicioDC.setAnterior(finDC);
        }
        else if(dato.getCadena().compareToIgnoreCase(
                finDC.getElemento().toDatoString().getCadena())>=0
                ){
            finDC.setSiguiente(nuevo);
            //
            nuevo.setAnterior(finDC);
            //
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
            //
            finDC.setAnterior(inicioDC);
            inicioDC.setSiguiente(finDC);
            //
        }
        else if(dato.toDatoInt().getNumero() < inicioDC.getElemento().toDatoInt().getNumero()){
            nuevo.setSiguiente(inicioDC);
            //
            inicioDC.setAnterior(nuevo);
            //
            inicioDC = nuevo;
            finDC.setSiguiente(inicioDC);
            inicioDC.setAnterior(finDC);
        }
        else if(dato.toDatoInt().getNumero() >= finDC.getElemento().toDatoInt().getNumero()){
            finDC.setSiguiente(nuevo);
            //
            nuevo.setAnterior(finDC);
            //
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
    
    public void agregarListaDC(int numero){
        DatoInt dato = new DatoInt();
        dato.setNumero(numero);
        NodoDC nuevo = new NodoDC();
        nuevo.setElemento(dato);
        nuevo.setIndice(this.getLongitud()+1);
        
        if(isDCEmpty()) {
            inicioDC = nuevo;
            finDC = nuevo;
            finDC.setSiguiente(inicioDC);
            inicioDC.setAnterior(nuevo);
            //
            finDC.setAnterior(inicioDC);
            inicioDC.setSiguiente(finDC);
            //
        }
        else if(dato.toDatoInt().getNumero() < inicioDC.getElemento().toDatoInt().getNumero()){
            nuevo.setSiguiente(inicioDC);
            //
            inicioDC.setAnterior(nuevo);
            //
            inicioDC = nuevo;
            finDC.setSiguiente(inicioDC);
            inicioDC.setAnterior(finDC);
            
        }
        else if(dato.toDatoInt().getNumero() >= finDC.getElemento().toDatoInt().getNumero()){
            finDC.setSiguiente(nuevo);
            //
            nuevo.setAnterior(finDC);
            //
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
    
    public void agregarListaDC(T t, int indice){
        DatoT<T> dato = new DatoT<>();
        dato.setT(t);
        NodoDC nuevo = new NodoDC();
        nuevo.setElemento(dato);
        nuevo.setIndice(indice);
        
        if(isDCEmpty()) {
            inicioDC = nuevo;
            finDC = nuevo;
            finDC.setSiguiente(inicioDC);
            inicioDC.setAnterior(nuevo);
            //
            finDC.setAnterior(inicioDC);
            inicioDC.setSiguiente(finDC);
            //
        }
        else if(dato.getT().getLongitud() < inicioDC.getElemento().toDatoT().getT().getLongitud()){
            nuevo.setSiguiente(inicioDC);
            //
            inicioDC.setAnterior(nuevo);
            //
            inicioDC = nuevo;
            finDC.setSiguiente(inicioDC);
            inicioDC.setAnterior(finDC);
        }
        else if(dato.getT().getLongitud() >= finDC.getElemento().toDatoT().getT().getLongitud()){
            finDC.setSiguiente(nuevo);
            //
            nuevo.setAnterior(finDC);
            //
            finDC = finDC.getSiguiente();
            finDC.setSiguiente(inicioDC);
            inicioDC.setAnterior(finDC);
        }
        else{
            NodoDC aux = inicioDC;
            while(aux.getSiguiente().getElemento().toDatoT().getT().getLongitud() < 
                    dato.getT().getLongitud()){
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            nuevo.setAnterior(aux);
            aux.setSiguiente(nuevo);
            nuevo.getSiguiente().setAnterior(nuevo);
        }
    }
    
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
    
    public int obtenerIndiceEspecifico(String cadena){
        int datoAuxiliar = 0;
        boolean flag = false;
        if(!isDCEmpty()){
            NodoDC aux = inicioDC;
            if(aux.getElemento().toDatoString().getCadena().compareToIgnoreCase(cadena) == 0){
                datoAuxiliar = aux.getIndice();
                flag = true;
            }
            aux = aux.getSiguiente();
            while(aux!=inicioDC && !flag){
                if (aux.getElemento().toDatoString().getCadena().compareToIgnoreCase(cadena) == 0) {
                    datoAuxiliar = aux.getIndice();
                    flag = true;
                }
                aux = aux.getSiguiente();
            }
        }
        
        return datoAuxiliar;
    }
    
    public int obtenerIdEspecifico(int indice){
        int datoAuxiliar = 0;
        boolean flag = false;
        if(!isDCEmpty()){
            NodoDC aux = inicioDC;
            if(aux.getIndice() == indice){
                datoAuxiliar = aux.getElemento().toDatoInt().getNumero();
                flag = true;
            }
            aux = aux.getSiguiente();
            while(aux!=inicioDC && !flag){
                if (aux.getIndice() == indice) {
                    datoAuxiliar = aux.getElemento().toDatoInt().getNumero();
                    flag = true;
                }
                aux = aux.getSiguiente();
            }
        }
        
        return datoAuxiliar;
    }
    
    public void eliminarEspecifico(int indice){
        if(inicioDC.getIndice() == indice){
            this.moverIndices(inicioDC.getSiguiente());
            System.out.println(inicioDC.getElemento());
            finDC.setSiguiente(inicioDC.getSiguiente());
            inicioDC.getSiguiente().setAnterior(finDC);
            inicioDC = inicioDC.getSiguiente();
        }
        else if(finDC.getIndice() == indice){
            this.moverIndices(finDC.getSiguiente());
            finDC.getAnterior().setSiguiente(inicioDC);
            inicioDC.setAnterior(finDC.getSiguiente());
            finDC = finDC.getAnterior();
        }
        else{
            NodoDC aux = finDC;
            if(aux.getSiguiente().getIndice() == indice){
                this.moverIndices(aux.getSiguiente().getSiguiente());
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
                aux.getSiguiente().getSiguiente().setAnterior(aux);
                inicioDC = inicioDC.getSiguiente();
            }
            aux = aux.getSiguiente();
            while(aux!=finDC){
                if (aux.getSiguiente().getIndice() == indice) {
                    this.moverIndices(aux.getSiguiente().getSiguiente());
                    aux.setSiguiente(aux.getSiguiente().getSiguiente());
                    aux.getSiguiente().getSiguiente().setAnterior(aux);
                }
                aux = aux.getSiguiente();
            }
        }
    }
    
    public void moverIndices(NodoDC aux){
        aux.setIndice(aux.getIndice()-1);
        aux = aux.getSiguiente();
        while(aux!=inicioDC){
            aux.setIndice(aux.getIndice() - 1);
            aux = aux.getSiguiente();
        }
    }
}

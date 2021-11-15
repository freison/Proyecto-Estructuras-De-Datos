
package Estructuras;

import javax.swing.JOptionPane;

public class Pila {
    // ATRIBUTOS DE LA CLASE.
    private NodoPila cima;
    
    // METODOS DE LA CLASE.
    public boolean isPilaEmpty(){
        if(cima ==null){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void apilar(String cadena){
        DatoString dato = new DatoString();
        dato.setCadena(cadena);
        NodoPila nuevo = new NodoPila();
        nuevo.setElemento(dato);
        
        if(this.isPilaEmpty()){
            cima = nuevo;
        }
        else{
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }
    }
    
    public void desapilar(){
        if(!this.isPilaEmpty()){
            cima = cima.getSiguiente();
            JOptionPane.showMessageDialog(null, "El elemento fue extraído!");
        }
        else{
            JOptionPane.showConfirmDialog(null, 
                    "No se pueden extraer elementos, pila vacía");
        }
    }
    
    public Dato obtenerEspecifico(int indice){
        Dato datoAuxiliar = null;
        if(!isPilaEmpty()){
            NodoPila aux = cima;
            while(aux!=null){
                if(indice == aux.getIndice()){
                    datoAuxiliar = aux.getElemento();
                }
                aux = aux.getSiguiente();
            }
        }
        
        return datoAuxiliar;
    }
}

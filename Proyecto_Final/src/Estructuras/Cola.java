
package Estructuras;

import javax.swing.JOptionPane;

public class Cola {
    // ATRIBUTOS DE LA CLASE.
    private NodoCola inicio;
    private NodoCola fin;
    private int longitud;
    
    public Cola(){
        this.inicio = null;
        this.fin = null;
        this.longitud = 0;
    }
    
    // GETTERS Y SETTERS DE LA CLASE.
    public int getLongitud(){
        return this.longitud;
    }
    
    public void setLongitud(int longitud){
        this.longitud = longitud;
    }
    
    // METODOS.
    public boolean isColaEmpty(){
        if(inicio == null){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void encolar(String cadena){
        DatoString dato = new DatoString();
        dato.setCadena(cadena);
        NodoCola nuevo = new NodoCola();
        nuevo.setElemento(dato);
        
        if(isColaEmpty()){
            inicio = nuevo;
            fin = nuevo;
        }
        else{
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }
    
    public void desencolar(){
        if(!isColaEmpty()){
            inicio = inicio.getSiguiente();
            JOptionPane.showMessageDialog(null, "El elemento fue extraído!", "Desencolar",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "No existen elementos para desencolar, cola vacía!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


package proyecto_final;

public class Tarea {
    // ATRIBUTOS DE LA CLASE.
    private String id;
    private String descripcion;
    
    private Connection connection;
    
    // Constructor sin parametros.
    public Tarea(){
        this.id = "";
        this.descripcion = "";
        this.connection  = new Connection();
    }
    
    // Constructor con parametros.
    public Tarea(String id, String descripcion){
        this.id = id;
        this.descripcion = descripcion;
    }
    
    // GETTERS Y SETTERS DE LA CLASE.
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    // METODOS DE LA CLASE.
    
} // FIN DE CLASE TAREA.

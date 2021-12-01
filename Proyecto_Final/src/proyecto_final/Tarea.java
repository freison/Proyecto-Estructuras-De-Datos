
package proyecto_final;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    public void Agregar(String descripcion, int estadoTareaId, int proyectoId){
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            
            String sqlQuery = "insert into TAREAS(Descripcion, EstadoTareaId, ProyectoId) values(?, ?, ?)";
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setString(1, descripcion);
            ps.setInt(2, estadoTareaId);
            ps.setInt(3, proyectoId);
            ps.executeQuery();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void agregarDetalle(int miembroId, int tareaId){
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            
            String sqlQuery = "insert into DETALLE_TAREAS_MIEMBRO(MiembroId, TareaId) values(?, ?)";
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, miembroId);
            ps.setInt(2, tareaId);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
} // FIN DE CLASE TAREA.

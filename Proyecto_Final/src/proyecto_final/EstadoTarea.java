
package proyecto_final;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Estructuras.Cola;

public class EstadoTarea {
    // ATRIBUTOS DE LA CLASE.
    private String ID;
    private String descripcion;
    
    private Connection connection = new Connection();
    
    // CONSTRUCTORES DE LA CLASE.
    // Constructor sin parametros.
    public EstadoTarea(){
        this.ID = "";
        this.descripcion = "";
    }
    
    // Constructor con parametros.
    public EstadoTarea(String ID, String descripcion){
        this.ID = ID;
        this.descripcion = descripcion;
    }
    
    // GETTERS Y SETTERS DE LA CLASE.
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    // METODOS DE LA CLASE.
    /***
     * Agrega un nuevo proyecto a la base de datos.
     * return int.
     * @param tproyectoId 
     */
    public void Agregar(int proyectoId){
        java.sql.Connection cn = null;
        
        try{
            cn = connection.getConnection();
            
            PreparedStatement stmt = cn.prepareStatement("insert into ESTADOSTAREA(Descripcion, ProyectoId) values(?, ?)");
            stmt.setString(1, this.getDescripcion());
            stmt.setInt(2, proyectoId);
            stmt.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public Cola[] listarEstadosPorProyecto(int proyectoId){
        java.sql.Connection cn = null;
        Cola id = new Cola();
        Cola descripcion = new Cola();
        
        Cola[] colas = new Cola[2];
        int indice = 0;
        
        try{
            cn = connection.getConnection();
            
            String sqlQuery = "Select * from ESTADOSTAREA where proyectoId = ?";
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setInt(1, proyectoId);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                id.encolar(rs.getInt("Id"));
                id.getFin().setIndice(indice);
                id.setLongitud(id.getLongitud() + 1)
                        ;
                descripcion.encolar(rs.getString("Descripcion"));
                descripcion.getFin().setIndice(indice);
                descripcion.setLongitud(descripcion.getLongitud() + 1);
                
                indice++;
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
        colas[0] = id;
        colas[1] = descripcion;
        
        return colas;
    }
    
} // FIN DE CLASE ESTADOTAREA

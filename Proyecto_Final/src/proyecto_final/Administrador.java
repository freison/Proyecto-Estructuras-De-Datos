
package proyecto_final;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Administrador extends Miembro {
    // ATRIBUTOS DE LA CLASE.
    private int MiembroId;
    
    Connection connection = new Connection();
    
    // CONSTRUCTORES DE LA CLASE.
    // Constructor sin parametros.
    public Administrador(){
        super();
    }
    
    // Constructor con parametros V1
    public Administrador(String ID, String nombres, String apellidos,
            String usuario, String clave, String cedula){
        super(ID, nombres, apellidos, usuario, clave, cedula);
    }
    
    // Constructor con parametros V2.
    
    // Constructor con parametros V3.
    
    // GETTERS Y SETTERS DE LA CLASE.
    public int getMiembroId() {
        return MiembroId;
    }

    public void setMiembroId(int MiembroId) {
        this.MiembroId = MiembroId;
    }
    
    // METODOS.
    @Override
    public void Agregar(){
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            
            Statement stmt = cn.createStatement();
            stmt.executeUpdate("Insert into Miembros(nombres, apellidos, usuario, clave, cedula) "
                + "values('"+ this.getNombres() + "', '"+ this.getApellidos()+ "', '"+ this.getUsuario() +"', "
                + "'"+ this.getClave() +"', '"+ this.getCedula() +"')");
            
            this.setMiembroId(this.buscarUltimoMiembro());
            
            String sqlQuery = "Insert into Administradores(MiembroId) values(?)";
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setInt(1, this.getMiembroId());
            ps.executeUpdate();
            this.setMiembroId(MiembroId);
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
}

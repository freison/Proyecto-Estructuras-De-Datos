
package proyecto_final;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Editor extends Miembro {
    // ATRIBUTOS DE LA CLASE.
    private int miembroId;
    
    Connection connection = new Connection();
    
    // CONSTRUCTORES DE LA CLASE.
    // Constructor sin parametros.
    public Editor(){
        super();
    }
    
    // Constructor con parametros V1.
    public Editor(String ID, String nombres, String apellidos,
            String usuario, String clave, String cedula){
        super(ID, nombres, apellidos, usuario, clave, cedula);
    }
    
    // GETTERS Y SETTERS DE LA CLASE.
    public int getMiembroId() {
        return miembroId;
    }

    public void setMiembroId(int miembroId) {
        this.miembroId = miembroId;
    }
    
    // METODOS DE LA CLASE.
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
            
            String sqlQuery = "Insert into Editores(MiembroId) values(?)";
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setInt(1, this.getMiembroId());
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
}

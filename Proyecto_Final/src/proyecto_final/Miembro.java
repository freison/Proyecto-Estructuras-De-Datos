
package proyecto_final;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Estructuras.ListaES;
import Estructuras.Cola;

public abstract class Miembro {
    // ATRIBUTOS DE LA CLASE.
    protected String ID;
    protected String nombres;
    protected String apellidos;
    protected String usuario;
    protected String clave;
    protected String cedula;
    
    private Connection connection = new Connection();
    
    // CONSTRUCTOR DE LA CLASE.
    // Constructor sin parametros.
    public Miembro(){
        this.ID = "";
        this.nombres = "";
        this.apellidos = "";
        this.usuario = "";
        this.clave = "";
        this.cedula = "";
    }
    
    // Constructor con parametros V1.
    public Miembro(String ID, String nombres, String apellidos,
                String usuario, String clave, String cedula){
        this.ID = ID;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.clave = clave;
        this.cedula = cedula;
    }
    
    // GETTERS Y SETTERS.
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    // METODOS.
    @Override
    public String toString(){
        return "Nombre: " + this.getNombres()
                + "\nApellidos: " + this.getApellidos()
                + "\nCédula: " + this.getCedula()
                + "\nUsuario: " + this.getUsuario();
    }
    
    public abstract void Agregar();
    
    public Cola[] listarMiembros(){
        
    }
    
    /***
     * Busca el id del último Miembro registrado.
     * @return int
     */
    public int buscarUltimoMiembro(){
        int Id = 0;
        
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Miembros order by Id desc fetch first row only");
            
            while(rs.next()){
                Id = rs.getInt("Id");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        
        return Id;
    }
    
    /***
     * Valida los datos recibidos, permitiendo o denegando iniciar sesión.
     * @param usuario
     * @param clave
     * @return boolean
     */
    public boolean iniciarSesion(String usuario, String clave){
        boolean flag = false;
        java.sql.Connection cn = null;
        
        try{
            cn = connection.getConnection();
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "Select * from Miembros where usuario = '"+usuario+"' and clave = '"+clave+"'"
            );
            
            while(rs.next()){
                flag = true;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return flag;
    }
    
    /***
     * Obtiene el Id de Miembro en base al usuario.
     * @param usuario
     * @return int
     */
    public int obtenerId(String usuario){
        int Id = 0;
        
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("select m.ID from Miembros as m\n" +
                                             "where m.usuario =   '"+usuario+"'");
            
            while(rs.next()){
                Id = rs.getInt("ID");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        
        return Id;
    }
} // FIN DE CLASE ABSTRACTA MIEMBRO.

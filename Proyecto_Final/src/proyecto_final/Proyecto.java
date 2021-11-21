
package proyecto_final;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Estructuras.Pila;
import Estructuras.ListaES;
import javax.swing.JOptionPane;

public class Proyecto {
    // ATRIBUTOS DE LA CLASE.
    private String ID;
    private String nombre;
    private String descripcion;
    
    private Connection connection = new Connection();
    
    // CONSTRUCTORES DE LA CLASE.
    // Constructor sin parametros.
    public Proyecto(){
        this.ID = "";
        this.nombre = "";
        this.descripcion = "";
    }
    
    // Constructor con parametros V1.
    public Proyecto(String ID, String nombre, String descripcion){
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    // GETTERS Y SETTERS.
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    // METODOS DE LA CLASE.
    public int buscarUltimoProyecto(){
        int Id = 0;
        
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Proyectos order by Id desc fetch first row only");
            
            while(rs.next()){
                Id = rs.getInt("ID");
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
    
    public Pila buscarProyecto(String proyecto){
        Pila datos = new Pila();
        
        java.sql.Connection cn = null;
        try{
            int contador = 0;
            cn = connection.getConnection();
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from proyectos where nombre = '"+proyecto+"'");
            
            while(rs.next()){
                datos.apilar(Integer.toString(rs.getInt("ID")));
                datos.getCima().setIndice(contador);
                contador++;
                
                datos.apilar(rs.getString("Nombre"));
                datos.getCima().setIndice(contador);
                contador++;
                
                datos.apilar(rs.getString("Descripcion"));
                datos.getCima().setIndice(contador);
                contador++;
                
                datos.apilar(rs.getString("Tipo"));
                datos.getCima().setIndice(contador);
                contador++;
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
        
        return datos;
    }
    
    public void agregarDetalleParticipacion(int miembroId, int proyectoId){
        
    }
    
    public ListaES[] listar(String usuario){
        java.sql.Connection cn = null;
        int contador = 0;
        ListaES id = new ListaES();
        ListaES nombres = new ListaES();
        
        ListaES[] listas = new ListaES[2];
        
        try{
            cn = connection.getConnection();
            
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("select p.ID, \n" +
                    "    p.Nombre as Nombre\n" +
                    "from Miembros as m\n" +
                    "inner join Detalle_Proyectos_Participacion as dpp\n" +
                    "on m.ID = dpp.MIEMBROID\n" +
                    "inner join Proyectos as p\n" +
                    "on dpp.PROYECTOID = p.ID\n" +
                    "where m.USUARIO = '"+usuario+"'");
            
            while(rs.next()){
                id.Agregar(Integer.toString(rs.getInt("Id")), contador);
                nombres.Agregar(rs.getString("Nombre"), contador);
                contador++;
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
        
        listas[0] = id;
        listas[1] = nombres;
        
        return listas;
    }
    
    public void Agregar(Pila datosUsuario, boolean tipo){
        Administrador administrador = new Administrador();
        java.sql.Connection cn = null;
        int MiembroId = administrador.obtenerMiembroId(datosUsuario.obtenerEspecifico(0).toDatoString().getCadena());
        int AdministradorId = administrador.obtenerId(datosUsuario.obtenerEspecifico(0).toDatoString().getCadena());
        int ProyectoId = 0;
        try{
            cn = connection.getConnection();
            PreparedStatement stmt = cn.prepareStatement(
                    "insert into Proyectos(nombre, descripcion, AdministradorId, Tipo) values(?, ?, ?, ?)");
            stmt.setString(1, this.getNombre());
            stmt.setString(2, this.getDescripcion());
            stmt.setInt(3, AdministradorId);
            stmt.setBoolean(4, tipo);
            stmt.executeUpdate();
            
            ProyectoId = this.buscarUltimoProyecto();
            
            String sqlQuery = "insert into Detalle_Proyectos_Participacion(MiembroId, ProyectoId) values(?, ?)";
            PreparedStatement p = cn.prepareStatement(sqlQuery);
            p.setInt(1, MiembroId);
            p.setInt(2, ProyectoId);
            p.executeUpdate();
            
            if(!tipo){
                EstadoTarea estados = new EstadoTarea();
                
                estados.setDescripcion("Por Hacer");
                estados.Agregar(ProyectoId);
                
                estados.setDescripcion("En Proceso");
                estados.Agregar(ProyectoId);
                
                estados.setDescripcion("Finalizado");
                estados.Agregar(ProyectoId);
            }
            
            JOptionPane.showMessageDialog(null, "Proyecto Agregado");
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
}

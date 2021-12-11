
package proyecto_final;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Estructuras.Cola;
import Estructuras.ListaSC;
import Estructuras.ListaDC;

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
    
    public void agregarDetalle(int miembroId, int tareaId){
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            
            String sqlQuery = "insert into DETALLE_TAREAS_MIEMBRO(MiembroId, TareaId) values(?, ?)";
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
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
    
    public int buscarUltimaTarea(){
        int Id = 0;
        
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Tareas order by Id desc fetch first row only");
            
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
    
    public Cola buscarTareaPorId(int tareaId){
        java.sql.Connection cn = null;
        Cola tarea = new Cola();
        
        try{
            cn = connection.getConnection();
            String sqlQuery = "select * from Tareas where id = ?";
            
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setInt(1, tareaId);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                tarea.encolar(rs.getShort("Descripcion"));
                tarea.encolar(rs.getInt("EstadoTareaId"));
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
        
        return tarea;
    }
    
    public ListaSC[] listarTareasPorUsuario(String usuario){
        ListaSC[] lista = new ListaSC[3];
        
        java.sql.Connection cn = null;
        ListaSC tareas = new ListaSC();
        ListaSC proyectos = new ListaSC();
        ListaSC estados = new ListaSC();
        int indice = 0;
        
        try{
            cn = connection.getConnection();
            
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("select t.DESCRIPCION as Tarea,\n" +
                                            "    p.NOMBRE as Proyecto,\n" +
                                            "    et.DESCRIPCION as Estado\n" +
                                            "from PROYECTOS as p\n" +
                                            "inner join ESTADOSTAREA as et\n" +
                                            "on p.ID = et.PROYECTOID\n" +
                                            "inner join TAREAS as t\n" +
                                            "on et.ID = t.ESTADOTAREAID\n" +
                                            "inner join DETALLE_TAREAS_MIEMBRO as dtm\n" +
                                            "on t.ID = dtm.TAREAID\n" +
                                            "inner join MIEMBROS as m\n" +
                                            "on dtm.MIEMBROID = m.ID\n" +
                                            "where usuario = '"+usuario+"'");
            
            while(rs.next()){
                tareas.agregar(rs.getString("TAREA"));
                tareas.getFin().setIndice(indice);
                tareas.setLongitud(tareas.getLongitud()+1);
                
                proyectos.agregar(rs.getString("PROYECTO"));
                proyectos.getFin().setIndice(indice);
                proyectos.setLongitud(proyectos.getLongitud() + 1);
                
                estados.agregar(rs.getString("ESTADO"));
                estados.getFin().setIndice(indice);
                estados.setLongitud(estados.getLongitud() + 1);
                
                indice++;
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
        
        lista[0] = tareas;
        lista[1] = proyectos;
        lista[2] = estados;
        
        return lista;
    }
    
    public ListaDC[] listarTareasPorProyecto(int proyectoId){
        ListaDC[] lista = new ListaDC[3];
        
        java.sql.Connection cn = null;
        ListaDC Id = new ListaDC();
        ListaDC descripcion = new ListaDC();
        ListaDC estados = new ListaDC();
        int indice = 0;
        
        try{
            cn = connection.getConnection();
            
            String sqlQuery = "select t.ID,\n" +
                            "    t.DESCRIPCION,\n" +
                            "    t.ESTADOTAREAID\n" +
                            "from TAREAS as t\n" +
                            "inner join PROYECTOS as p\n" +
                            "on t.PROYECTOID = p.ID\n" +
                            "where p.ID = ?";
            
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setInt(1, proyectoId);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Id.agregarListaDC(rs.getInt("ID"), indice);
                // Id.getFinDC().setIndice(indice);
                Id.setLongitud(Id.getLongitud() + 1);
                
                descripcion.agregarListaDC(rs.getString("DESCRIPCION"), indice);
                // descripcion.getFinDC().setIndice(indice);
                descripcion.setLongitud(descripcion.getLongitud() + 1);
                // System.out.println(descripcion.getFinDC().getIndice());
                System.out.println(rs.getString("DESCRIPCION"));
                
                estados.agregarListaDC(rs.getString("ESTADOTAREAID"), indice);
                // estados.getFinDC().setIndice(indice);
                estados.setLongitud(estados.getLongitud() + 1);
                
                indice++;
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
        
        descripcion.mostrarListaDC();
        Id.mostrarListaDC();
        estados.mostrarListaDC();
        
        lista[0] = Id;
        lista[1] = descripcion;
        lista[2] = estados;
        
        return lista;
    }
    
    public ListaDC[] listarDetalles(int tareaId){
        ListaDC[] lista = new ListaDC[2];
        
        java.sql.Connection cn = null;
        ListaDC id = new ListaDC();
        ListaDC nombres = new ListaDC();
        int indice = 0;
        
        try{
            cn = connection.getConnection();
            
            String sqlQuery = "select m.ID, m.NOMBRES\n" +
                            "from DETALLE_TAREAS_MIEMBRO as dtm\n" +
                            "inner join MIEMBROS as m\n" +
                            "on dtm.MIEMBROID = m.ID\n" +
                            "where dtm.TAREAID = ?";
            
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setInt(1, tareaId);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                id.agregarListaDC(rs.getInt("ID"), indice);
                id.getFinDC().setIndice(indice);
                id.setLongitud(id.getLongitud() + 1);
                
                nombres.agregarListaDC(rs.getString("NOMBRES"), indice);
                // nombres.getFinDC().setIndice(indice);
                nombres.setLongitud(nombres.getLongitud() + 1);
                
                indice++;
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
        
        lista[0] = id;
        lista[1] = nombres;
        
        return lista;
    }
    
    public int listarUltimoDetalle(int tareaId){
        java.sql.Connection cn = null;
        
        int detalleId = 0;
        
        try{
            cn = connection.getConnection();
            
            String sqlQuery = "select m.ID, m.NOMBRES\n" +
                            "from DETALLE_TAREAS_MIEMBRO as dtm\n" +
                            "inner join MIEMBROS as m\n" +
                            "on dtm.MIEMBROID = m.ID\n" +
                            "where dtm.TAREAID = ?";
            
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setInt(1, tareaId);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                detalleId = rs.getInt("ID");
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
        
        return detalleId;
    }
} // FIN DE CLASE TAREA.

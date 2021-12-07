
package proyecto_final;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;;
import Estructuras.Cola;
import Estructuras.ListaES;

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
    
    /***
     * Metodo que permite registrar un nuevo Miembro.
     */
    public abstract void Agregar();
    
    /***
     * Obtiene todos los miembros registrados.
     * @return Cola[]
     */
    public Cola[] listarMiembros(){
        java.sql.Connection cn = null;
        int indice = 0;
        Cola id = new Cola();
        Cola nombres = new Cola();
        Cola apellidos = new Cola();
        Cola usuarios = new Cola();
        Cola cedulas = new Cola();
        Cola roles = new Cola();
        
        Cola[] colas = new Cola[6];
        
        try{
            cn = connection.getConnection();
            
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("select m.ID,\n"
                    + "    m.NOMBRES as Nombres,\n"
                    + "    m.APELLIDOS as Apellidos,\n"
                    + "    m.USUARIO as Usuario,\n"
                    + "    m.CEDULA as Cedula,\n"
                    + "case a.ID\n"
                    + "    when is not null then 'Administrador'\n"
                    + "    else\n"
                    + "        case e.ID\n"
                    + "            when is not null then 'Editor'\n"
                    + "            else 'Invitado'\n"
                    + "        end\n"
                    + "end as Rol\n"
                    + "from Miembros as m\n"
                    + "left join Administradores as a on m.ID = a.MIEMBROID\n"
                    + "left join Editores as e on m.ID = e.MIEMBROID\n"
                    + "left join Invitados as i on m.ID = i.MIEMBROID");
            
            while(rs.next()){
                id.encolar(rs.getInt("Id"));
                nombres.encolar(rs.getString("Nombres"));
                apellidos.encolar(rs.getString("Apellidos"));
                usuarios.encolar(rs.getString("Usuario"));
                cedulas.encolar(rs.getString("Cedula"));
                roles.encolar(rs.getString("Rol"));
                
                id.setLongitud(id.getLongitud()+1);
                nombres.setLongitud(id.getLongitud()+1);
                apellidos.setLongitud(id.getLongitud()+1);
                usuarios.setLongitud(id.getLongitud()+1);
                cedulas.setLongitud(id.getLongitud()+1);
                roles.setLongitud(id.getLongitud()+1);
                
                id.getFin().setIndice(indice);
                nombres.getFin().setIndice(indice);
                apellidos.getFin().setIndice(indice);
                usuarios.getFin().setIndice(indice);
                cedulas.getFin().setIndice(indice);
                roles.getFin().setIndice(indice);
                indice++;
            }
        }catch(Exception e){
            System.out.println(e.getMessage() + "3");
        }finally{
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e.getMessage() + "4");
            }
        }
        
        colas[0] = id;
        colas[1] = nombres;
        colas[2] = apellidos;
        colas[3] = usuarios;
        colas[4] = cedulas;
        colas[5] = roles;
        
        return colas;
    }
    
    // METODO LISTAR MIEMBROS POR PROYECTO.
    public ListaES[] listarMiembrosPorProyecto(int proyectoId){
        java.sql.Connection cn = null;
        ListaES id = new ListaES();
        ListaES nombres = new ListaES();
        ListaES apellidos = new ListaES();
        ListaES usuarios = new ListaES();
        ListaES cedulas = new ListaES();
        ListaES roles = new ListaES();
        
        ListaES[] listas = new ListaES[6];
        int indice = 0;
        
        try{
            cn = connection.getConnection();
            
            String sqlQuery = "select m.ID,\n" +
                            "    m.NOMBRES,\n" +
                            "    m.APELLIDOS,\n" +
                            "    m.USUARIO,\n" +
                            "    m.CEDULA,\n" +
                            "    case a.ID\n" +
                            "        when is not null then 'Administrador'\n" +
                            "        else\n" +
                            "            case e.ID\n" +
                            "                when is not null then 'Editor'\n" +
                            "                else 'Invitado'\n" +
                            "            end\n" +
                            "        end as Rol\n" +
                            "from PROYECTOS as p\n" +
                            "inner join DETALLE_PROYECTOS_PARTICIPACION as dmp\n" +
                            "on p.ID = dmp.PROYECTOID\n" +
                            "inner join MIEMBROS as m\n" +
                            "on dmp.MIEMBROID = m.ID\n" +
                            "left join ADMINISTRADORES as a\n" +
                            "on m.ID = a.MIEMBROID\n" +
                            "left join EDITORES as e\n" +
                            "on m.ID = e.MIEMBROID\n" +
                            "left join INVITADOS as i\n" +
                            "on m.ID = i.MIEMBROID\n" +
                            "where p.ID = ? and \n" +
                            "case a.ID\n" +
                            "when is not null then 'Administrador'\n" +
                            "else\n" +
                            "    case e.ID\n" +
                            "        when is not null then 'Editor'\n" +
                            "        else 'Invitado'\n" +
                            "    end\n" +
                            "end != 'Invitado'";
            
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setInt(1, proyectoId);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                id.Agregar(rs.getInt("Id") + "", indice);
                id.setLongitud(id.getLongitud() + 1);
                
                nombres.Agregar(rs.getString("Nombres"), indice);
                nombres.setLongitud(nombres.getLongitud() + 1);
                
                apellidos.Agregar(rs.getString("Apellidos"), indice);
                apellidos.setLongitud(apellidos.getLongitud() + 1);
                
                usuarios.Agregar(rs.getString("Usuario"), indice);
                usuarios.setLongitud(usuarios.getLongitud() + 1);
                
                cedulas.Agregar(rs.getString("Cedula"), indice);
                cedulas.setLongitud(cedulas.getLongitud() + 1);
                
                roles.Agregar(rs.getString("Rol"), indice);
                roles.setLongitud(roles.getLongitud() + 1);
                
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
        
        listas[0] = id;
        listas[1] = nombres;
        listas[2] = apellidos;
        listas[3] = usuarios;
        listas[4] = cedulas;
        listas[5] = roles;
        
        return listas;
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
    
    public String getRol(String usuario){
        String rol = "";
        java.sql.Connection cn = null;
        
        try{
            cn = connection.getConnection();
            
            String query = "select Rol from(\n"
                    + "    select m.ID,\n"
                    + "    m.NOMBRES as Nombres,\n"
                    + "    m.APELLIDOS as Apellidos,\n"
                    + "    m.USUARIO as Usuario,\n"
                    + "    m.CEDULA as Cedula,\n"
                    + "case a.ID\n"
                    + "    when is not null then 'Administrador'\n"
                    + "    else\n"
                    + "        case e.ID\n"
                    + "            when is not null then 'Editor'\n"
                    + "            else 'Invitado'\n"
                    + "        end\n"
                    + "end as Rol\n"
                    + "from Miembros as m\n"
                    + "left join Administradores as a on m.ID = a.MIEMBROID\n"
                    + "left join Editores as e on m.ID = e.MIEMBROID\n"
                    + "left join Invitados as i on m.ID = i.MIEMBROID\n"
                    + "where \n"
                    + "m.USUARIO = ?\n"
                    + ") as Rol";
            
            PreparedStatement pstmt = cn.prepareCall(query);
            pstmt.setString(1, usuario);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                rol = rs.getString("Rol");
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
        
        return rol;
    }
} // FIN DE CLASE ABSTRACTA MIEMBRO.

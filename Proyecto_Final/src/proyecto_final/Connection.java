/***
 * Clase Connection.
 * Establece la conexión con la base de datos Derby.
 * Última modificación: 24/10/21.
 */
package proyecto_final;

import java.sql.*;
import java.sql.DriverManager;

public class Connection {
    public java.sql.Connection getConnection(){
        java.sql.Connection connection = null;
        try{
            String dbURL = "jdbc:derby://localhost:1527/Proyecto_Estructuras;create=true";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(dbURL, user, password);
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return connection;
    }
}

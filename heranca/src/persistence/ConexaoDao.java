
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDao {
    
    private Connection conecta;
    
    public Connection conectar() {
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             conecta = DriverManager.getConnection("jdbc:mysql://localhost:3306/teste", "root", "teruel");
             return conecta;
         } catch (ClassNotFoundException | SQLException ex) {
             return null;
         }
    }
}

package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDao implements InterfaceDao{
     private Connection conecta;
     private PreparedStatement st;
     
    @Override
    public boolean conectar() {
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             conecta = DriverManager.getConnection("jdbc:mysql://localhost:3306/teste", "root", "teruel");
             return true;
         } catch (ClassNotFoundException | SQLException ex) {
             return false;
         }
    }

    @Override
    public int salvar(Pessoa p) {
        return 1;
    }
    
}

package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FuncionarioDao {
  private Connection conecta;
  private PreparedStatement st;
  private ResultSet resultado;

    //Método para conectar no BD
    public boolean conectar(){
      try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          conecta = DriverManager.getConnection("jdbc:mysql://localhost:3306/controle", "root", "teruel");        
          return true;
      } catch (ClassNotFoundException | SQLException ex) {
          return false; 
      }
    }
  
    //Método para salvar dados na tabela funcionarios
  
    //Método para excluir dados da tabela funcionarios
  
    //Método para consultar dados da tabela funcionarios
    
    //Método para alterar dados da tabela funcionarios
  
}

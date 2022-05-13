package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDao {
  private Connection conecta;
  private PreparedStatement st;
  private ResultSet resultado;
  
  public FuncionarioDao(){
      
  }

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
    public int salvar(Funcionario func){
     //retorna 1 se a gravação deu certo
     //retorna 1062 se vc está tentando cadastrar uma matrícula que já foi cadastrada
     //retorn 0 se deu qualquer outro tipo de erro na gravação
     try{
        st = conecta.prepareStatement("INSERT INTO funcionarios VALUES(?,?,?,?)");
        st.setInt(1, func.getMatricula());
        st.setString(2, func.getNome());
        st.setString(3, func.getCargo());
        st.setDouble(4, func.getSalario());
        st.executeUpdate();
        return 1;
     }catch(SQLException ex){
        if (ex.getErrorCode()==1062){
            return 1062;
        }else{
            return 0;
        }
     }
    }
    
    
    //Método para excluir dados da tabela funcionarios
  
    //Método para consultar dados da tabela funcionarios
    public Funcionario consultar(int matricula){
      Funcionario func;
      try {
          st = conecta.prepareStatement("SELECT * FROM funcionarios WHERE matricula = ?");
          st.setInt(1, matricula);
          resultado = st.executeQuery(); //executar o select preparado acima
          if(resultado.next()){ //Se encontrou a matricula
             func = new Funcionario();
             func.setNome(resultado.getString("nome"));
             func.setCargo(resultado.getString("cargo"));
             func.setSalario(resultado.getDouble("salario"));
             return func;
          } else {//se não encontrou a matrícula
              return null;
          }
      } catch (SQLException ex) {
          return null;
      }
    }
    //Método para alterar dados da tabela funcionarios
  
}

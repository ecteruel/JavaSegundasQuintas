
package persistence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FuncionarioDao implements InterfaceDao{
     private Connection conecta;
     private PreparedStatement st;
         
    @Override
    public boolean conectar() {
         String driver, url, usuario, senha;

         driver = "com.mysql.cj.jdbc.Driver";
         url = "jdbc:mysql://localhost:3306/teste";
         usuario = "root";
         senha = "teruel";
        
         try {
             Class.forName(driver);
             conecta = DriverManager.getConnection(url, usuario, senha);
             return true;
         } catch (ClassNotFoundException | SQLException ex) {
             return false;
         }
    }

     @Override
     public int salvar(Pessoa p) {
         try {
             Funcionario func = (Funcionario) p;
             String sql;
             sql = "INSERT INTO funcionario VALUES(?,?,?,?,?,?,?,?,?)";
             st = conecta.prepareStatement(sql);
             st.setInt(1, func.getCodigo());
             st.setString(2, func.getNome());
             st.setString(3, func.getCpf());
             st.setString(4, func.getRg());
             st.setString(5, func.getEndereco());
             st.setString(6, func.getTelefone());
             st.setString(7, func.getEmail());
             st.setString(8, func.getCargo());
             st.setDouble(9, func.getSalario());
             st.executeUpdate();
             return 1;
         } catch (SQLException ex) {
             if(ex.getErrorCode()==1062){
                 return 1062;
             } else {
                 return 0;
             }
         }
    }
    
}

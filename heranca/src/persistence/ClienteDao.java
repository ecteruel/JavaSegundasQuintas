package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDao implements InterfaceDao{
     private Connection conecta;
     private PreparedStatement st;
     
     @Override
     public int salvar(Pessoa p) {
         try {
             Cliente cli = (Cliente) p;
             String sql;
             sql = "INSERT INTO cliente VALUES(?,?,?,?,?,?,?,?)";
             st = conecta.prepareStatement(sql);
             st.setInt(1, cli.getCodigo());
             st.setString(2, cli.getNome());
             st.setString(3, cli.getCpf());
             st.setString(4, cli.getRg());
             st.setString(5, cli.getEndereco());
             st.setString(6, cli.getTelefone());
             st.setString(7, cli.getEmail());
             st.setDouble(8, cli.getRendaFamiliar());
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

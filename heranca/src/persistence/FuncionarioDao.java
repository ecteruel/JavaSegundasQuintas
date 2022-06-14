package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDao implements InterfaceDao {

    private Connection conecta;
    private PreparedStatement st;
    private ResultSet rs;

    //Fazer a conexão com o BD por meio do método conectar da 
    //classe ConexaoDao
    public FuncionarioDao() {
        ConexaoDao dao;
        dao = new ConexaoDao();
        this.conecta = dao.conectar();
    }

    @Override
    public int salvar(Pessoa p) {
        try {
            Funcionario func = (Funcionario) p;
            String sql;
            sql = "INSERT INTO funcionario VALUES(?,?,?,?,?,?,?,?,?)";
            st = this.conecta.prepareStatement(sql);
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
            if (ex.getErrorCode() == 1062) {
                return 1062;
            } else {
                return 0;
            }
        }
    }

    public ArrayList relatorio(String nome) {
        ArrayList<Funcionario> listaFuncionarios;
        String sql;
        Funcionario func;
        listaFuncionarios = new ArrayList<Funcionario>();
        sql = "SELECT * FROM funcionario WHERE nome LIKE ?";
        try {
            st = this.conecta.prepareStatement(sql);
            st.setString(1, '%' + nome + '%');
            rs = st.executeQuery();
            while(rs.next()){
                func = new Funcionario(
                  rs.getString("cargo"),
                  rs.getDouble("salario"),
                  rs.getInt("codigo"),
                  rs.getString("nome"),
                  rs.getString("cpf"),
                  rs.getString("rg"),
                  rs.getString("endereco"),
                  rs.getString("telefone"),
                  rs.getString("email")
                );
                listaFuncionarios.add(func);
            }
            return listaFuncionarios;
        } catch (SQLException ex) {
           return null; 
        }
    }

}

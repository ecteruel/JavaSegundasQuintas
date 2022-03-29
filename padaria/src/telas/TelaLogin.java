package telas;

//Guardar na memória a conexão com o banco de Dados
import java.sql.Connection;
//Guardar na memória e executar comando SQL (INSERT, SELECT, UPDATE..)
import java.sql.PreparedStatement;
//Tratar problemas causados pela informação incorreta de dados do BD (nome do BD, senha, porta, usuário, nome da tabela)
import java.sql.SQLException;
//Informar o caminho do BD, nome do BD, usuario e senha
import java.sql.DriverManager;
//Guardar o que retorna do BD em uma consulta (SELECT)
import java.sql.ResultSet;
//Exibir caixas de diálogo (mensagens)
import javax.swing.JOptionPane;

public class TelaLogin extends javax.swing.JFrame {

    public TelaLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        pswSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        lblMensagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Acesso ao Sistemas");
        getContentPane().setLayout(null);

        lblUsuario.setText("Usuário:");
        getContentPane().add(lblUsuario);
        lblUsuario.setBounds(20, 20, 110, 40);

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(90, 20, 230, 40);

        lblSenha.setText("Senha:");
        getContentPane().add(lblSenha);
        lblSenha.setBounds(20, 80, 80, 40);

        pswSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pswSenhaKeyPressed(evt);
            }
        });
        getContentPane().add(pswSenha);
        pswSenha.setBounds(90, 82, 230, 40);

        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        btnEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEntrarKeyPressed(evt);
            }
        });
        getContentPane().add(btnEntrar);
        btnEntrar.setBounds(10, 150, 100, 30);

        btnCadastrar.setBackground(new java.awt.Color(153, 153, 255));
        btnCadastrar.setForeground(new java.awt.Color(51, 51, 255));
        btnCadastrar.setText("Cadastre-se");
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.setContentAreaFilled(false);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar);
        btnCadastrar.setBounds(240, 150, 95, 30);

        lblMensagem.setText("Não está cadastrado?");
        getContentPane().add(lblMensagem);
        lblMensagem.setBounds(130, 150, 130, 30);

        setSize(new java.awt.Dimension(393, 252));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        TelaCadastroUsuario telaCadastro;
        telaCadastro = new TelaCadastroUsuario();
        telaCadastro.setVisible(true);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        if (txtUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o nome do usuário");
            txtUsuario.requestFocus();
            return; // para a execução nesta linha (stop)       
        }
        if (pswSenha.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha a senha");
            pswSenha.requestFocus();
            return; // para a execução nesta linha (stop)      
        }
        try {
            Connection conexao;
            PreparedStatement st;
            ResultSet resultado;
            //Conexão com o BD
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancopadaria", "root", "teruel");
            //Busca o usuário na tabela do BD
            st = conexao.prepareStatement("SELECT * FROM usuario WHERE usuario=? AND senha=?");
            st.setString(1, txtUsuario.getText());
            st.setString(2, pswSenha.getText());
            resultado = st.executeQuery(); //Executa o SELECT criado acima
            if (resultado.next()) { // Se encontrou o usuário na tabela
                TelaMenu tela;
                tela = new TelaMenu();
                tela.setVisible(true);
            } else { //Senão encontrou o usuário
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos");
                txtUsuario.requestFocus();
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(btnEntrar, "Você não tem o driver na biblioteca");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(btnEntrar, "Algum parâmetro do BD está incorreto");
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void pswSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pswSenhaKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            btnEntrar.requestFocus(); //Método que tienes que crearte
        }
    }//GEN-LAST:event_pswSenhaKeyPressed

    private void btnEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEntrarKeyPressed
         if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            btnEntrar.doClick();//Método que tienes que crearte
        }
    }//GEN-LAST:event_btnEntrarKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField pswSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}


package view;

import javax.swing.JOptionPane;
import persistence.Funcionario;
import persistence.FuncionarioDao;
import persistence.Pessoa;

public class TelaFuncionarios extends javax.swing.JFrame {

    public TelaFuncionarios() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblRg = new javax.swing.JLabel();
        txtRg = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCargo = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblSalario = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();

        setTitle("Controle de funcionários");
        getContentPane().setLayout(null);

        lblTelefone.setText("Telefone");
        getContentPane().add(lblTelefone);
        lblTelefone.setBounds(10, 210, 100, 30);
        getContentPane().add(txtTelefone);
        txtTelefone.setBounds(120, 210, 150, 30);

        lblEndereco.setText("Endereço");
        getContentPane().add(lblEndereco);
        lblEndereco.setBounds(10, 170, 100, 30);
        getContentPane().add(txtEndereco);
        txtEndereco.setBounds(120, 170, 330, 30);

        lblRg.setText("RG");
        getContentPane().add(lblRg);
        lblRg.setBounds(10, 130, 100, 30);
        getContentPane().add(txtRg);
        txtRg.setBounds(120, 130, 150, 30);

        lblCpf.setText("CPF");
        getContentPane().add(lblCpf);
        lblCpf.setBounds(10, 90, 100, 30);
        getContentPane().add(txtCpf);
        txtCpf.setBounds(120, 90, 150, 30);

        lblNome.setText("Nome");
        getContentPane().add(lblNome);
        lblNome.setBounds(10, 50, 100, 30);
        getContentPane().add(txtNome);
        txtNome.setBounds(120, 50, 320, 30);

        lblCargo.setText("Cargo");
        getContentPane().add(lblCargo);
        lblCargo.setBounds(10, 290, 100, 30);
        getContentPane().add(txtCargo);
        txtCargo.setBounds(120, 290, 240, 30);

        lblCodigo.setText("Código");
        getContentPane().add(lblCodigo);
        lblCodigo.setBounds(10, 10, 100, 30);
        getContentPane().add(txtCodigo);
        txtCodigo.setBounds(120, 10, 150, 30);

        lblEmail.setText("Email");
        getContentPane().add(lblEmail);
        lblEmail.setBounds(10, 250, 100, 30);
        getContentPane().add(txtEmail);
        txtEmail.setBounds(120, 250, 240, 30);

        lblSalario.setText("Salário");
        getContentPane().add(lblSalario);
        lblSalario.setBounds(10, 330, 100, 30);
        getContentPane().add(txtSalario);
        txtSalario.setBounds(120, 330, 150, 30);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(10, 370, 140, 40);

        btnRelatorio.setText("Relatório");
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });
        getContentPane().add(btnRelatorio);
        btnRelatorio.setBounds(170, 370, 160, 40);

        setSize(new java.awt.Dimension(602, 461));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void limpar(){
        txtSalario.setText("");
        txtCargo.setText("");
        txtCodigo.setText("");
        txtNome.setText("");
        txtCpf.setText("");
        txtRg.setText("");
        txtEndereco.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        txtCodigo.requestFocus();
    }
        
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        //Declaração de variáveis
        Pessoa func;
        FuncionarioDao dao; //para chamar o método conectar e salvar 
        int salvou; //para receber o retorno do método salvar
        
        //Armazena os dados da tela em no objeto func
        func = new Funcionario(        
                txtCargo.getText(),
                Double.parseDouble(txtSalario.getText()),
                Integer.parseInt(txtCodigo.getText()),
                txtNome.getText(),
                txtCpf.getText(),
                txtRg.getText(),
                txtEndereco.getText(),
                txtTelefone.getText(),
                txtEmail.getText()
        );

        dao = new FuncionarioDao(); //faz a conexão com o BD
        salvou = dao.salvar(func);
        if(salvou==1){
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
            limpar();
        }else if (salvou==1062){
            JOptionPane.showMessageDialog(null,"Funcionário já cadastrado");
        }else{
            JOptionPane.showMessageDialog(null,"Erro ao salvar");                
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        new TelaRelatorioFuncionario().setVisible(true);
    }//GEN-LAST:event_btnRelatorioActionPerformed

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
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFuncionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRg;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRg;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}

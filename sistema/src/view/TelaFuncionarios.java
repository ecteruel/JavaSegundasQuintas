/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import business.FuncionarioService;
import javax.swing.JOptionPane;
import persistence.Funcionario;
import persistence.FuncionarioDao;



/**
 *
 * @author Evandro Teruel
 */
public class TelaFuncionarios extends javax.swing.JFrame {

    /**
     * Creates new form TelaFuncionarios
     */
    public TelaFuncionarios() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMatricula = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCargo = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        lblSalario = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle de funcionários");
        getContentPane().setLayout(null);

        lblMatricula.setText("Matrícula");
        getContentPane().add(lblMatricula);
        lblMatricula.setBounds(30, 30, 80, 30);
        getContentPane().add(txtMatricula);
        txtMatricula.setBounds(120, 30, 100, 30);

        lblNome.setText("Nome");
        getContentPane().add(lblNome);
        lblNome.setBounds(30, 70, 80, 30);
        getContentPane().add(txtNome);
        txtNome.setBounds(120, 70, 390, 30);

        lblCargo.setText("Cargo");
        getContentPane().add(lblCargo);
        lblCargo.setBounds(30, 110, 80, 30);
        getContentPane().add(txtCargo);
        txtCargo.setBounds(120, 110, 240, 30);

        lblSalario.setText("Salário");
        getContentPane().add(lblSalario);
        lblSalario.setBounds(30, 150, 80, 30);
        getContentPane().add(txtSalario);
        txtSalario.setBounds(120, 150, 90, 30);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(40, 200, 130, 30);

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar);
        btnPesquisar.setBounds(230, 30, 130, 30);

        setSize(new java.awt.Dimension(559, 290));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        //Declaração de variáveis
        boolean resposta; // receber o retorno do método conectar
        FuncionarioDao dao;
        int resultado;
        dao = new FuncionarioDao();
       
        boolean salarioCheck;
       
        
        salarioCheck = FuncionarioService.verificarSalario(Double.parseDouble(txtSalario.getText()));
        if (salarioCheck==true){
            JOptionPane.showMessageDialog(null,"Salário deve ser menor que 20000");
            txtSalario.requestFocus();
            return; //para a execução deste botão
        }
        
        //Encapsulamento dos dados do formulário em um objeto da classe Funcionario.java        
        Funcionario func;
        func = new Funcionario(
                Integer.parseInt(txtMatricula.getText()),
                txtNome.getText(),
                txtCargo.getText(),
                Double.parseDouble(txtSalario.getText())
        ); 
      
      //Conectar ao Banco de dados por meio do método conectar da classe FuncionarioDao.java
      resposta = dao.conectar(); //resposta pode conter true ou false
      if(resposta){ //conectou
          //Se conectou, salvar os dados contidos no objeto func na tabela do banco de dados
          //por meio do métrodo salvar da classe FuncionarioDao.java
          resultado = dao.salvar(func);
          if(resultado==1062){
              JOptionPane.showMessageDialog(null,"Essa matricula já está cadastrada");
              txtMatricula.requestFocus();
          }else if(resultado==1){
              JOptionPane.showMessageDialog(null,"Funcionário salvo com sucesso");
              limpar();
          } else{
              JOptionPane.showMessageDialog(null,"Erro na gravação");
          }
      }else{ //não conectou
          JOptionPane.showMessageDialog(null,"Erro na conexão");
      }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        FuncionarioDao dao;
        Funcionario func;
        boolean conectou;
        
        //1)Conexão com o BD
          dao = new FuncionarioDao();
          conectou = dao.conectar();
          if(conectou){
            //2)Se conectou, pega a matrícula do txtMatricula e passa para
            //o método consultar da classe FuncionarioDao e receber o 
            //Funcionario consultado
             
            func = dao.consultar(Integer.parseInt(txtMatricula.getText()));
            if(func==null){ //não localizou
                //3) Se retornou um funcionario, exibir os dados na tela
                // se retornou nulo, exibir mensagem de "Não localizado"
                JOptionPane.showMessageDialog(null,"Matricula não localizada");            
                limpar();
            }else{ //localizou o funcionario
               txtNome.setText(func.getNome());
               txtCargo.setText(func.getCargo());
               txtSalario.setText(String.valueOf(func.getSalario()));
            }    
          }else{ //Não conectou ao BD
            JOptionPane.showMessageDialog(null,"Erro na conexão");  
          }        
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void limpar(){
        txtMatricula.setText("");
        txtNome.setText("");
        txtCargo.setText("");
        txtSalario.setText("");
        txtMatricula.requestFocus();
    }
    
    
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
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSalario;
    // End of variables declaration//GEN-END:variables
}

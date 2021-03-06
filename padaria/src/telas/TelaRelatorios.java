/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Evandro Teruel
 */
public class TelaRelatorios extends javax.swing.JFrame {
    
    DefaultTableModel defTable;
    /**
     * Creates new form TelaRelatorios
     */
    public TelaRelatorios() {
        initComponents();
        txtNome.setVisible(false);
        lblNome.setVisible(false);
        txtCategoria.setVisible(false);
        lblCategoria.setVisible(false);
        defTable = (DefaultTableModel) tblProdutos.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTipoRelatorio = new javax.swing.JLabel();
        cmbTipoRelatorio = new javax.swing.JComboBox<>();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btnObterDados = new javax.swing.JButton();

        setTitle("Relatórios de produtos");
        getContentPane().setLayout(null);

        lblTipoRelatorio.setText("Tipo de Relatório");
        getContentPane().add(lblTipoRelatorio);
        lblTipoRelatorio.setBounds(10, 10, 120, 50);

        cmbTipoRelatorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Geral", "Por categoria", "Por nome" }));
        cmbTipoRelatorio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoRelatorioItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbTipoRelatorio);
        cmbTipoRelatorio.setBounds(130, 22, 160, 30);

        lblNome.setText("Nome do produto");
        getContentPane().add(lblNome);
        lblNome.setBounds(320, 20, 120, 30);
        getContentPane().add(txtNome);
        txtNome.setBounds(440, 20, 140, 30);

        lblCategoria.setText("Categoria");
        getContentPane().add(lblCategoria);
        lblCategoria.setBounds(320, 20, 120, 30);
        getContentPane().add(txtCategoria);
        txtCategoria.setBounds(440, 20, 140, 30);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(590, 20, 140, 30);

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Categoria", "Preço"
            }
        ));
        jScrollPane1.setViewportView(tblProdutos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 70, 710, 330);

        btnObterDados.setText("Obter Dados");
        btnObterDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObterDadosActionPerformed(evt);
            }
        });
        getContentPane().add(btnObterDados);
        btnObterDados.setBounds(50, 415, 180, 30);

        setSize(new java.awt.Dimension(766, 495));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //1 - Pegar o conteúdo do combo de tipo de relatório
        String tipoRelatorio;
        tipoRelatorio = cmbTipoRelatorio.getSelectedItem().toString();
        //2 - Conectar com o Banco de dados
        try {
            Connection conexao;
            PreparedStatement st;
            ResultSet resultado;

            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancopadaria", "root", "teruel");
            //Verifica o conteúdo do comboBox de tipo de relatório
            if (tipoRelatorio.equalsIgnoreCase("Geral")) {
                st = conexao.prepareStatement("SELECT * FROM produtos");
                resultado = st.executeQuery();
                
                defTable.setRowCount(0);
                while (resultado.next()) {
                    Object[] linha = {resultado.getString("codigo"), resultado.getString("nome"), resultado.getString("categoria"), resultado.getString("preco")};
                    defTable.addRow(linha);
                }
            } else if (tipoRelatorio.equalsIgnoreCase("Por categoria")) {
                st = conexao.prepareStatement("SELECT * FROM produtos WHERE categoria LIKE ?");
                st.setString(1, "%" + txtCategoria.getText() + "%");
                resultado = st.executeQuery();
                
                defTable.setRowCount(0);
                while (resultado.next()) {
                    Object[] linha = {resultado.getString("codigo"), resultado.getString("nome"), resultado.getString("categoria"), resultado.getString("preco")};
                    defTable.addRow(linha);
                }
            } else if (tipoRelatorio.equalsIgnoreCase("Por nome")) {
                st = conexao.prepareStatement("SELECT * FROM produtos WHERE nome LIKE ?");
                st.setString(1, "%" + txtNome.getText() + "%");
                resultado = st.executeQuery();

                defTable.setRowCount(0);
                while (resultado.next()) {
                    Object[] linha = {resultado.getString("codigo"), resultado.getString("nome"), resultado.getString("categoria"), resultado.getString("preco")};
                    defTable.addRow(linha);
                }
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Você não tem o driver na biblioteca " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Algum parâmetro do BD está incorreto" + ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cmbTipoRelatorioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoRelatorioItemStateChanged
        String tipo;
        tipo = cmbTipoRelatorio.getSelectedItem().toString();
        if(tipo.equalsIgnoreCase("Por categoria")){
            txtCategoria.setVisible(true);
            lblCategoria.setVisible(true);
            txtNome.setVisible(false);
            lblNome.setVisible(false);
            defTable.setRowCount(0);
        }else if(tipo.equalsIgnoreCase("Por nome")){
            txtNome.setVisible(true);
            lblNome.setVisible(true);
            txtCategoria.setVisible(false);
            lblCategoria.setVisible(false);
            defTable.setRowCount(0);
        }else if(tipo.equalsIgnoreCase("Geral")){
            txtCategoria.setVisible(false);
            lblCategoria.setVisible(false);
            txtNome.setVisible(false);
            lblNome.setVisible(false);
            defTable.setRowCount(0);            
        }
    }//GEN-LAST:event_cmbTipoRelatorioItemStateChanged

    private void btnObterDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObterDadosActionPerformed
        //pega o número de linhas da tabela tblProdutos
        int qtdLinhas = tblProdutos.getRowCount();
        String codigo = (String) tblProdutos.getModel().getValueAt(tblProdutos.convertRowIndexToModel(0), 0);
    }//GEN-LAST:event_btnObterDadosActionPerformed

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
            java.util.logging.Logger.getLogger(TelaRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnObterDados;
    private javax.swing.JComboBox<String> cmbTipoRelatorio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTipoRelatorio;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}

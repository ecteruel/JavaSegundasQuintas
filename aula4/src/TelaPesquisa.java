
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaPesquisa extends JFrame {

private JLabel lblNome;
private JTextField txtNome; 
private JButton btnBuscar;
    
    public TelaPesquisa() {
        // Criação da nova Janela
        setLayout(null);
        setTitle("Formulário de pesquisa");
        setSize(600, 250);
        setLocation(100, 100);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

       //Comando para colocar elementos na janela
       lblNome = new JLabel("Nome"); // Determina o que aparecerá escrito no rótulo
       lblNome.setSize(80,30); //Determina a largura e altura do rótulo
       lblNome.setLocation(10,20); //Determina margem esquerda e superior
       add(lblNome); // Adiciona o rótulo na janela JFrame
       
       txtNome = new JTextField();
       txtNome.setSize(400,30);
       txtNome.setLocation(90, 20);
       add(txtNome);
       
       btnBuscar = new JButton("Buscar");
       btnBuscar.setSize(100,40);
       btnBuscar.setLocation(10, 100);
       add(btnBuscar);
        
    }

}

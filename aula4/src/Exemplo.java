import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Exemplo extends JFrame {
    //Atributos
    private JLabel lblNome, lblEndereco; 
    private JTextField txtNome, txtEndereco;
    private JButton btnSalvar;    
       
    //Construtor - gerar os elementos de tela. 
    //Deve ter o mesmo nome da classe
    public Exemplo() {
        //Criar a janela
        setLayout(null); //você criará seu próprio layout
        setTitle("Controle de clientes");
        setSize(800,300); //tamanho da janela - 500px largura e 300px altura
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Ao clicar no X da janela ele fecha da tela e da memória
        setLocation(200,300); // 200px margem esquerda e 300px acima

       //Comando para colocar elementos na janela
       lblNome = new JLabel("Nome"); // Determina o que aparecerá escrito no rótulo
       lblNome.setSize(80,30); //Determina a largura e altura do rótulo
       lblNome.setLocation(10,20); //Determina margem esquerda e superior
       add(lblNome); // Adiciona o rótulo na janela JFrame
       
       txtNome = new JTextField();
       txtNome.setSize(400,30);
       txtNome.setLocation(90, 20);
       add(txtNome);         
       
       lblEndereco = new JLabel("Endereço:");
       lblEndereco.setSize(100,30);
       lblEndereco.setLocation(10,60);
       add(lblEndereco);
       
       txtEndereco = new JTextField();
       txtEndereco.setSize(500,30);
       txtEndereco.setLocation(90,60);
       add(txtEndereco);

       btnSalvar = new JButton("Salvar");
       btnSalvar.setSize(80,30);
       btnSalvar.setLocation(10,100);
       add(btnSalvar);
       
    }    
    
    //Métodos
    public static void main(String[] args) {
        Exemplo tela;
        tela = new Exemplo();
        tela.setVisible(true);
    }


}

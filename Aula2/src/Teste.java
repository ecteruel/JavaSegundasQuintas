
import javax.swing.JOptionPane;

public class Teste {

    public static void main(String[] args) {
        //Declaração de varíaveis
        String nome, endereco, telefone; 

        // Armazena valores nas variáveis
        nome = JOptionPane.showInputDialog("Qual o seu Nome?");
        endereco = JOptionPane.showInputDialog("Qual o seu endereço?");;
        telefone = JOptionPane.showInputDialog("Qual o seu Telefone?");;

        //Exibe na tela o conteúdo das variáveis de memória 
        JOptionPane.showMessageDialog(null,"Seu nome é " + nome);
        JOptionPane.showMessageDialog(null, "Seu endereço é " + endereco);
        JOptionPane.showMessageDialog(null, "Seu telefone é " + telefone);
    }
}

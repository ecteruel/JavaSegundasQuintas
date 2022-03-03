import javax.swing.JOptionPane;

public class Teste {

    public static void main(String[] args) {
        //Declaração de variáveis
        String nome, endereco, telefone; //cadeia de caracteres
        byte idade; //Armazena números inteiros (45)
        float altura, salario; // armazena números reais (1.87) (16578.50)
        
        // Armazena valores nas variáveis (perguntas) 
        nome = JOptionPane.showInputDialog("Qual o seu Nome?");
        endereco = JOptionPane.showInputDialog("Qual o seu endereço?");
        telefone = JOptionPane.showInputDialog("Qual o seu Telefone?");
        try {
         idade = Byte.parseByte(JOptionPane.showInputDialog("Qual sua idade?"));
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Idade fora da faixa suportada. Mensagem de erro: " + e.getMessage());
            return;// Interrompe a execução do programa
        }
        try{        
         altura = Float.parseFloat(JOptionPane.showInputDialog("Qual sua altura?"));
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Digite um valor real suportado. Mensagem de erro: " + e.getMessage());
            return;// Interrompe a execução do programa            
        }
        try{
          salario = Float.parseFloat(JOptionPane.showInputDialog("Qual seu salário?"));
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Digite um valor real suportado para o salário. Mensagem de erro: " + e.getMessage());
            return;// Interrompe a execução do programa              
        }
        salario =  salario * 1.40F; //Aumentar em 40%
       
        //Exibe na tela o conteúdo das variáveis de memória 
        JOptionPane.showMessageDialog(null,"Seu nome é " + nome);
        JOptionPane.showMessageDialog(null, "Seu endereço é " + endereco);
        JOptionPane.showMessageDialog(null, "Seu telefone é " + telefone);
        JOptionPane.showMessageDialog(null, "Sua idade é " + idade);
        JOptionPane.showMessageDialog(null, "Você tem " + altura + " metros");

        System.out.println("Seu salário é " + salario);
        JOptionPane.showMessageDialog(null, "Seu salário é " + salario);
        
    }
}

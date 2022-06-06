
import javax.swing.JOptionPane;
public class Prova {
    public static void main(String[] args) {
        double average;
        String value;
        average = Double.parseDouble(JOptionPane.showInputDialog("Digite a média"));
        if(average<=5){
            value="Insuficiente";
        }else if(average<=6){
            value="Regular";
        } else if(average<=8){
            value="Bom";
        } else if(average<=10){
            value="Muito bom";
        }else {
            value="Média inválida";
        }
        System.out.println(value);
    }
}

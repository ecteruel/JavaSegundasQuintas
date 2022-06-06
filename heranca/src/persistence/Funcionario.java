
package persistence;

public class Funcionario extends Pessoa{
   private String cargo;
   private double salario;

    public Funcionario(String cargo, double salario, int codigo, String nome, String cpf, String rg, String endereco, String telefone, String email) {
        super(codigo, nome, cpf, rg, endereco, telefone, email);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

   
 
}

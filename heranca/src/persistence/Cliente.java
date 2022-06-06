
package persistence;

public class Cliente extends Pessoa {
    private double rendaFamiliar;

    public Cliente(double rendaFamiliar, int codigo, String nome, String cpf, String rg, String endereco, String telefone, String email) {
        super(codigo, nome, cpf, rg, endereco, telefone, email);
        this.rendaFamiliar = rendaFamiliar;
    }

    public double getRendaFamiliar() {
        return rendaFamiliar;
    }

    public void setRendaFamiliar(double rendaFamiliar) {
        this.rendaFamiliar = rendaFamiliar;
    }
 
}

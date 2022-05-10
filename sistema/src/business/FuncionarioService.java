package business;

public class FuncionarioService {

    public FuncionarioService() {
    }

    //método de negócio - verifica uma regra de negócio
    public boolean verificarSalario(double salario) {
        if (salario >= 20000) {
            return true;
        } else {
            return false;
        }
    }
}

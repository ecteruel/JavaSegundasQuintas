/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

public class FuncionarioService {

    public FuncionarioService() {
    }

    //método de negócio - verifica uma regra de negócio
    public static boolean verificarSalario(double salario) {
        if (salario >= 20000) {
            return true;
        } else {
            return false;
        }
    }
}

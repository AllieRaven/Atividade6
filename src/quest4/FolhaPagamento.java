package quest4;

import java.util.ArrayList;
import java.util.List;

public class FolhaPagamento {

    private double totalPagar;
    private List<Funcionario> funcionarios = new ArrayList<>();

    public FolhaPagamento(){
        this.totalPagar = 0.0;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public double calcularTotal(){
        totalPagar = 0;
        for (Funcionario funcionario : funcionarios){
            totalPagar += funcionario.calcularSalario();
        }
        return totalPagar;
    }
}

package Questao4;

import Questao4.Funcionarios.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FolhaDePagamento {
    private List<Funcionario> funcionarios;
    public FolhaDePagamento() {
        funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public double calcularTotalFolha() {
        double total = 0;

        for (Funcionario funcionario : funcionarios) {
            total += funcionario.calcularSalario();
        }
        return total;
    }

    public void imprimirFolha() {
        System.out.println("===== FOLHA DE PAGAMENTO =====");

        for (Funcionario funcionario : funcionarios) {
            System.out.printf(
                    "Matrícula: %-8s | Nome: %-20s | Salário: R$ %9.2f%n",
                    funcionario.getMatricula(), funcionario.getNome(), funcionario.calcularSalario()
            );
        }

        System.out.printf("Total da folha: R$ %.2f%n", calcularTotalFolha());
    }
}
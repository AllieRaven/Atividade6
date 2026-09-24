package Questao4.Funcionarios;

public class FuncionarioComissao extends Funcionario{

    private double salarioBase;
    private double totalVendas;
    private double percentualComissao;

    public FuncionarioComissao(String nome, String matricula, double salarioBase, double totalVendas, double percentualComissao) {
        super(nome, matricula);
        this.salarioBase = salarioBase;
        this.totalVendas = totalVendas;
        this.percentualComissao = percentualComissao;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (totalVendas*percentualComissao);
    }
}

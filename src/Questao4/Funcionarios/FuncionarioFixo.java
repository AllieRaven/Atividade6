package Questao4.Funcionarios;

public class FuncionarioFixo extends Funcionario{

    private double salarioFixo;

    public FuncionarioFixo(String nome, String matricula, double salarioFixo) {
        super(nome, matricula);
        this.salarioFixo = salarioFixo;
    }

    @Override
    public double calcularSalario() {
        return salarioFixo;
    }
}

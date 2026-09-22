package quest4;

public class FuncionarioComissionado extends Funcionario {

    private double salario;
    private double vendas;
    private double porcentagem = 0.5;


    public FuncionarioComissionado(String nome, int matricula, double salario, double vendas){
        super(nome,matricula);
        this.salario = salario;
        this.vendas = vendas;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    @Override
    public double calcularSalario(){
        return salario + (vendas * porcentagem);
    }
}


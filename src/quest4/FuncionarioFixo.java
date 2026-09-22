package quest4;

public class FuncionarioFixo extends Funcionario {

    private double salario;

    public FuncionarioFixo(String nome, int matricula, double salario){
        super(nome,matricula);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public double calcularSalario(){
        return salario;
    }
}

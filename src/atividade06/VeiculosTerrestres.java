package atividade06;

public abstract class VeiculosTerrestres extends Veiculo {
    boolean Combustivel;

    public VeiculosTerrestres(String identificacao, boolean Combustivel) {
        super(identificacao);
        this.Combustivel = Combustivel;
    }
}
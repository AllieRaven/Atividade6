package atividade06;

public class Onibus extends VeiculosTerrestres {
    public Onibus(String identificacao, boolean Combustivel) {
        super(identificacao, Combustivel);
    }

    @Override
    public void iniciarOperacao() {
        if (Combustivel) {
            System.out.println("atividade06.Onibus" + getIdentificacao() + "Começou a girar a roda");
        } else {
            System.out.println("A roda do ônibus não gira gira ;(");;
        }
    }
}
package atividade06;

public class Caminhao extends VeiculosTerrestres implements Carga {
    public Caminhao(String identificacao, boolean Combustivel) {
        super(identificacao, Combustivel);
    }

    @Override
    public void iniciarOperacao() {
        if(Combustivel) {
            System.out.println("Caminhão" + getIdentificacao() + "Começou a correr because ninguém tem medo de morrer");
        } else {
            System.out.println("Caminhão não pode correr;(");
        }
    }

    @Override
    public void carregar(){
        System.out.println("Caminhão mutcho pesado");
    }
}
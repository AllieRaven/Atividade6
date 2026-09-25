package atividade06;

public abstract class Veiculo {
    private String identificacao;

    public Veiculo(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public abstract void iniciarOperacao();
}
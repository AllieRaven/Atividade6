package Questao1;

public class Produto {
    private String nome;
    private double precoUnitario;
    private int quantidade;

    public void produto(String nome, double precoUnitario, int quantidade){
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    double calcularPrecoProduto(){
        return quantidade*precoUnitario;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getNome() {
        return nome;
    }
}

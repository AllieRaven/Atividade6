package Questao1;

import Questao1.Entregas.*;

import java.util.List;

class Pedido {
    private String destinatario;
    private String endereco;
    private double peso;
    private TipoEntrega tipoEntrega;
    private List<Produto> produtos;
    private int distanciakm;

    private Entrega entrega;

    public Pedido(List<Produto> produtos, String destinatario, String endereco,
                  int distanciakm, double peso, TipoEntrega tipoEntrega) {

        this.produtos = produtos;
        this.destinatario = destinatario;
        this.endereco = endereco;
        this.distanciakm = distanciakm;
        this.peso = peso;
        this.tipoEntrega = tipoEntrega;

        this.entrega = criarEntrega();
    }

    public double calcularTotal() {
        double total = 0;

        for (Produto produto : produtos) {
            total += produto.calcularPrecoProduto();
        }

        return total + calcularFrete();
    }

    public double calcularFrete() {
        return entrega.calcularEntrega();
    }

    public void imprimirResumo() {
        System.out.printf(
                "Destinatário: %-15s | Endereço: %-15s | Peso: %5.2fkg | Tipo: %-18s | Frete: R$ %6.2f | Total: R$ %6.2f%n",

                destinatario,
                endereco,
                peso,
                entrega.getTipoEntrega(),
                calcularFrete(),
                calcularTotal()
        );
    }

    private Entrega criarEntrega() {
        switch (tipoEntrega) {
            case MOTO:
                return new EntregaMoto(distanciakm, peso);

            case CARRO:
                return new EntregaCarro(distanciakm, peso);

            case RETIRADA:
                return new EntregaRetirada(distanciakm, peso);

            default:
                throw new IllegalArgumentException(
                        "Tipo de entrega inválido"
                );
        }
    }

    public String getDestinatario() {
        return this.destinatario;
    }
}

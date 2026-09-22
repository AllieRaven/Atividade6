package Questao1.Entregas;

public class EntregaCarro extends Entrega {

    private final double TAXAFIXA = 7;
    private final double VALORKM = 3.5;

    public EntregaCarro(int distanciakm, double peso) {
        super(distanciakm,peso);
    }

    @Override
    public double calcularEntrega() {
        return TAXAFIXA + (VALORKM * distanciakm) +  (0.01*peso);
    }

    @Override
    public TipoEntrega getTipoEntrega() {
        return TipoEntrega.CARRO;
    }
}


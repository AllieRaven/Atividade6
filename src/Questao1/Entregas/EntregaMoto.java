package Questao1.Entregas;

public class EntregaMoto extends Entrega{

    private double TAXAFIXA = 15;
    private double VALORKM = 1.8;

    public EntregaMoto(int distanciakm, double peso) {
        super(distanciakm,peso);
    }


    @Override
    public double calcularEntrega() {
        return TAXAFIXA + (VALORKM * distanciakm) + (0.01*peso);
    }

    @Override
    public TipoEntrega getTipoEntrega() {
        return TipoEntrega.MOTO;
    }
}

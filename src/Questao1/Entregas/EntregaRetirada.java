package Questao1.Entregas;

public class EntregaRetirada extends Entrega{
    public EntregaRetirada(int distanciaKM, double peso) {
        super( distanciaKM, peso);
    }

    @Override
    public double calcularEntrega() {
        return super.calcularEntrega();
    }

    @Override
    public TipoEntrega getTipoEntrega() {
        return TipoEntrega.RETIRADA;
    }
}

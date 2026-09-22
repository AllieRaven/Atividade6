package Questao1.Entregas;

public abstract class Entrega {
    protected int distanciakm;
    protected double peso;

    public Entrega(int distanciakm, double peso) {
        this.distanciakm = distanciakm;
        this.peso = peso;
    }

    public double calcularEntrega(){return 0;};

    public abstract TipoEntrega getTipoEntrega();
}



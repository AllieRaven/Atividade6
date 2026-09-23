package Questao2.Controlaveis;

public class Ventilador implements Controlavel {
    private boolean ligado;
    private int velocidade; // 1 a 5

    public Ventilador() {
        this.ligado = false;
        this.velocidade = 1;
    }

    @Override
    public void ligar() {
        ligado = true;
        System.out.println("Ventilador ligado.");
    }

    @Override
    public void desligar() {
        ligado = false;
        System.out.println("Ventilador desligado.");
    }

    @Override
    public boolean isLigado() {
        return ligado;
    }

    public void ajustarVelocidade(int nivel) {
        if (nivel < 1 || nivel > 5) {
            throw new IllegalArgumentException("Velocidade deve estar entre 1 e 5");
        }
        this.velocidade = nivel;
        System.out.println("Velocidade do ventilador ajustada para " + nivel + ".");
    }

    public int getVelocidade() {
        return velocidade;
    }
}
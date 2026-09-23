package Questao2.Controlaveis;

public class FechaduraEletronica implements Controlavel {
    private boolean trancada;

    public FechaduraEletronica() {
        this.trancada = true; // começa trancada, por segurança
    }

    // Aqui "ligar" representa "trancar"
    @Override
    public void ligar() {
        trancada = true;
        System.out.println("Fechadura trancada.");
    }

    // e "desligar" representa "destrancar"
    @Override
    public void desligar() {
        trancada = false;
        System.out.println("Fechadura destrancada.");
    }

    @Override
    public boolean isLigado() {
        return trancada;
    }
}

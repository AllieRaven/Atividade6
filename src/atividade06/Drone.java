package atividade06;

public class Drone extends Veiculo {
    int Bateria;

    public Drone(String identificacao, int Bateria) {
        super(identificacao);
        this.Bateria = Bateria;
    }

    @Override
    public void iniciarOperacao(){
        if(Bateria >= 15) {
            System.out.println("atividade06.Drone" + getIdentificacao() + "Começou a rodar Regina");
        } else {
            System.out.println("Carregue seu dronezinho, bebezinha(o)");
        }
    }
}
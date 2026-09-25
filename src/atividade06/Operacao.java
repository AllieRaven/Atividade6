package atividade06;

import java.util.ArrayList;
import java.util.List;

public class Operacao {

    public void menu() {

        List<Veiculo> veiculos = new ArrayList<>();

        veiculos.add(new Caminhao("Caminhão1234", true));
        veiculos.add(new Onibus("Onibus1234", false));
        veiculos.add(new Drone("Drone1234", 30));

        for (Veiculo veiculo : veiculos) {
            veiculo.iniciarOperacao();
        }

        Caminhao c = new Caminhao("Caminhão1254", true);
        c.carregar();
    }
}
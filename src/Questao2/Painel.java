package Questao2;

import Questao2.Controlaveis.Controlavel;

import java.util.ArrayList;
import java.util.List;

public class Painel {
    private List<Controlavel> dispositivos;

    public Painel() {
        this.dispositivos = new ArrayList<>();
    }

    public void adicionarDispositivo(Controlavel dispositivo) {
        dispositivos.add(dispositivo);
    }

    public int quantidadeDispositivos() {
        return dispositivos.size();
    }

    public void ligarTodos() {
        for (Controlavel dispositivo : dispositivos) {
            dispositivo.ligar();
        }
    }

    public void desligarTodos() {
        for (Controlavel dispositivo : dispositivos) {
            dispositivo.desligar();
        }
    }

    public void ligarDispositivo(int indice) {
        dispositivos.get(indice).ligar();
    }

    public void desligarDispositivo(int indice) {
        dispositivos.get(indice).desligar();
    }

    public void imprimirEstados() {
        for (int i = 0; i < dispositivos.size(); i++) {
            Controlavel dispositivo = dispositivos.get(i);
            System.out.println(
                    (i + 1) + " - " + dispositivo.getClass().getSimpleName()
                            + " | Estado: " + (dispositivo.isLigado() ? "Ligado" : "Desligado")
            );
        }
    }
}
package atividade07;

public class DestinoExterno implements Destino {
    @Override

    public void enviar(Relatorio relatorio) {
        System.out.println("Enviando seu bigmegamaster relatório para sistema externo: " + relatorio.getTitulo());
    }
}
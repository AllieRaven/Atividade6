package atividade07;

public class DestinoImpressora implements Destino {
    @Override

    public void enviar(Relatorio relatorio) {
        System.out.println("Imprimindo seu big relatório: " + relatorio.getTitulo());
    }
}
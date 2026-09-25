package atividade07;

public class DestinoPDF implements Destino {
    @Override

    public void enviar(Relatorio relatorio) {
        System.out.println("Salvando o seu bigmega relatório em PDF: " + relatorio.getTitulo());
    }
}
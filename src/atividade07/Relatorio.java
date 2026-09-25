package atividade07;

public class Relatorio {
    private String titulo;
    private String conteudo;
    private Destino destino;

    public Relatorio(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getConteudo() {
        return conteudo;
    }
    public void enviar() {
        destino.enviar(this);
    }
    public void menu() {
        Relatorio relatorio = new Relatorio("Relatório mensal do bebezão", "Dados do mês de setembro arrasando!");

        relatorio.destino = new DestinoImpressora();
        relatorio.enviar();

        relatorio.destino = new DestinoPDF();
        relatorio.enviar();

        relatorio.destino = new DestinoExterno();
        relatorio.enviar();
    }
}
package Questao3;

import java.time.LocalDate;

public class Emprestimo {
    private LocalDate dataInicio;
    private LocalDate dataDevolucaoPrevista;
    private Livro livro;
    private Leitor leitor;

    public Emprestimo(Livro livro, Leitor leitor, LocalDate dataInicio, LocalDate dataDevolucaoPrevista) {
        this.livro = livro;
        this.leitor = leitor;
        this.dataInicio = dataInicio;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public Livro getLivro() {
        return livro;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void imprimirResumo() {
        System.out.printf(
                "Empréstimo | Livro: %-25s | Leitor: %-20s | Início: %s | Devolução prevista: %s%n",
                livro.getTitulo(), leitor.getNome(), dataInicio, dataDevolucaoPrevista
        );
    }
}
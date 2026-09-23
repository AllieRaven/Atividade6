package Questao3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private List<Livro> livros;
    private List<Leitor> leitores;
    private List<Emprestimo> emprestimos;
    private Scanner scanner;

    public Biblioteca() {
        livros = new ArrayList<>();
        leitores = new ArrayList<>();
        emprestimos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void menu() {

        int opcao;

        do {
            System.out.println("\n===== BIBLIOTECA =====");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Cadastrar leitor");
            System.out.println("3 - Listar livros");
            System.out.println("4 - Listar leitores");
            System.out.println("5 - Realizar empréstimo");
            System.out.println("6 - Listar empréstimos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;

                case 2:
                    cadastrarLeitor();
                    break;

                case 3:
                    listarLivros();
                    break;

                case 4:
                    listarLeitores();
                    break;

                case 5:
                    realizarEmprestimo();
                    break;

                case 6:
                    listarEmprestimos();
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void cadastrarLivro() {

        System.out.println("\n===== CADASTRAR LIVRO =====");

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        livros.add(new Livro(titulo, autor, isbn));

        System.out.println("Livro cadastrado com sucesso!");
    }

    private void cadastrarLeitor() {

        System.out.println("\n===== CADASTRAR LEITOR =====");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        leitores.add(new Leitor(nome, matricula));

        System.out.println("Leitor cadastrado com sucesso!");
    }

    private void listarLivros() {

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        System.out.println("\n===== LIVROS =====");

        for (int i = 0; i < livros.size(); i++) {
            System.out.println((i + 1) + " - " + livros.get(i));
        }
    }

    private void listarLeitores() {

        if (leitores.isEmpty()) {
            System.out.println("Nenhum leitor cadastrado.");
            return;
        }

        System.out.println("\n===== LEITORES =====");

        for (int i = 0; i < leitores.size(); i++) {
            System.out.println((i + 1) + " - " + leitores.get(i));
        }
    }

    private void listarEmprestimos() {

        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo cadastrado.");
            return;
        }

        System.out.println("\n===== EMPRÉSTIMOS =====");

        for (Emprestimo emprestimo : emprestimos) {
            emprestimo.imprimirResumo();
        }
    }

    private void realizarEmprestimo() {

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado. Cadastre um livro primeiro.");
            return;
        }

        if (leitores.isEmpty()) {
            System.out.println("Nenhum leitor cadastrado. Cadastre um leitor primeiro.");
            return;
        }

        Livro livro = selecionarLivro();
        Leitor leitor = selecionarLeitor();

        LocalDate dataInicio = lerData("Data de início (dd/MM/yyyy): ");
        LocalDate dataDevolucaoPrevista = lerData("Data de devolução prevista (dd/MM/yyyy): ");

        // Reaproveita a MESMA referência de Livro e de Leitor já cadastrados —
        // não cria cópias novas. É assim que um mesmo exemplar pode ter
        // vários empréstimos ao longo do tempo.
        Emprestimo emprestimo = new Emprestimo(livro, leitor, dataInicio, dataDevolucaoPrevista);
        emprestimos.add(emprestimo);

        System.out.println("Empréstimo registrado com sucesso!");
    }

    private Livro selecionarLivro() {

        listarLivros();

        System.out.print("Escolha o livro: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        if (numero < 1 || numero > livros.size()) {
            throw new IllegalArgumentException("Livro inválido!");
        }

        return livros.get(numero - 1);
    }

    private Leitor selecionarLeitor() {

        listarLeitores();

        System.out.print("Escolha o leitor: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        if (numero < 1 || numero > leitores.size()) {
            throw new IllegalArgumentException("Leitor inválido!");
        }

        return leitores.get(numero - 1);
    }

    private LocalDate lerData(String mensagem) {

        while (true) {
            System.out.print(mensagem);
            String texto = scanner.nextLine();

            try {
                return LocalDate.parse(texto, FORMATO_DATA);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida! Use o formato dd/MM/yyyy.");
            }
        }
    }
}
package Questao4;

import Questao4.Funcionarios.FuncionarioComissao;
import Questao4.Funcionarios.FuncionarioFixo;

import java.util.Scanner;

public class Empresa {

    private FolhaDePagamento folha;
    private Scanner scanner;

    public Empresa() {
        folha = new FolhaDePagamento();
        scanner = new Scanner(System.in);
    }

    public void menu() {

        int opcao;

        do {
            System.out.println("\n===== EMPRESA =====");
            System.out.println("1 - Cadastrar funcionário fixo");
            System.out.println("2 - Cadastrar funcionário comissionado");
            System.out.println("3 - Listar folha de pagamento");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarFuncionarioFixo();
                    break;

                case 2:
                    cadastrarFuncionarioComissionado();
                    break;

                case 3:
                    folha.imprimirFolha();
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void cadastrarFuncionarioFixo() {

        System.out.println("\n===== CADASTRAR FUNCIONÁRIO FIXO =====");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        System.out.print("Salário fixo: ");
        double salarioFixo = scanner.nextDouble();
        scanner.nextLine();

        folha.adicionarFuncionario(new FuncionarioFixo(nome, matricula, salarioFixo));

        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private void cadastrarFuncionarioComissionado() {

        System.out.println("\n===== CADASTRAR FUNCIONÁRIO COMISSIONADO =====");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        System.out.print("Salário base: ");
        double salarioBase = scanner.nextDouble();

        System.out.print("Total de vendas: ");
        double totalVendas = scanner.nextDouble();

        System.out.print("Percentual de comissão (ex.: 5 para 5%): ");
        double percentual = scanner.nextDouble();
        scanner.nextLine();

        folha.adicionarFuncionario(
                new FuncionarioComissao(nome, matricula, salarioBase, totalVendas, percentual / 100.0)
        );

        System.out.println("Funcionário cadastrado com sucesso!");
    }
}
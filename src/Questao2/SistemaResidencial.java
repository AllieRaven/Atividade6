package Questao2;

import Questao2.Controlaveis.Controlavel;
import Questao2.Controlaveis.FechaduraEletronica;
import Questao2.Controlaveis.Lampada;
import Questao2.Controlaveis.Ventilador;

import java.util.Scanner;

public class SistemaResidencial {

    private Painel painel;
    private Scanner scanner;

    public SistemaResidencial() {
        painel = new Painel();
        scanner = new Scanner(System.in);
    }

    public void menu() {

        int opcao;

        do {
            System.out.println("\n===== PAINEL RESIDENCIAL =====");
            System.out.println("1 - Cadastrar dispositivo");
            System.out.println("2 - Listar dispositivos");
            System.out.println("3 - Ligar dispositivo");
            System.out.println("4 - Desligar dispositivo");
            System.out.println("5 - Ligar todos");
            System.out.println("6 - Desligar todos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarDispositivo();
                    break;

                case 2:
                    listarDispositivos();
                    break;

                case 3:
                    ligarDispositivo();
                    break;

                case 4:
                    desligarDispositivo();
                    break;

                case 5:
                    painel.ligarTodos();
                    System.out.println("Todos os dispositivos foram ligados.");
                    break;

                case 6:
                    painel.desligarTodos();
                    System.out.println("Todos os dispositivos foram desligados.");
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void cadastrarDispositivo() {

        System.out.println("\n===== CADASTRAR DISPOSITIVO =====");
        System.out.println("1 - Lâmpada");
        System.out.println("2 - Ventilador");
        System.out.println("3 - Fechadura Eletrônica");
        System.out.print("Escolha o tipo: ");

        int tipo = scanner.nextInt();
        scanner.nextLine();

        Controlavel dispositivo;

        switch (tipo) {
            case 1:
                dispositivo = new Lampada();
                break;

            case 2:
                dispositivo = new Ventilador();
                break;

            case 3:
                dispositivo = new FechaduraEletronica();
                break;

            default:
                System.out.println("Tipo inválido!");
                return;
        }

        painel.adicionarDispositivo(dispositivo);
        System.out.println("Dispositivo cadastrado com sucesso!");
    }

    private void listarDispositivos() {

        if (painel.quantidadeDispositivos() == 0) {
            System.out.println("Nenhum dispositivo cadastrado.");
            return;
        }

        System.out.println("\n===== DISPOSITIVOS =====");
        painel.imprimirEstados();
    }

    private void ligarDispositivo() {

        if (painel.quantidadeDispositivos() == 0) {
            System.out.println("Nenhum dispositivo cadastrado.");
            return;
        }

        int indice = selecionarDispositivo();
        painel.ligarDispositivo(indice);
    }

    private void desligarDispositivo() {

        if (painel.quantidadeDispositivos() == 0) {
            System.out.println("Nenhum dispositivo cadastrado.");
            return;
        }

        int indice = selecionarDispositivo();
        painel.desligarDispositivo(indice);
    }

    private int selecionarDispositivo() {

        listarDispositivos();

        System.out.print("Escolha o dispositivo: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        if (numero < 1 || numero > painel.quantidadeDispositivos()) {
            throw new IllegalArgumentException("Dispositivo inválido!");
        }

        return numero - 1;
    }
}
package Questao1;

import Questao1.Entregas.TipoEntrega;

import java.util.Scanner;

public class Transportadora {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Pedido[] pedidos = new Pedido[100];
    private static int quantidadePedidos = 0;

    public static void menu() {

        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarPedido();
                    break;

                case 2:
                    listarPedidos();
                    break;

                case 3:
                    calcularFrete();
                    break;

                case 4:
                    imprimirResumo();
                    break;

                case 5:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 5);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n===== TRANSPORTADORA =====");
        System.out.println("1 - Cadastrar pedido");
        System.out.println("2 - Listar pedidos");
        System.out.println("3 - Calcular frete");
        System.out.println("4 - Imprimir resumo");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarPedido() {

        if (quantidadePedidos >= pedidos.length) {
            System.out.println("Limite de pedidos atingido!");
            return;
        }

        System.out.println("\n===== NOVO PEDIDO =====");

        System.out.print("Destinatário: ");
        String destinatario = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Distância (km): ");
        int distancia = scanner.nextInt();

        System.out.print("Peso (kg): ");
        double peso = scanner.nextDouble();

        TipoEntrega tipo = escolherTipoEntrega();

        /*
         * Aqui você precisaria criar/receber os produtos
         * do pedido.
         *
         * Por enquanto:
         */
        Produto[] produtos = new Produto[0];

        pedidos[quantidadePedidos] = new Pedido(
                produtos,
                destinatario,
                endereco,
                distancia,
                peso,
                tipo
        );

        quantidadePedidos++;

        System.out.println("Pedido cadastrado com sucesso!");
    }

    private static TipoEntrega escolherTipoEntrega() {

        System.out.println("\nTipo de entrega:");
        System.out.println("1 - Moto");
        System.out.println("2 - Carro");
        System.out.println("3 - Retirada");
        System.out.print("Escolha: ");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                return TipoEntrega.MOTO;

            case 2:
                return TipoEntrega.CARRO;

            case 3:
                return TipoEntrega.RETIRADA;

            default:
                throw new IllegalArgumentException(
                        "Tipo de entrega inválido!"
                );
        }
    }

    private static void listarPedidos() {

        if (quantidadePedidos == 0) {
            System.out.println("Nenhum pedido cadastrado.");
            return;
        }

        System.out.println("\n===== PEDIDOS =====");

        for (int i = 0; i < quantidadePedidos; i++) {
            System.out.println(
                    "Pedido " + (i + 1)
                            + " - "
                            + pedidos[i]
            );
        }
    }

    private static void calcularFrete() {

        if (quantidadePedidos == 0) {
            System.out.println("Nenhum pedido cadastrado.");
            return;
        }

        int numero = escolherPedido();

        Pedido pedido = pedidos[numero];

        System.out.printf(
                "Frete: R$ %.2f%n",
                pedido.calcularFrete()
        );
    }

    private static void imprimirResumo() {

        if (quantidadePedidos == 0) {
            System.out.println("Nenhum pedido cadastrado.");
            return;
        }

        int numero = escolherPedido();

        pedidos[numero].imprimirResumo();
    }

    private static int escolherPedido() {

        System.out.print("Número do pedido: ");
        int numero = scanner.nextInt();

        if (numero < 1 || numero > quantidadePedidos) {
            throw new IllegalArgumentException(
                    "Pedido inválido!"
            );
        }

        return numero - 1;
    }
}

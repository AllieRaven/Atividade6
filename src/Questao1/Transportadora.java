package Questao1;

import Questao1.Entregas.TipoEntrega;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Transportadora {

    private List<Pedido> pedidos;
    private Scanner scanner;

    public Transportadora() {
        pedidos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void menu() {

        int opcao;

        do {
            System.out.println("\n===== TRANSPORTADORA =====");
            System.out.println("1 - Cadastrar pedido");
            System.out.println("2 - Listar pedidos");
            System.out.println("3 - Calcular frete");
            System.out.println("4 - Imprimir resumo");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

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

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void cadastrarPedido() {

        System.out.println("\n===== CADASTRAR PEDIDO =====");

        System.out.print("Destinatário: ");
        String destinatario = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Distância em km: ");
        int distancia = scanner.nextInt();

        System.out.print("Peso em kg: ");
        double peso = scanner.nextDouble();

        scanner.nextLine();

        List<Produto> produtos = cadastrarProdutos();

        TipoEntrega tipoEntrega = escolherTipoEntrega();

        Pedido pedido = new Pedido(
                produtos,
                destinatario,
                endereco,
                distancia,
                peso,
                tipoEntrega
        );

        pedidos.add(pedido);

        System.out.println("Pedido cadastrado com sucesso!");
    }

    private List<Produto> cadastrarProdutos() {

        List<Produto> produtos = new ArrayList<>();

        String continuar;

        do {
            System.out.println("\n--- Novo Produto ---");

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Preço: ");
            double preco = scanner.nextDouble();

            scanner.nextLine();

            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();

            scanner.nextLine();

            Produto produto = new Produto(nome, preco, quantidade);

            produtos.add(produto);

            System.out.print("Adicionar outro produto? (s/n): ");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        return produtos;
    }

    private TipoEntrega escolherTipoEntrega() {

        System.out.println("\n===== TIPO DE ENTREGA =====");
        System.out.println("1 - Moto");
        System.out.println("2 - Carro");
        System.out.println("3 - Retirada");
        System.out.print("Escolha: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

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

    private void listarPedidos() {

        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado.");
            return;
        }

        System.out.println("\n===== PEDIDOS =====");

        for (int i = 0; i < pedidos.size(); i++) {
            System.out.println(
                    (i + 1) + " - Pedido para: "
                            + pedidos.get(i).getDestinatario()
            );
        }
    }

    private void calcularFrete() {

        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado.");
            return;
        }

        Pedido pedido = selecionarPedido();

        System.out.printf(
                "Frete: R$ %.2f%n",
                pedido.calcularFrete()
        );
    }

    private void imprimirResumo() {

        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado.");
            return;
        }

        Pedido pedido = selecionarPedido();

        pedido.imprimirResumo();
    }

    private Pedido selecionarPedido() {

        listarPedidos();

        System.out.print("Escolha o pedido: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        if (numero < 1 || numero > pedidos.size()) {
            throw new IllegalArgumentException(
                    "Pedido inválido!"
            );
        }

        return pedidos.get(numero - 1);
    }
}

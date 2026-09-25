import Questao4.Empresa;
import atividade05.SistemaMonitoramento;
import atividade06.Operacao;
import atividade07.Relatorio;

public class Main {
    public static void main(String[] args){

        Empresa empresa = new Empresa();
        empresa.menu();

        SistemaMonitoramento sistema = new SistemaMonitoramento();
        sistema.menu();

        Operacao operacao = new Operacao();
        operacao.menu();

        Relatorio relatorio = new Relatorio("Relatório", "Conteúdo do relatório");
        relatorio.menu();
    }
}
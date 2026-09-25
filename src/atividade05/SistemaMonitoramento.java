package atividade05;

public class SistemaMonitoramento {
    private Notificador notificador;

    public SistemaMonitoramento() {
    }
    public SistemaMonitoramento(Notificador notificador) {
        this.notificador = notificador;
    }
    public void enviarAlerta(Alerta alerta) {
        notificador.enviar(alerta);
    }
    public void menu() {

        Alerta alerta = new Alerta("Temperatura muitcho altíssima!");

        SistemaMonitoramento sistemaOnebb = new SistemaMonitoramento(new NotificadorEmail());
        SistemaMonitoramento sistemaTwobb = new SistemaMonitoramento(new NotificadorSMS());

        sistemaOnebb.enviarAlerta(alerta);
        sistemaTwobb.enviarAlerta(alerta);
    }
}
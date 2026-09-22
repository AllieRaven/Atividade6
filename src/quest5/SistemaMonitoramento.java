package quest5;

public class SistemaMonitoramento {
    private Notificador notificador;

    public SistemaMonitoramento(Notificador notificador){
        this.notificador = notificador;
    }

    public Notificador getNotificador() {
        return notificador;
    }

    public void setNotificador(Notificador notificador) {
        this.notificador = notificador;
    }

    public void enviarNotificacao(String mensagem){
        Alerta alerta = new Alerta(mensagem);
        notificador.enviarNotificacao(alerta);
    }
}

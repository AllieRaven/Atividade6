package quest5;

public class notificadorSMS implements Notificador{
    @Override
    public void enviarNotificacao(Alerta alerta) {
        System.out.println("Alerta por SMS:" + alerta.getMensagem());
    }
}

package quest5;

public class notificadorEmail implements Notificador{
    @Override
    public void enviarNotificacao(Alerta alerta) {
        System.out.println("Alerta por e-mail,:" + alerta.getMensagem());
    }
}

package quest5;

public class notificadorCentral implements Notificador{
    @Override
    public void enviarNotificacao(Alerta alerta) {
        System.out.println("Alerta pela central interna da aplicação:" + alerta.getMensagem());
    }
}

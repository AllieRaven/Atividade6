package atividade05;

public class NotificadorSMS implements Notificador {

    @Override
    public void enviar(Alerta alerta) {
        System.out.println("Enviando por SMS, bebê: " + alerta.getMensagem());
    }
}
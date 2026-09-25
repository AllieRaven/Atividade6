package atividade05;

public class NotificadorEmail implements Notificador {
    @Override

    public void enviar(Alerta alerta) {
        System.out.println("Enviando por email, bebezinho: " + alerta.getMensagem());
    }
}
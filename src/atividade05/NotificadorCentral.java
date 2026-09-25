package atividade05;

public class NotificadorCentral implements Notificador {

    @Override
    public void enviar(Alerta alerta) {
        System.out.println("Enviando para a central, bebezão: " + alerta.getMensagem());
    }
}
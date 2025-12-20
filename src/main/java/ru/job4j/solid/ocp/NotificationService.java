package ru.job4j.solid.ocp;

public class NotificationService {

    /**
     * Необходимо отправить уведомление через email
     * При необходимости добавления нового типа уведомления
     * нужно будет изменить метод, что будет являться нарушением
     * принципа открытости закрытости
     * @param message
     */
    public void sendMessage(String message) {
        System.out.println("sending email: " + message);
    }
}

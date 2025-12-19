package ru.job4j.solid.srp;

public class Message {

    private String text;
    private String author;
    private String type;

    public Message() {
    }

    public Message(String text, String author, String type) {
        this.text = text;
        this.author = author;
        this.type = type;
    }

    void createMessage(String author, String text) {
        this.author = author;
        this.text = text;
    }

    /**
     * Нарушения принципа SRP, так как в описании класса Message содержится
     * метод сохрания message в БД.
     */
    void saveMessageToBD() {
        System.out.println("Message saved");
    }
}

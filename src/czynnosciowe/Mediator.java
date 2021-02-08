package czynnosciowe;

interface ChatMediator {
    void sendMessage(User user, String message);
}

public class Mediator {
    public static void main(String[] args) {
        var mediator = new ChatMediatorClass();
        var pawel = new User("Pawel", mediator);
        var tomek = new User("Tomek", mediator);
        pawel.send("czesc Tomek");
        tomek.send("czesc Pawel");
    }
}

class ChatMediatorClass implements ChatMediator {

    @Override
    public void sendMessage(User user, String message) {
        String sender = user.getName();
        System.out.println("Nadawca: " + sender + "wiadomość: " + message);
    }
}

class User {
    private final String name;
    private final ChatMediator chatMediator;

    public User(String name, ChatMediator chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
    }

    public String getName() {
        return this.name;
    }

    public void send(String message) {
        this.chatMediator.sendMessage(this, message);
    }
}
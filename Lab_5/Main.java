package Lab_5;

public class Main {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        remote.setCommand(Client.getCommand(1));
        remote.pressButton();
        remote.pressButton();
        remote.setCommand(Client.getCommand(2));
        remote.pressButton();
        remote.pressButton();
    }
}

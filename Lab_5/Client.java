package Lab_5;

public class Client {
    public static Command getCommand(int selector) {
        switch (selector) {
            case 1:
                return new LightSwitchCommand( new ChristmasLights());
            case 2:
                return new LightSwitchCommand( new LivingRoomLight());
            default:
                return null;
        }
    }
}

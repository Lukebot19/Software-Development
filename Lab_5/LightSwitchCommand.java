package Lab_5;

public class LightSwitchCommand implements Command {
    Light light;

    public LightSwitchCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.action();
    }

}
package Lab_5;

public class LivingRoomLight implements Light {
    boolean on = false;

    public void action() {
        if (on) {
            on = false;
            System.out.println("The living room is darker.");
            return;
        }
        on = true;
        System.out.println("The living room is lit up.");
    }
}

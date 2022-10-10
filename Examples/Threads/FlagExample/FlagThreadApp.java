package Examples.Threads.FlagExample;

public class FlagThreadApp {
    public static void main(String args[]) {
        FlagExample a = new FlagExample();
        FlagExample b = new FlagExample();
        a.start();
        b.start();
        System.out.println("Main thread is still running");
        /* note: below we are using the static (class level) sleep method 
        * as we do not have an instance to refer to, to cause the main thread 
        * to sleep, instead Thread.sleep() causes the currently executing
        * thread to sleep which here is the main method as we want
        */
        try {
            Thread.sleep(1000); // sleep for 1000 milliseconds
        } catch (InterruptedException e) {
            // as before, we are nt going to respond to an interruption
        }
        a.stopThread();
        b.stopThread();
    }
}
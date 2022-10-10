package Examples.Threads.InterruptionExample;
public class InterruptionThreadApp {
    
    /** 
     * @param args[]
     */
    public static void main(String args[]) {
        Thread a = new Thread (new InterruptionExample ());
        Thread b = new Thread (new InterruptionExample ());
        a.start();
        b.start();
        System.out.println("Main thread is still running");

        try {
            Thread.sleep (1000); // Sleep for 1000 milliseconds
        } catch (InterruptedException e) {
            // as before, we are not going to respond to an interruption
        }
        a.interrupt();
        b.interrupt();
    }
}

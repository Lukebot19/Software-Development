package Examples.Threads.InterruptionExample;
public class InterruptionExample implements Runnable {
   
    public InterruptionExample() {

    }
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            /* Cannot use this.isInterrupted() here, as `this` is not an istance of the Thread class, it is an
             * implementation of the Runnable interface and therefore has not inherited the instance level `is 
             * Interupted()` method
             */
            System.out.println(Thread.currentThread().getName() + " : dum diddly dum....");
            try {
                Thread.sleep(10); /* Using the class method as `this` is not a Thread */
                /* Also, forgetting the thread name, need to query the Thread class */
                System.out.println(Thread.currentThread().getName() + " : finished sleeping");
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

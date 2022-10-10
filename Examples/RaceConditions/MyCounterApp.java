package Examples.RaceConditions;

public class MyCounterApp {
    
    /** 
     * @param args[]
     */
    public static void main(String args[]) {
        final MyCounter a = new MyCounter();
        System.out.println("Current thread is: " + Thread.currentThread().getName());
        // thread inner class, will call addTwo on the MyCounter instance
        // 1000 times
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i=1;i<=500;i++)
                a.addTwo();
                System.out.println("Value on thread 1 exit: " + a.countValue());
            }
        });
        // thread inner class, will call subtractTwo on the MyCounter instance 1000 times
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i=1;i<=500;i++){
                    a.subtractTwo();
                    System.out.println("Value on thread 2 exit: "+a.countValue());
                }
            }
        });
        t1.start();
        t2.start();
    }
}

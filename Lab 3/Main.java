import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Object of a class that has both produce() and consume() methods
        final PC pc = new PC();
        // Create producer thread
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // Create consumer thread
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // Start both threads
        t1.start();
        t2.start();
        // t1 finishes befre t2
        t1.join();
        t2.join();
    }

    // This class has a list, producer (adds items to list) and consumer (removes items)
    public static class PC {
        // Create a list shared by producer and consumer
        // Size of list is 2
        // LinkedList<Integer> - it's Java generics. You will learn Java generics in Week 9. For this exercise, you can go to 
        // https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html to check useful methoods of LinkedList.
        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 2;
        static Random rnd = new Random();
        // Function called by producer thread
        public synchronized void produce() throws InterruptedException {
            // TODO: Add your code here
            while (true) {
                if (list.size() == capacity) {
                    System.out.println("Producer is waiting");
                    wait();
                } else {
                    Integer myNum = rnd.nextInt(10);
                    list.add(myNum);
                    System.out.println("Producer added " + myNum + " to the list.");
                    System.out.println(list);
                    notify();
                }
            }
        }

        // Function callled by consumer thread
        public synchronized void consume() throws InterruptedException {
            // TODO: Add your code here
            while (true) {
                if (list.size() == 0) {
                    System.out.println("Consumer is waiting");
                    wait();
                } else {
                    Integer data = list.remove();
                    //do Stuff
                    System.out.println("Consumer removed " + data + " from the list.");
                    notify();
                }
            }
        }
    }
}

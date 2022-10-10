package Examples.RaceConditions;

public class MyCounter {
  
    private int count = 0;

    public synchronized void addTwo() {
        this.count += 2; // retrieve count, change count, store count
    }
    
    public synchronized void subtractTwo() {
        this.count -= 2; // retrieve count, change count, store count
    }
    
    /** 
     * @return int
     */
    public synchronized int countValue () {
        return this.count;
    }

}
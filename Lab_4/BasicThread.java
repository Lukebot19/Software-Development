package Lab_4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public abstract class BasicThread extends Thread
{
    private BufferedWriter out;
    
    protected BasicThread(String filename) throws IOException {
        this.out = new BufferedWriter( new FileWriter( filename ) );
    }
    
    public void run() {
        for(;;) {
            //System.out.println("Thread "+ Thread.currentThread().getName() + " is waiting");
            try { 
                Thread.sleep(1000);
            } catch(InterruptedException e) {}
        }
    }
    
    protected void writeToFile(String message) throws IOException {
        this.out.write(message);
        this.out.newLine();
        this.out.flush();
    }
}

package Lab_4.Multiple;

import java.io.IOException;

import Lab_4.BasicThread;

public class MultipleThread extends BasicThread implements MultipleWriteEventListener
{
    
    public MultipleThread() throws IOException {
        super("MultipleThread_output.txt" );
    }
     
    public void eventOccured(MultipleWriteEvent evt) throws IOException {
        this.writeToFile(evt.getMessage());
    }
}
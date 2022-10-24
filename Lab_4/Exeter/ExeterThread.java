package Lab_4.Exeter;

import java.io.IOException;

import Lab_4.BasicThread;

public class ExeterThread extends BasicThread implements ExeterWriteEventListener
{
    
    public ExeterThread() throws IOException {
        super("ExeterThread_output.txt" );
    }
     
    public void eventOccured(ExeterWriteEvent evt) throws IOException {
        this.writeToFile(evt.getMessage());
    }
}

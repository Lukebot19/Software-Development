package Lab_4.University;

import java.io.IOException;

import Lab_4.BasicThread;

public class UniversityThread extends BasicThread implements UniversityWriteEventListener
{
    
    public UniversityThread() throws IOException {
        super("UniversityThread_output.txt" );
    }
     
    public void eventOccured(UniversityWriteEvent evt) throws IOException {
        this.writeToFile(evt.getMessage());
    }
}

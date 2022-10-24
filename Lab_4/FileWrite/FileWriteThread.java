package Lab_4.FileWrite;

import java.io.IOException;

import Lab_4.BasicThread;

public class FileWriteThread extends BasicThread implements FileWriteEventListener
{
    
    public FileWriteThread() throws IOException {
        super("FileWriteThread_output.txt" );
    }
     
    public void eventOccured(FileWriteEvent evt) throws IOException {
        this.writeToFile(evt.getMessage());
    }
}

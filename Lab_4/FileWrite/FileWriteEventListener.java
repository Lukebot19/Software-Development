package Lab_4.FileWrite;

public interface FileWriteEventListener extends java.util.EventListener
{
    public void eventOccured(FileWriteEvent evt) throws java.io.IOException;
}

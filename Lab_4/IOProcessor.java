package Lab_4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Console;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import Lab_4.Exeter.ExeterThread;
import Lab_4.Exeter.ExeterWriteEvent;
import Lab_4.Exeter.ExeterWriteEventListener;
import Lab_4.FileWrite.FileWriteEvent;
import Lab_4.FileWrite.FileWriteEventListener;
import Lab_4.FileWrite.FileWriteThread;
import Lab_4.Multiple.MultipleThread;
import Lab_4.Multiple.MultipleWriteEvent;
import Lab_4.Multiple.MultipleWriteEventListener;
import Lab_4.University.UniversityThread;
import Lab_4.University.UniversityWriteEvent;
import Lab_4.University.UniversityWriteEventListener;

public class IOProcessor extends BasicThread
{
    private ArrayList<FileWriteEventListener> fileListeners = new ArrayList<>();
    private ArrayList<UniversityWriteEventListener> universityListeners = new ArrayList<>();
    private ArrayList<ExeterWriteEventListener> exeterListeners = new ArrayList<>();
    private Console console = System.console();

    private IOProcessor() throws java.io.IOException {
        super("user_input.txt");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // construct the threads
        IOProcessor ioProcessor = new IOProcessor();
        FileWriteThread fileThread = new FileWriteThread();
        UniversityThread universityThread = new UniversityThread();
        ExeterThread exeterThread = new ExeterThread();
        MultipleThread multipleThread = new MultipleThread();

        // register listeners with the source
        ioProcessor.addFileWriteEventListener(fileThread);
        // ioProcessor.addFileWriteEventListener(multipleThread);
        ioProcessor.addUniversityWriteEventListener(universityThread);
        // ioProcessor.addUniversityWriteEventListener(multipleThread);
        ioProcessor.addExeterWriteEventListener(exeterThread);
        // ioProcessor.addExeterWriteEventListener(multipleThread);

        System.out.println("starting threads");
        // start listening threads
        fileThread.start();
        universityThread.start();
        exeterThread.start();
        multipleThread.start();
        Thread.sleep(1000);
        System.out.println("starting processor: please enter text, EXIT to exit");
        // start ioProcessor once all other threads are ready
        ioProcessor.start();

    }

    @Override
    public void run() {
        for (;;) {
            try {
                String text = console.readLine();
                Calendar cal = Calendar.getInstance();
                cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String time = sdf.format(cal.getTime());
                if (text.equals("EXIT")) {
                    System.exit(0);
                } else {
                    this.writeToFile(text);
                    FileWriteEvent fileEvent = new FileWriteEvent(this, time + " file written to");  
                    this.notifyFileWriteEventListeners(fileEvent);
                    if ((text.toLowerCase().contains("university")) || (text.toLowerCase().contains("universities"))) {
                        UniversityWriteEvent uniEvent = new UniversityWriteEvent(this, time + " university/ies in string: " + text);  
                        this.notifyUniversityWriteEventListeners(uniEvent); 
                    }

                    if ((text.toLowerCase().contains("exeter")) || (text.toLowerCase().contains("south-west"))) {
                        ExeterWriteEvent exeterEvent = new ExeterWriteEvent(this, time + " exeter/south-west in string: " + text);  
                        this.notifyExeterWriteEventListeners(exeterEvent); 
                    }
                }   
            } catch (IOException e) {

            }
        }
    }

    private void notifyFileWriteEventListeners(FileWriteEvent evt) throws IOException{
        for (FileWriteEventListener l : fileListeners)
            l.eventOccured(evt);
    }

    private void notifyUniversityWriteEventListeners(UniversityWriteEvent evt) throws IOException{
        for (UniversityWriteEventListener l : universityListeners)
            l.eventOccured(evt);
    }

    private void notifyExeterWriteEventListeners(ExeterWriteEvent evt) throws IOException{
        for (ExeterWriteEventListener l : exeterListeners)
            l.eventOccured(evt);
    }

    public void addFileWriteEventListener(FileWriteEventListener listener) {
        this.fileListeners.add(listener);
    }

    public void addUniversityWriteEventListener(UniversityWriteEventListener listener) {
        this.universityListeners.add(listener);
    }

    public void addExeterWriteEventListener(ExeterWriteEventListener listener) {
        this.exeterListeners.add(listener);
    }
    

    public void removeFileWriteEventListener(FileWriteEventListener listener) {
        this.fileListeners.remove(listener);
    }

    public void removeUniversityWriteEventListener(UniversityWriteEventListener listener) {
        this.universityListeners.remove(listener);
    }

    public void removeExeterWriteEventListener(ExeterWriteEventListener listener) {
        this.exeterListeners.remove(listener);
    }

}

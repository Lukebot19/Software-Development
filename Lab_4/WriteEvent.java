package Lab_4;

public class WriteEvent extends java.util.EventObject
{
   String message;
   public WriteEvent(Object src, String message) {
       super(src);
       this.message = message;
   }
   
   public String getMessage() {
       return message;
   }
}
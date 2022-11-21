package Patterns;

public class Patterns {
    
    public static void main(String[] args) {
        // Test code.
        Conference cec = new DinnerDecorator(new ExcursionDecorator(new CEC()));
        double gbp = cec.getCost();
        System.out.println(cec.getDescription() + ": GBP" + gbp);

        // String cecTitle = "My paper title";
        // Publication cecPaper = cec.createPaper(cecTitle, true);
        // System.out.println("Created paper:" + cecTitle + ", maximum length is " + cec.Paper.getPages() + " pages\n");
    }

}

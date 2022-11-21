package Patterns;

public interface Conference {

    Publication createPaper(String title, boolean accept);

    double getCost();

    String getDescription();
    
}

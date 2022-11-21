package Patterns;

public class CEC implements Conference {
    
    @Override
    public double getCost() {
        return 300;
    }

    @Override
    public String getDescription() {
        return "CEC";
    }

    @Override
    public Publication createPaper(String title, boolean accept) {
        Publication publication = new CECPublication(title);
        publication.submitPaper();
        publication.reviewPaper();
        publication.acceptPaper(accept);
        return publication;
    }
}

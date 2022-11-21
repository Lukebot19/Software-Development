package Patterns;

public class DinnerDecorator extends ConferenceDecorator {
    
    public DinnerDecorator(Conference conference) {
        super(conference);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Conference Dinner";
    }

    @Override
    public double getCost() {
        return super.getCost() + 40;
    }

    @Override
    public Publication createPaper(String title, boolean accept) {
        return super.createPaper(title, accept);
    }
}

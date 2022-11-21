package Patterns;

public class ExcursionDecorator extends ConferenceDecorator {
    
    public ExcursionDecorator(Conference conference) {
        super(conference);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Excursion";
    }

    @Override
    public double getCost() {
        return super.getCost() + 75;
    }

    @Override
    public Publication createPaper(String title, boolean accept) {
        return super.createPaper(title, accept);
    }

}

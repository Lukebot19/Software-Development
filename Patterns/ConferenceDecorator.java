package Patterns;

public abstract class ConferenceDecorator implements Conference {

    private Conference conference;
    public ConferenceDecorator(Conference conference) {
        this.conference = conference;
    }

    @Override
    public String getDescription() {
        return this.conference.getDescription();
    }

    @Override
    public double getCost() {
        return this.conference.getCost();
    }
    
    @Override
    public Publication createPaper(String title, boolean accept) {
        return this.conference.createPaper(title, accept);
    }

}

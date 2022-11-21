package Patterns;

public class ICEMPublication extends Publication {

    @Override
    public int getPages() {
        return 2;
    }

    public ICEMPublication(String title) {
        this.title = title;
    }
    
}

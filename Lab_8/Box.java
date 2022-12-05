package Lab_8;

public class Box {
    private Integer width;
    private Integer depth;
    private Integer height;

    public Box(Integer width, Integer depth, Integer height) {
        this.width = width;
        this.depth = depth;
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getDepth() {
        return depth;
    }

    public Integer getHeight() {
        return height;
    }

    public String compareTo(Box box2) {

        if (this.width < box2.getWidth()) {
            return "box1 is smaller than box2";
        } else if (this.height < box2.getHeight()) {
            return "box1 is smaller than box2";
        } else if (this.depth < box2.getDepth()) {
            return "box1 is smaller than box2";
        } 

        return "Both boxes are the same";
    }
}

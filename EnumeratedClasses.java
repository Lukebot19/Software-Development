enum UggRockSize {
    BIGUN(5),
    QUIET_BIGUN(3),
    NOT_SO_BIGUN(1);

    int multiplerValue;
    UggRockSize(int multiplerValue) {
        this.multiplerValue = multiplerValue;
    }
    
    int getMultiplierValue() {
        return multiplerValue;
    }

}

enum UggRockType {
    SPECKILY(7),
    OUCHY_BLACK(20),
    FLOATY(2),
    HOT_HOT_HOT(15);

    int multiplerValue;
    UggRockType(int multiplerValue) {
        this.multiplerValue = multiplerValue;
    }
    
    int getMultiplierValue() {
        return multiplerValue;
    }
    
}

class UggRock {
    private UggRockType UggRockType;
    private UggRockSize UggRockSize;


    UggRock(UggRockType Type, UggRockSize size) {
        this.UggRockType = Type;
        this.UggRockSize = size;
    }

    public UggRockType getRockType() {
        return UggRockType;
    }

    public UggRockSize getRockSize() {
        return UggRockSize;
    }

    @Override
    public String toString() {
        return UggRockType + "," + UggRockSize;
    }

    int rockValue() {
        return UggRockSize.getMultiplierValue() * UggRockType.getMultiplierValue();
    }
}

class EnumeratedClasses {
    public static void main(String[] args) {
        UggRock rock1 = new UggRock(UggRockType.OUCHY_BLACK, UggRockSize.BIGUN);
        System.out.println(rock1);
        System.out.println(rock1.rockValue());
    }
    
}
package UggRock;
import java.util.Random;

public class Ugg {
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

    static class UggRock {
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
    static Random rnd = new Random();

    
    /** 
     * @return UggRock
     */
    static UggRock drawRock() {
        double rndSize = rnd.nextDouble();
        double rndType = rnd.nextDouble();
        UggRockSize rockSize;
        UggRockType rockType;

        if (rndType < 0.25) {
            rockType = UggRockType.SPECKILY;
        } else if (rndType < 0.5) {
            rockType = UggRockType.OUCHY_BLACK;
        } else if (rndType < 0.75) {
            rockType = UggRockType.FLOATY;
        } else {
            rockType = UggRockType.HOT_HOT_HOT;
        }

        if (rndSize < 6.0/9.0) {
            rockSize = UggRockSize.NOT_SO_BIGUN;
        } else if (rndSize < 8.0/9.0) {
            rockSize = UggRockSize.QUIET_BIGUN;
        } else {
            rockSize = UggRockSize.BIGUN;
        }

        return new UggRock(rockType, rockSize);
    }
    public static void main(String[] args) {
       
        Thread t1 = new Thread (new Runnable() {
            public void run() {
                for (int i=0;i<=20;i++) {
                    UggRock myRock = drawRock();
                    System.out.println(Thread.currentThread().getName() + ", Rock Size: " + myRock.getRockSize() + " , Rock Type: " + myRock.getRockType());
                }
            }
        }, "Thread 1");
        Thread t2 = new Thread (new Runnable() {
            public void run() {
                for (int i=0;i<=20;i++) {
                    UggRock myRock = drawRock();
                    System.out.println(Thread.currentThread().getName() + ", Rock Size: " + myRock.getRockSize() + " , Rock Type: " + myRock.getRockType());
                }
            }
        }, "Thread 2");
        t1.start();
        t2.start();
    }
}


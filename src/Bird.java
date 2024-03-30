import java.awt.*;


public class Bird {

    private int birdX;
    private int birdY;
    private static final int BIRD_WIDTH = 34;
    private static final int BIRD_HEIGHT = 24;
    Image img;

    Bird(Image img) {
        this.birdX = Screen.getBOARD_WIDTH()/8;
        this.birdY = Screen.getBOARD_HEIGHT()/2;
        this.img = img;

    }

    public int getBirdX() {
        return birdX;
    }

    public int getBirdY() {
        return birdY;
    }

    public static int getBIRD_WIDTH() {
        return BIRD_WIDTH;
    }

    public static int getBIRD_HEIGHT() {
        return BIRD_HEIGHT;
    }

    public Image getImg() {
        return img;
    }
}

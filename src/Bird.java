import java.awt.*;


public class Bird {

    private int birdX;
    private int birdY;
    private static final int BIRD_STARTING_X = Screen.getBOARD_WIDTH()/2;
    private static final int BIRD_WIDTH = 34;
    private static final int BIRD_HEIGHT = 24;
    private Image img;

    Bird(Image img) {
        this.birdX = Screen.getBOARD_WIDTH()/8;
        this.birdY = Screen.getBOARD_HEIGHT()/2;
        this.img = img;

    }

    public static int getBIRD_STARTING_X() {
        return BIRD_STARTING_X;
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

    public void setBirdX(int birdX) {
        this.birdX = birdX;
    }

    public void setBirdY(int birdY) {
        this.birdY = birdY;
    }

    public void increaseBirdX(int velocity) {
        this.birdX += velocity;
    }

    public void increaseBirdY(int birdY) {
        this.birdY += birdY;
    }

    public Image getImg() {
        return img;
    }
}

import java.awt.*;
import java.util.List;


public class Pipe {


    private int pipeX;
    private int pipeY;
    private static final int PIPE_WIDTH = 64;
    private static final int PIPE_HEIGHT = 512;
    private Image img;
    private boolean passed = false;


    Pipe(Image img) {
        this.pipeX = Screen.getBOARD_WIDTH();
        this.pipeY = 0;
        this.img = img;
    }

    public void setPipeX(int pipeX) {
        this.pipeX = pipeX;
    }

    public void setPipeY(int pipeY) {
        this.pipeY = pipeY;
    }

    public int getPipeX() {
        return pipeX;
    }

    public int getPipeY() {
        return pipeY;
    }

    public static int getPIPE_WIDTH() {
        return PIPE_WIDTH;
    }

    public static int getPIPE_HEIGHT() {
        return PIPE_HEIGHT;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public Image getImg() {
        return img;
    }

    public void increaseX(int velocityX) {
        this.pipeX += velocityX;

    }
}

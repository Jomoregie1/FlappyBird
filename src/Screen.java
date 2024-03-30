import javax.swing.*;

public class Screen {

    // This sets the board height and width. Chosen due to the size of the background image.
    private static final int BOARD_WIDTH = 360;
    private static final int BOARD_HEIGHT = 640;
    private final JFrame frame;

//    This is the Jpanel component that has been defined in the FlappyBird class
    FlappyBird flappyBird;

    Screen(String title) {
        this.frame = new JFrame(title);
        this.flappyBird = new FlappyBird();

    }

    public void setComponent() {
//        adds component to the container.
        this.frame.add(this.flappyBird);
//       sizes frame so all components are at or above their preferred sizes. so to size the frame not including the title bar.
        this.frame.pack();
        // Makes the game window visible.
        this.frame.setVisible(true);
    }

    public void setScreen() {
    //        Places window at the centre of the screen.
        this.frame.setLocationRelativeTo(null);
    //        sets weather the frame is resizable by the user.
        this.frame.setResizable(false);
    //        allows you to exit using the system exit
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //        Sets the size of the window
        this.frame.setSize(BOARD_WIDTH,BOARD_HEIGHT);

    }

    public static int getBOARD_WIDTH() {
        return BOARD_WIDTH;
    }

    public static int getBOARD_HEIGHT() {
        return BOARD_HEIGHT;
    }
}

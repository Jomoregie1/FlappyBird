import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class FlappyBird extends JPanel{

//    This adds in our images stored in the source files.
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPipeImg;

    FlappyBird() {
//        sets the preferredSizes dimensions.
        setPreferredSize(new Dimension(Screen.getBOARD_WIDTH(),Screen.getBOARD_HEIGHT()));
//        sets the background color to blue due to the background used.
        setBackground(Color.blue);
    }




}

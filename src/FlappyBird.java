import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;
import javax.swing.*;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {

//    This adds in our images stored in the source files .
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPipeImg;
    Bird bird;

//    Game Logic
    Timer gameLoop;
    int velocityY = -9;
    int gravity = 1;



    FlappyBird() {
//        sets the preferredSizes dimensions.
        setPreferredSize(new Dimension(Screen.getBOARD_WIDTH(),Screen.getBOARD_HEIGHT()));

//        This initialises the fields, retrieving the images stored in the src file.
        backgroundImg = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/flappybirdbg.png"))).getImage();
        birdImg = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/flappybird.png"))).getImage();
        topPipeImg = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/toppipe.png"))).getImage();
        bottomPipeImg = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/bottompipe.png"))).getImage();
        this.bird = new Bird(birdImg);

//      this creates a timer for our game loop, looping 60 times per second.
        this.gameLoop = new Timer(1000/60, this);

//      Starts the gameloop timer.
        this.gameLoop.start();

    }

    public void paintComponent(Graphics g) {
//        Used to call the superclasses method paintComponent, which is the component to paint.
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
//       Draws the given image inside the space provided.
        g.drawImage(backgroundImg, 0,0, Screen.getBOARD_WIDTH(), Screen.getBOARD_HEIGHT(), null);
        g.drawImage(this.bird.getImg(), this.bird.getBirdX(), this.bird.getBirdY(), Bird.getBIRD_WIDTH(), Bird.getBIRD_HEIGHT(), null);
    }


    public void move() {
//        updating birds x and y's position
        velocityY += gravity;
        this.bird.increaseBirdY(this.velocityY);
        this.bird.setBirdY(Math.max(this.bird.getBirdY(),0));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
//        repaints the given component.
        move();
        repaint();
    }

    /**
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {

    }

    /**
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
}

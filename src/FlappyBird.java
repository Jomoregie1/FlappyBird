import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {

//    This adds in our images stored in the source files .
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPipeImg;
    Bird bird;
    Pipe pipe;

//    Game Logic
    Timer gameLoop;
    Timer placePipesTimer;


    int velocityY = 0;
    int velocityX = -4; // simulates pipes moving to the left giving the illusion that the bird is moving to the right.
    int gravity = 1;

    ArrayList<Pipe> pipes;  // used to keep track of the pipes in our list as there are many pipes in the game.


    FlappyBird() {
//        sets the preferredSizes dimensions.
        setPreferredSize(new Dimension(Screen.getBOARD_WIDTH(),Screen.getBOARD_HEIGHT()));

//        Ensures, this flappy bird class takes in the key events.
        setFocusable(true);

//      recieves key events from the given component which is the current FlappyBird class that inherits from Jpanel.
        addKeyListener(this);

//        This initialises the fields, retrieving the images stored in the src file.
        backgroundImg = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/flappybirdbg.png"))).getImage();
        birdImg = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/flappybird.png"))).getImage();
        topPipeImg = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/toppipe.png"))).getImage();
        bottomPipeImg = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/bottompipe.png"))).getImage();
        this.bird = new Bird(birdImg);
        this.pipes = new ArrayList<Pipe>();

//      this creates a timer for our game loop, looping 60 times per second.
        this.gameLoop = new Timer(1000/60, this);
        this.placePipesTimer = new Timer(1500, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                placePipes();
            }
        });

        placePipesTimer.start();

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

        for (Pipe pipe : pipes) {
            g.drawImage(pipe.getImg(), pipe.getPipeX(),pipe.getPipeY(),pipe.getPIPE_WIDTH(),pipe.getPIPE_HEIGHT(),null);
        }
    }


    public void move() {
//        updating birds x and y's position
        velocityY += gravity;
        this.bird.increaseBirdY(this.velocityY);
        this.bird.setBirdY(Math.max(this.bird.getBirdY(),0));

        // move pipes
        for (Pipe pipe: pipes ) {
            pipe.increaseX(velocityX);
        }



    }

    public void placePipes() {
        Pipe topPipe = new Pipe(topPipeImg);
        this.pipes.add(topPipe);
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
    public void keyPressed(KeyEvent e) {

        /**
         *  we check the key pressed, if the key pressed is equal to the space bar then we set Velocity y to -9.
         */

        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.velocityY = -9;
        }

    }

    /**
     * @param e the event to be processed - not used in our code.
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * @param e the event to be processed - not used in code.
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
}

//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DON'T CHANGE! vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
// Graphics Libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
public class BasicGameApp implements Runnable, KeyListener {

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;


    //Variable Definition Section
    //You can set their initial values too
    // Like Mario mario = new Mario(); //
    Nemo nemo;
    Dory dory;
    Bruce bruce;
    Image background;


    // Initialize your variables and construct your program objects here.
    public BasicGameApp() { // BasicGameApp constructor
        setUpGraphics();

        //variable and objects
        //create (construct) the objects needed for the game
        nemo = new Nemo(500, 350, 5, 5, 100, 100);
        nemo.name = "Nemo";
        nemo.aliveImage = Toolkit.getDefaultToolkit().getImage("Nemo.png");
        nemo.deadImage = Toolkit.getDefaultToolkit().getImage("dead.png");
        stephon = new StephonCastle(100, 200, 5, 5, 100, 100);
        stephon.name = "Stephon Castle";
        stephon.image = Toolkit.getDefaultToolkit().getImage("stephon castle.png");

        background = Toolkit.getDefaultToolkit().getImage("Basketball_Court.png");


    }
    // end BasicGameApp constructor

    public void moveThings() {
        //call the move() code for each object  -
        cade.move();
        stephon.move();
    }

    public void checkCollisions() {
        System.out.println(cade.hitbox);
        System.out.println(stephon.hitbox);
        if (cade.hitbox.intersects(stephon.hitbox)) {
            System.out.println("Cade hit Stephon");
            cade.isAlive = false;
        } else {
            cade.isAlive = true;
        }
    }

    //Paints things on the screen using bufferStrategy
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        //draw the images
        // Signature: drawImage(Image img, int x, int y, int width, int height, ImageObserver observer)
        g.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
        if (cade.isAlive) {
            g.drawImage(cade.aliveImage, cade.xpos, cade.ypos, cade.width, cade.height, null);
        } else {
            g.drawImage(cade.deadImage, cade.xpos, cade.ypos, cade.width, cade.height, null);
        }
        g.drawImage(stephon.image, stephon.xpos, stephon.ypos, stephon.width, stephon.height, null);


        // Keep the code below at the end of render()
        g.dispose();
        bufferStrategy.show();
    }


    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DON'T CHANGE! vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;
    public BufferStrategy bufferStrategy;

    // PSVM: This is the code that runs first and automatically
    public static void main(String[] args) {
        BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
        new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method
    }

    // main thread
    // this is the code that plays the game after you set things up
    public void run() {
        //for the moment we will loop things forever.
        while (true) {
            moveThings();  //move all the game objects
            checkCollisions();
            render();  // paint the graphics
            pause(10); // sleep for 10 ms
        }
    }

    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    private Image getImage(String filename) {
        return Toolkit.getDefaultToolkit().getImage(filename);
    }

    //Graphics setup method
    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        canvas.addKeyListener(this);
        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //we won't use this
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        int key = e.getKeyCode();

        if (key == 65) {cade.left = true;}//a
        else if (key == 68) {cade.right = true;}//d
        else if (key == 87) {cade.up = true;}//w
        else if (key == 83) {cade.down = true;}//s
    }

    @Override
    public void keyReleased (KeyEvent e){
        int key = e.getKeyCode();
        if (key == 65) {cade.left = false;}//a
        else if (key == 68) {cade.right = false;}//d
        else if (key == 87) {cade.up = false;}//w
        else if (key == 83) {cade.down = false;}//s

    }
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
}

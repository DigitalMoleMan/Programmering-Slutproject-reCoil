import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel {

    JFrame frame;

    public int rectX = 64;

    public int WIDTH = 640;
    public int HEIGHT = 640;

    public Game(){
        //Window setup
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(640, 640);
        this.frame.setResizable(false);
        this.frame.add(this);
        this.frame.setFocusable(true);
        this.frame.setVisible(true);


        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    public void paintComponent(Graphics g) {
        fillRect(0,0, WIDTH, HEIGHT, "#ffffff", g);
        g.setColor(Color.decode("#111111"));
        fillRect(rectX,64,64,64,"#ff0000", g);
        repaint();
    }

    /**
     * @method fillRect
     *
     * @param x Rectangle x position
     * @param y Rectangle y position
     * @param width Rectangle width
     * @param height Rectangle height
     * @param g Graphics component
     */
    public void fillRect(int x, int y, int width, int height, String color, Graphics g){
        g.setColor(Color.decode(color));
        g.fillRect(x,y,width,height);
    }

    /**
     *
     * @param img
     * @param x
     * @param y
     * @param g
     */
    /*
    public void drawImage(BufferedImage img, int x, int y, Graphics g){

    }
    */
}
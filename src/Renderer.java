import javax.swing.*;
import java.awt.*;

public class Renderer extends JPanel {

    JFrame frame;
    public int rectX = 64;
    public int rectY = 64;
    public int WIDTH = 640;
    public int HEIGHT = 640;

    public Graphics gc;


    public Renderer() {
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(640, 640);
        this.frame.setResizable(false);
        this.frame.add(this);
        this.frame.setFocusable(true);
        this.frame.setVisible(true);
    }

    /**
     * Render loop
     * @param g Graphics component
     */
    public void paintComponent(Graphics g) {
        gc = g;
        //fillRect(Main.posX, Main.posY, 64, 64, "#ff0000", gc);
        repaint();
    }

    /**
     * Draws a Rectangle with the specified parameters.
     * @param x      Rectangle x position
     * @param y      Rectangle y position
     * @param width  Rectangle width
     * @param height Rectangle height
     * @param g      Graphics component
     */
    public void fillRect(int x, int y, int width, int height, String color, Graphics g) {
        g.setColor(Color.decode(color));
        g.fillRect(x, y, width, height);
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
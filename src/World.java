import java.io.FileReader;
import java.util.ArrayList;


public class World{

    public ArrayList<Block> layout = new ArrayList<Block>(); //Array that contains all objects in the level, used for collision detection and rendering.


    /**
     * Constructs the level using level.json as a blueprint.
     * @throws Exception
     */
    public World() throws Exception {
            // pass the path to the file as a parameter
            FileReader fr = new FileReader("C:\\code\\skola\\programmering\\reCoil\\level.json");

            for (int i = 0; i < fr.read(); i++) {

                layout.add(new Block(32 * i, 32 * 18, 32 * 1, 32));
                System.out.print((char) i);
            }
/*
        layout.add(new Block(0, 32 * 18, 32 * 20, 32));
        layout.add(new Block(32 * 8, 32 * 15, 32 * 4, 32));
        layout.add(new Block(32 * 8, 32 * 16, 32 * 2, 32 * 2));
        */
    }

    public ArrayList<Block> getLayout(){
        return layout;
    }
}

class Block {
    public int x;
    public int y;
    public int width;
    public int height;

    /**
     * The block class represents a part of the level, this means that its something the player can collide with and it will be rendered as a white rectangle with the defined dimentions.
     * @param x x position
     * @param y y position
     * @param width rectangle width
     * @param height rectangle height
     */
    public Block(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}


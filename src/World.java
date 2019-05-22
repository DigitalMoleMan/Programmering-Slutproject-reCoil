import java.util.ArrayList;


public class World{

    public ArrayList<Block> layout = new ArrayList<Block>(); //Array that contains all objects in the level, used for collision detection and rendering.



    public World(){


        layout.add(new Block(0, 32 * 18, 32 * 20, 32));
        layout.add(new Block(32 * 8, 32 * 15, 32 * 4, 32));
        layout.add(new Block(32 * 8, 32 * 16, 32 * 2, 32 * 2));
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
    public Block(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}


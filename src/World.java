import java.util.ArrayList;

public class World{

    ArrayList<Block> layout = new ArrayList<Block>();
    public World(){


       // Block floor = new Block(0, 600, 640, 40));
        //this.add(floor);
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
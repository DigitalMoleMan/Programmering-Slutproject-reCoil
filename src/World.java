import java.util.ArrayList;

public class World{

    public ArrayList<Block> layout = new ArrayList<Block>();

    public World(){


        layout.add(new Block(0, 32 * 18, 32 * 20, 32));
        layout.add(new Block(0, 0, 32, 32 * 20));
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


import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Main {

    public static ArrayList<Rect> draw = new ArrayList<Rect>();
    public static ArrayList<Block> layout = new ArrayList<Block>();

    public static void main(String[] args) {


        Input input = new Input();
        Player player = new Player();
        World world = new World();
        Renderer renderer = new Renderer();

        layout = world.getLayout();



        //Graphics init
        Rect playerGfx = new Rect(player.getPosX(), player.getPosY(), 32, 32, "#ff0000");
        draw.add(playerGfx);

        for(int i = 0; i<layout.size();i++) {
            Block block = layout.get(i);
            Rect levelGfx = new Rect(block.x, block.y, block.width, block.height, "#ffffff");
            draw.add(levelGfx);
        }

        //Game Loop
        new Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){

                //Logic
                player.readInput(input.getInput());
                player.update();


                //Rendering
                playerGfx.x = player.getPosX();
                playerGfx.y = player.getPosY();
            }
        }, 0, 16);
    }

}


class Rect {
    public int x;
    public int y;
    public int width;
    public int height;
    public String color;

    public Rect(int x, int y, int width,int height, String color){
        this.x = x;
        this.y = (int) Math.round(y);
        this.width = width;
        this.height = height;
        this.color = color;
    }
}




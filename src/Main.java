import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static int playerX;
    public static int playerY;

    public static ArrayList<Rect> draw = new ArrayList<Rect>();

    public static void main(String[] args) {



        Input input = new Input();
        Player player = new Player();
        World world = new World();

        ArrayList<Block> layout = world.layout;
        Renderer renderer = new Renderer();


        Rect playerGfx = new Rect(player.getPosX(), player.getPosY(), 32, 32, "#ff0000");
        draw.add(playerGfx);

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
        }, 0, 1000 / 60);
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
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
}




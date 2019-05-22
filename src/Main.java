import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Main {
    /*
    public static final String DEFAULT_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public static String hostname = "localhost";
    public static String dbName = "reCoil_hs_db";
    public static int port = 3000;
    public static  final String DEFAULT_URL = "jdbc:mysql://" + hostname + ":"+port+"/"+dbName;
    public static final  String DEFAULT_USERNAME = "root";
    private static final String DEFAULT_PASSWORD = "";
    */

    public static ArrayList<Rect> draw = new ArrayList<Rect>(); //draw contains all elements to be rendered
    public static ArrayList<Block> layout = new ArrayList<Block>();

    public static void main(String[] args) throws Exception {


        Input input = new Input();
        Player player = new Player(32, 32);
        World world = new World();
        Renderer renderer = new Renderer();

        layout = world.getLayout(); //gets all blocks in the level from world.

        //Graphics init

        //creates player gfx instance.
        Rect playerGfx = new Rect(player.getPosX(), player.getPosY(), 32, 32, "#ff0000");
        draw.add(playerGfx);


        //creates a gfx for each block in the level.
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

                //update playerGfx position with actual player position.
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

    /**
     *
     * @param x x position to draw the rectangle at
     * @param y y position to draw the rectangle at
     * @param width rectangle width
     * @param height rectangle height
     * @param color string with the hex color code
     */
    public Rect(int x, int y, int width,int height, String color){
        this.x = x;
        this.y = (int) Math.round(y);
        this.width = width;
        this.height = height;
        this.color = color;
    }
}




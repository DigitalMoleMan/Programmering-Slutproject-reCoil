import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static int posX;
    public static int posY;

    public static void main(String[] args) {

        Input input = new Input();
        Game game = new Game();
        Player player = new Player();

        Renderer renderer = new Renderer();

        input.keys();


        new Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){

                posX = player.getPosX();
                posY = player.getPosY();

                if(input.getUp()) {
                    renderer.rectY -= 5;
                }
                if(input.getDown()) {
                    renderer.rectY += 5;
                }

                if(input.getRight()) {
                    renderer.rectX += 5;
                }
                if(input.getLeft()) {
                    renderer.rectX -= 5;
                }
                renderer.fillRect(0, 0, renderer.WIDTH, renderer.HEIGHT, "#ffffff", renderer.gc); //Fill background to clear last frame.
                renderer.fillRect(player.posX, player.posY, 64, 64, "#448844", renderer.gc);
            }
        }, 0, 1000 / 60);
    }
}


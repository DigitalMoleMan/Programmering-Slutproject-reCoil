import java.util.ArrayList;

public class Player {

    public int posX;
    public int posY;
    int velX; //X velocity
    int velY; //Y velocity

    double acc = 5; //Acceleration
    double dec = 1.5; //Deceleration

    public Player() {
        this.posX = 128; //player X position
        this.posY = 128; //player Y position
        this.velX = 0; //player X velocity
        this.velY = 0; //player Y velocity
    }

    private int xHitboxLeft() {
        int hb = this.posX + this.velX;
        return hb;
    }

    ;

    private int xHitboxRight() {
        int hb = this.posX + 32 + this.velX;
        return hb;
    }

    private int xHitboxTop() {
        int hb = this.posY;
        return hb;
    }

    private int xHitboxBottom() {
        int hb = this.posY + 32;
        return hb;
    }

    private int yHitboxLeft() {
        int hb = this.posX;
        return hb;
    }

    ;

    private int yHitboxRight() {
        int hb = this.posX + 32;
        return hb;
    }

    private int yHitboxTop() {
        int hb = this.posY + this.velY;
        return hb;
    }

    private int yHitboxBottom() {
        int hb = this.posY + 32 + this.velY;
        return hb;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    /**
     * update is called from main every tick.
     */
    public void update() {
       // boolean colX = getCollisionX(Main.layout);
      //  boolean colY = getCollisionY();

        this.posX += this.velX;
        this.posY += this.velY;

        this.velX /= dec;
        this.velY /= dec;


    }

    //private boolean getCollisionX() {
     //   if (xHitboxLeft() < tile.x + tile.width &&
       //         xHitboxRight() > tile.x &&
         //       yHitboxTop() < tile.y + tile.height &&
          //      yHitboxBottom() > tile.y) return true;
        //else return false;
    //q}

    /**
     * readInput is called from main every tick, checks user input, runs the functions for those inputs.
     *
     * @param input ArrayList where each index represents a key, the order is defined in the input class.
     */
    public void readInput(ArrayList<Boolean> input) {
        if (input.get(0)) moveUp();
        if (input.get(1)) moveDown();
        if (input.get(2)) moveLeft();
        if (input.get(3)) moveRight();

    }

    public void moveUp() {
        this.velY -= acc;
    }

    public void moveDown() {
        this.velY += acc;
    }

    public void moveLeft() {
        this.velX -= acc;
    }

    public void moveRight() {
        this.velX += acc;
    }

}

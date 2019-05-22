import java.util.ArrayList;

public class Player {

    private double posX;
    private double posY;
    private double velX; //X velocity
    private double velY; //Y velocity

    private double acc = .6; //Acceleration
    private double dec = .9; //Deceleration

    /**
     * @param x start x position
     * @param y start y position
     */
    public Player(int x, int y) {
        this.posX = x; //player X position
        this.posY = y; //player Y position
        this.velX = 0; //player X velocity
        this.velY = 0; //player Y velocity
    }

    public int getPosX() {
        return (int) Math.round(posX);
    }

    public int getPosY() {
        return (int) Math.round(posY);
    }

    /**
     * update is called from main every tick.
     * Moves the player based on its velocity (vel) and decreases the velocity based on deceleration (dec).
     */
    public void update() {

        boolean colX = getCollisionX();
        boolean colY = getCollisionY();

        //System.out.println(this.velX);

        if (!colX) {
            this.posX += this.velX;
            this.velX *= dec;
            if(this.velX < 0.1 && this.velX > -0.1) this.velX = 0;
        } else {
            this.velX = 0;
        }

        if (!colY) {
            this.posY += this.velY;
            this.velY += .6;
        } else {
            this.acc = .4;
            this.velY = 0;
        }
    }

    /**
     * getCollisionX returns true if the player is colliding with a wall
     */
    private boolean getCollisionX() {

        for (int i = 0; i < Main.layout.size(); i++) {
            Block tile = Main.layout.get(i);
            if (this.posX + this.velX < (tile.x + tile.width) &&
             this.posX + 32 + this.velX > tile.x &&
                    this.posY < (tile.y + tile.height) &&
                    this.posY + 32 > tile.y) {
                return true;
            }
        }
        return false;
    }

    /**
     * getCollisionY returns true if the player is standing on something.
     */
    private boolean getCollisionY() {

        for (int i = 0; i < Main.layout.size(); i++) {
            Block tile = Main.layout.get(i);
            if (this.posX < tile.x + tile.width &&
                    this.posX + 32 > tile.x &&
                    this.posY + this.velY < tile.y + tile.height &&
                    this.posY + 32 + this.velY > tile.y) {
                return true;
            }
        }
        return false;
    }


    /**
     * readInput is called from main every tick, checks user input, runs the functions for those inputs.
     * @param input ArrayList where each index represents a key, the order is defined in the input class.
     */
    public void readInput(ArrayList<Boolean> input) {
        //if (input.get(0)) moveUp();
        //if (input.get(1)) moveDown();
        if (input.get(2)) moveLeft();
        if (input.get(3)) moveRight();
        if(input.get(4)) jump();

    }

    /**
     * Player will jump if it has contact with the ground.
     */
    private void jump() {
        if(getCollisionY()) this.velY = -12;
    }

    private void moveLeft() {
        this.velX -= acc;
    }

    private void moveRight() {
        this.velX += acc;
    }

}

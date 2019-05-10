import java.util.ArrayList;

public class Player {

    private double posX;
    private double posY;
    private double velX; //X velocity
    private double velY; //Y velocity

    private double acc = .3; //Acceleration
    private double dec = .9; //Deceleration

    public Player() {
        this.posX = 128; //player X position
        this.posY = 128; //player Y position
        this.velX = 0; //player X velocity
        this.velY = 0; //player Y velocity
    }

    public int getPosX() {
        return (int) Math.round(posX);
    }

    public int getPosY() {
        return (int) Math.round(posY);
    }

    private double xHitboxLeft() {
        return this.posX + this.velX;
    }

    private double xHitboxRight() {
        return this.posX + 32 + this.velX;
    }

    private double xHitboxTop() {
        return this.posY;
    }

    private double xHitboxBottom() {
        return this.posY + 32;
    }

    private double yHitboxLeft() {
        return this.posX;
    }

    private double yHitboxRight() {
        return this.posX + 32;
    }

    private double yHitboxTop() {
        return this.posY + this.velY;
    }

    private double yHitboxBottom() {
        return this.posY + 32 + this.velY;
    }

    /**
     * update is called from main every tick.
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
            this.velY += .3;
            this.acc = .3;
        } else {
            this.acc = .2;
            this.velY = 0;
        }
    }

    /**
     * getCollisionX returns true if the player is colliding with a wall
     * @return
     */
    private boolean getCollisionX() {

        for (int i = 0; i < Main.layout.size(); i++) {
            Block tile = Main.layout.get(i);
            if (xHitboxLeft() < (tile.x + tile.width) &&
                    xHitboxRight() > tile.x &&
                    xHitboxTop() < (tile.y + tile.height) &&
                    xHitboxBottom() > tile.y) {
                return true;
            }
        }
        return false;
    }

    /**
     * getCollisionY returns true if the player is standing on something.
     * @return
     */
    private boolean getCollisionY() {

        for (int i = 0; i < Main.layout.size(); i++) {
            Block tile = Main.layout.get(i);
            if (yHitboxLeft() < tile.x + tile.width &&
                    yHitboxRight() > tile.x &&
                    yHitboxTop() < tile.y + tile.height &&
                    yHitboxBottom() > tile.y) {
                return true;
            }
        }
        return false;
    }


    /**
     * readInput is called from main every tick, checks user input, runs the functions for those inputs.
     *
     * @param input ArrayList where each index represents a key, the order is defined in the input class.
     */
    public void readInput(ArrayList<Boolean> input) {
        //if (input.get(0)) moveUp();
        //if (input.get(1)) moveDown();
        if (input.get(2)) moveLeft();
        if (input.get(3)) moveRight();
        if(input.get(4)) jump();

    }

    private void jump() {
        if(getCollisionY()) this.velY = -8;
    }

    private void moveLeft() {
        this.velX -= acc;
    }

    private void moveRight() {
        this.velX += acc;
    }

}

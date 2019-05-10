import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Input {

    //Actions
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;

    //Binds
    public final int bind_up = 87;
    public final int bind_down = 83;
    public final int bind_left = 65;
    public final int bind_right = 68;



    /**
     * Initiates an Input handler
     */
    public Input() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                synchronized (Input.class) {
                    switch (e.getID()) {
                        case KeyEvent.KEY_PRESSED:
                            switch (e.getKeyCode()) {
                                case bind_up:
                                    up = true;
                                    break;
                                case bind_down:
                                    down = true;
                                    break;
                                case bind_left:
                                    left = true;
                                    break;
                                case bind_right:
                                    right = true;
                                    break;
                            }

                            break;
                        case KeyEvent.KEY_RELEASED:
                            switch (e.getKeyCode()) {
                                case bind_up:
                                    up = false;
                                    break;
                                case bind_down:
                                    down = false;
                                    break;
                                case bind_left:
                                    left = false;
                                    break;
                                case bind_right:
                                    right = false;
                                    break;
                            }
                            break;

                    }

                    return false;
                }
            }
        });
    }

    public boolean getUp() {
        return up;
    }

    public boolean getDown() {
        return down;
    }

    public boolean getLeft() {
        return left;
    }

    public boolean getRight() {
        return right;
    }

    public ArrayList<Boolean> getInput(){
        ArrayList<Boolean> input = new ArrayList<Boolean>();

        input.add(up);
        input.add(down);
        input.add(left);
        input.add(right);

        return input;
    }

}
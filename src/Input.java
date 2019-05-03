import java.awt.*;
import java.awt.event.KeyEvent;

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

    /**
     * Initiates an Input handler
     */
    public void keys() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                synchronized (Input.class) {
                    System.out.println(e.getKeyCode());
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


}
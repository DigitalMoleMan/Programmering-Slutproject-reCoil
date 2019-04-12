import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input {
    public Input() {
        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("yes");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println(e);
            }
        };
    }
}

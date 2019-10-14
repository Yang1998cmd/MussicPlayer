package mp3;

import javax.swing.*;
import java.awt.*;

public class gui extends JFrame {
    gui(String arg) {
        JFrame jFrame = new JFrame("mp3 播放器");
        jFrame.setLocation (400, 280);
        jFrame.getContentPane().add(new TextField(arg));
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

}

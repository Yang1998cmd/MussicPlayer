package wav;

import javax.swing.*;
import java.awt.*;

public class gui {
    gui(String arg) {
        JFrame jFrame = new JFrame("wav 播放器");
        jFrame.setLocation (400, 280);
        jFrame.getContentPane().add(new TextField (arg));
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
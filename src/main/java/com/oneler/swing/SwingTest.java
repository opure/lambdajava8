package com.oneler.swing;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by opure on 2017/6/15.
 */
public class SwingTest {
    public static void main(String[] args) throws InterruptedException {
        JFrame jFrame = new JFrame("test");
        final JLabel jLabel = new JLabel("ca;");
        jFrame.add(jLabel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(300, 100);
        jFrame.setVisible(true);
        TimeUnit.SECONDS.sleep(5);
        SwingUtilities.invokeLater(() -> {
            jLabel.setText("tretett");
        });
    }
}

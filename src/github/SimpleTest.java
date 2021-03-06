package github;

/**
 * Created by taylor hudson on 1/4/2017.
 */

import javax.swing.*;
import java.awt.*;

public class SimpleTest extends JFrame {
    public SimpleTest() throws HeadlessException {

        Toolkit.getDefaultToolkit().addAWTEventListener(new BarcodeAwareAWTEventListener(new BarcodeCapturedListener() {
            @Override
            public void barcodeCaptured(String barcodeString) {
                JOptionPane.showMessageDialog(SimpleTest.this, "barcode captured: " + barcodeString);
            }
        }), AWTEvent.KEY_EVENT_MASK);


        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(new JLabel("Capture barcode demo"));
        getContentPane().add(new JTextField(25));
    }

    public static void main(String[] args) {
        SimpleTest simpleTest = new SimpleTest();
        simpleTest.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        simpleTest.setVisible(true);
        simpleTest.pack();
    }
}
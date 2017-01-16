package runningButton;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Afli on 15.01.2017.
 */
public class RunningButtonApp {
    //frame size constants
    public final int FRAME_SIZE_X = 500;
    public final int FRAME_SIZE_Y = 500;

    //button location coordinates
    public static int BUTTON_X = 200;
    public static int BUTTON_Y = 220;

    public static void main(String[] args)
    {
        new RunningButtonApp().go();
    }

    private void go() {
        //creating a frame
        JFrame frame = new JFrame("Running Button");

        //creating out JPanel ith overriden paintComponent method
        RunningButtonPanel mainPanel = new RunningButtonPanel();

        //creating a button
        RunningButton button = new RunningButton("press me", frame);
        button.setFocusPainted(false); //removes border around text
        button.addMouseListener(new MyMouseListener(this, button));

        //adding components to our frame
        mainPanel.setButton(button);
        mainPanel.add(button);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        //setting frame in the center of the screen
        Dimension screenCenter = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(screenCenter.width/2-FRAME_SIZE_X/2, screenCenter.height/2-FRAME_SIZE_Y/2, FRAME_SIZE_X, FRAME_SIZE_Y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

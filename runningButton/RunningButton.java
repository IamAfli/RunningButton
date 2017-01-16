package runningButton;

import javax.swing.*;

/**
 * Created by Afli on 16.01.2017.
 */
public class RunningButton extends JButton {
    public JFrame frame;

    //max x and y coordinates a button can be set
    public int maxX = 400;
    public int maxY = 450;

    //public int speed
    public int speed = 30;

    public boolean canMove = true;
    public boolean wasClicked = false;

    public RunningButton(String s, JFrame frame) {
        super(s);
        this.frame = frame;
    }

    public void startMoving() {
        //new button coordinates
        int newX = (int)(Math.random() * maxX);
        int newY = (int)(Math.random() * maxY);


        //x and y distance
        int dx = newX - RunningButtonApp.BUTTON_X;
        int dy = newY - RunningButtonApp.BUTTON_Y;

        //distance for button to pass
        double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));

        //calculating cosAlpha and sinAlpha (Alpha is an angle between dx and distance)
        double cosAlpha = dx / distance;
        double sinAlpha = dy / distance;

        //time a button would move in ms
        int time = (int)(distance / speed * 1000);

        //this variables calculate real offset of the button
        double dxSum = RunningButtonApp.BUTTON_X;
        double dySum = RunningButtonApp.BUTTON_Y;

        //starting a motion
        //24 is a number of FPS
        for (int i = 0; i < time; i += 1000 / 24) {
            try {
                Thread.sleep(1000 / 24);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            dxSum += ((double)speed / 24) * cosAlpha;
            dySum += ((double)speed / 24) * sinAlpha;

            RunningButtonApp.BUTTON_X = (int) Math.round(dxSum);
            RunningButtonApp.BUTTON_Y = (int) Math.round(dySum);

            frame.repaint();
        }

        //increase speed if button was clicked
        if(wasClicked) {
            speed += 30;
            wasClicked = false;
        }

        canMove = true;
    }
}

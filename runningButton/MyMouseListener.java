package runningButton;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Afli on 15.01.2017.
 */
public class MyMouseListener implements MouseListener {
    private RunningButtonApp runningButtonApp;
    private RunningButton button;

    public MyMouseListener(RunningButtonApp runningButtonApp, RunningButton button) {
        this.runningButtonApp = runningButtonApp;
        this.button = button;
    }


    /**
     * changes wasClicked flag, so that a button can increase it's speed
     * changes button color, depending on the area clicked
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //setting wasClicked flag true
        button.wasClicked = true;

        //getting button width and height
        int buttonWidth = button.getWidth();
        int buttonHeight = button.getHeight();

        //changing color
        if (e.getX() < buttonWidth / 2)
        {
            if (e.getY() < buttonHeight / 2) {
                button.setBackground(Color.magenta);
                button.setForeground(Color.BLACK);
            }
            else
            {
                button.setBackground(Color.CYAN);
                button.setForeground(Color.BLUE);
            }
        }
        else {
            if (e.getY() < buttonHeight / 2) {
                button.setBackground(Color.GREEN);
                button.setForeground(Color.YELLOW);
            }
            else
            {
                button.setBackground(Color.YELLOW);
                button.setForeground(Color.GREEN);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * this method creates a thread to start the button moving to a random point
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        if (button.canMove)
        {
            button.canMove = false;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    button.startMoving();
                }
            }).start();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

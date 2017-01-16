package runningButton;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Afli on 15.01.2017.
 */
public class RunningButtonPanel extends JPanel {
    private JButton button;

    @Override
    public void paintComponent(Graphics g) {
        button.setLocation(RunningButtonApp.BUTTON_X, RunningButtonApp.BUTTON_Y);
    }

    public void setButton(JButton button) {
        this.button = button;
    }
}

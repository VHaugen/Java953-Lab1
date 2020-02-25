import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    public MainView(String title, ISignalObserver drawPanel, IController controller, int screenWidth, int screenHeight) {
        setTitle(title);
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        add(drawPanel.getPanel());
        add(controller.getPanel());
        pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        // Make the frame visible
        setVisible(true);
        // Make sure the frame exits when "x" is pressed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
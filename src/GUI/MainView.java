import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainView extends JFrame {
    public MainView(String title, List<Component> objToDraw, int screenWidth, int screenHeight) {
        setTitle(title);

        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        for(Component c : objToDraw) {
            add(c);
        }
        pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
        // Make the frame visible
        setVisible(true);
        // Make sure the frame exits when "x" is pressed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
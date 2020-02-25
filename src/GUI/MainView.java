import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame implements ISignalObserver {
    private final int screenWidth;
    private final int screenHeight;
    private int gasAmount = 0;

    DrawPanel drawPanel;
    IController controller;

    // Constructor
    public MainView(String framename, DrawPanel drawPanel, IController controller, int screenWidth, int screenHeight) {
        this.drawPanel = drawPanel;
        this.controller = controller;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        initComponents(framename);

    }

    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);
        this.add((Component) controller);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }











    @Override
    public int getGasAmount() {
        return 0;
    }

    @Override
    public void setGasAction(ActionListener e) {

    }

    @Override
    public void setBrakeAction(ActionListener e) {

    }

    @Override
    public void setTurboOnAction(ActionListener e) {

    }

    @Override
    public void setTurboOffAction(ActionListener e) {

    }

    @Override
    public void raiseRampAction(ActionListener e) {

    }

    @Override
    public void lowerRampAction(ActionListener e) {

    }

    @Override
    public void startEngineAction(ActionListener e) {

    }

    @Override
    public void stopEngineAction(ActionListener e) {

    }

    @Override
    public void actOnAction() {
        this.repaint();
    }
}

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class CarView extends JFrame implements ISignalObserver {
    private final int screenWidth;
    private final int screenHeight;
    private int gasAmount = 0;

    DrawPanel drawPanel;


    // TODO move
    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();

    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    // Constructor
    public CarView(String framename, DrawPanel drawPanel, int screenWidth, int screenHeight) {
        this.drawPanel = drawPanel;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        initComponents(framename);
    }

    public int getGasAmount() {
        return gasAmount;
    }

    public void setGasAction(ActionListener e) {
        gasButton.addActionListener(e);
    }

    public void setBrakeAction(ActionListener e) {
        brakeButton.addActionListener(e);
    }

    public void setTurboOnAction(ActionListener e) {
        turboOnButton.addActionListener(e);
    }

    public void setTurboOffAction(ActionListener e) {
        turboOffButton.addActionListener(e);
    }

    public void raiseRampAction(ActionListener e) {
        lowerBedButton.addActionListener(e);
    }

    public void lowerRampAction(ActionListener e) {
        liftBedButton.addActionListener(e);
    }

    public void startEngineAction(ActionListener e) {
        startButton.addActionListener(e);
    }

    public void stopEngineAction(ActionListener e) {
        stopButton.addActionListener(e);
    }

    @Override
    public void actOnAction() {
        this.repaint();
    }

    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);


        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2, 4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((screenWidth / 2) + 4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(screenWidth / 5 - 15, 200));
        this.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(screenWidth / 5 - 15, 200));
        this.add(stopButton);

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
}
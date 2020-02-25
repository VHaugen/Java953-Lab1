import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    private int gasAmount = 0;

    //Buttons and general "controller"
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

    public ControlPanel(int screenWidth, int screenHeight) {
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        //Sets [gasAmount] for braking and gassing.
        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(e -> gasAmount = (int) ((JSpinner) e.getSource()).getValue());

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        add(gasPanel);
        //END - Gasamount panel

        //Rest of the buttons
        controlPanel.setLayout(new GridLayout(2, 4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((screenWidth / 2) + 4, 200));
        controlPanel.setBackground(Color.cyan);
        add(controlPanel);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(screenWidth / 5 - 15, 200));
        add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(screenWidth / 5 - 15, 200));
        add(stopButton);
        //END of buttons
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

}
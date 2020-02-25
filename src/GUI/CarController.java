import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CarController extends JPanel implements IController {
    //Model to control
    private ICarModel model;
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

    public CarController(ICarModel model, int screenWidth, int screenHeight) {
        this.model = model;
        initComponents(screenWidth, screenHeight);
        bindButtons();
    }

    public void bindButtons() {
        setGasAction(e -> model.gas(gasAmount));
        setBrakeAction(e -> model.brake(gasAmount));
        setTurboOnAction(e -> model.setTurboOn());
        setTurboOffAction(e -> model.setTurboOff());
        raiseRampAction(e -> model.raiseRamp());
        lowerRampAction(e -> model.lowerRamp());
        stopEngineAction(e -> model.stopEngines());
        startEngineAction(e -> model.startEngines());
    }

    private void initComponents(int screenWidth, int screenHeight) {
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

    public Component getPanel() {
        return this;
    }

    private void setGasAction(ActionListener e) {
        gasButton.addActionListener(e);
    }

    private void setBrakeAction(ActionListener e) {
        brakeButton.addActionListener(e);
    }

    private void setTurboOnAction(ActionListener e) {
        turboOnButton.addActionListener(e);
    }

    private void setTurboOffAction(ActionListener e) {
        turboOffButton.addActionListener(e);
    }

    private void raiseRampAction(ActionListener e) {
        lowerBedButton.addActionListener(e);
    }

    private void lowerRampAction(ActionListener e) {
        liftBedButton.addActionListener(e);
    }

    private void startEngineAction(ActionListener e) {
        startButton.addActionListener(e);
    }

    private void stopEngineAction(ActionListener e) {
        stopButton.addActionListener(e);
    }

}
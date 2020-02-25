import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class CarController extends JPanel implements IController {
    // The frame that represents this instance View of the MVC pattern
    private ICarModel model;

    private final int screenWidth;
    private final int screenHeight;
    private int gasAmount = 0;

    //DrawPanel drawPanel;

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
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        initComponents();
        initButtons();
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

    public void initButtons() {
        this.setGasAction(e -> model.gas(gasAmount));
        this.setBrakeAction(e -> model.brake(gasAmount));
        this.setTurboOnAction(e -> model.setTurboOn());
        this.setTurboOffAction(e -> model.setTurboOff());
        this.raiseRampAction(e -> model.raiseRamp());
        this.lowerRampAction(e -> model.lowerRamp());
        this.stopEngineAction(e -> model.stopEngines());
        this.startEngineAction(e -> model.startEngines());
    }

    private void initComponents() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        //Sets [gasAmount] for braking and gassing.
        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 100,1);
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(e -> gasAmount = (int) ((JSpinner) e.getSource()).getValue());

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        this.add(gasPanel);
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
        //END of buttons
    }
}


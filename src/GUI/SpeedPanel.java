import javax.swing.*;
import java.awt.*;

public class SpeedPanel extends JPanel implements ISignalObserver {
    private ICarModel model;
    private final int panelwidth;
    private final int maxNumberCars;

    public SpeedPanel(int width, int height, ICarModel model, int maxNumberCars) {
        this.model = model;
        this.panelwidth = width - 20; //(-20) to keep all panels within window constrains
        this.maxNumberCars = maxNumberCars;
        setPreferredSize(new Dimension(panelwidth, height));
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    }

    @Override
    public Component getPanel() {
        return this;
    }

    //Update works by removing all panels and repaint them each tickrate.
    private void updateSpeed() {
        removeAll();
        getCarsOnField();
        for (CarModel.Tuple<String,Integer> car : model.getCarNameSpeed()) {
            JLabel carModel = new JLabel(car.getFirst() + ": " + car.getSecond() + "mm/h");
            carModel.setPreferredSize(new Dimension(panelwidth, 20));
            add(carModel);
        }
    }

    private void getCarsOnField () {
        JLabel numberOfCars = new JLabel("Current cars: " + model.getCarNameSpeed().size() + "/" + maxNumberCars);
        add(numberOfCars);
        JLabel spacer = new JLabel(" ");
        spacer.setPreferredSize(new Dimension(panelwidth, 20));
        add(spacer);
    }

    @Override
    public void actOnAction() {
        updateSpeed();
        validate();
        repaint();
    }
}

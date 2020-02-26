import javax.swing.*;
import java.awt.*;

public class SpeedPanel extends JPanel implements ISignalObserver {
    private ICarModel model;
    private final int panelwidth;

    public SpeedPanel(int width, int height, ICarModel model) {
        this.model = model;
        this.panelwidth = width - 20; //(-20) to keep all panels within window constrains
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
        for (CarModel.StringIntTuple car : model.getCarNameSpeed()) {
            JLabel carModel = new JLabel(car.getStr() + ": " + car.getAnInt() + "mm/h");
            carModel.setPreferredSize(new Dimension(panelwidth, 20));
            add(carModel);
        }
    }

    @Override
    public void actOnAction() {
        updateSpeed();
        validate();
        repaint();
    }
}

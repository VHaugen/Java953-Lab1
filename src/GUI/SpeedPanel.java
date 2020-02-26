import javax.swing.*;
import java.awt.*;

public class SpeedPanel extends JPanel implements ISignalObserver {
    private ICarModel model;


    public SpeedPanel(int panelWidth, int panelHeight, ICarModel model) {
        this.model = model;
        setPreferredSize(new Dimension(panelWidth, panelHeight));
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    }

    @Override
    public Component getPanel() {
        return this;
    }

    private void updateSpeed() {
        this.removeAll();
        for(CarModel.StringIntTuple car : model.getCarNameSpeed()) {
            StringBuilder carinfo = new StringBuilder();
            carinfo.append(car.getStr()).append(": ").append(car.getAnInt());
            JLabel carModel = new JLabel(carinfo.toString());
            carModel.setPreferredSize(new Dimension(200,20));
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

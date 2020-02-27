import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddRemoveButtons extends JPanel implements IController {
    private ICarModel model;
    private int screenWidth;
    private int screenHeight;

    private JButton addButton = new JButton("Add rnd car");
    private JButton removeButton = new JButton("Remove rnd car");

    public AddRemoveButtons(ICarModel model, int screenWidth, int screenHeight) {
        this.model = model;
        this.screenWidth = (screenWidth / 6) + 4;
        this.screenHeight = 200;//screenHeight;
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        createControlPanel();
        bindButtons();
    }

    private void createControlPanel(){
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(2, 1));
        controlPanel.add(addButton, 0);
        controlPanel.add(removeButton, 1);
        controlPanel.setPreferredSize(new Dimension(screenWidth, screenHeight));
        controlPanel.setBackground(Color.cyan);
        add(controlPanel);
    }

    private void bindButtons() {
        //addRandomCar(e -> model.addRandomCar());
        //removeRandomCar(e -> model.removeRandomCar());
    }

    public void addRandomCar(ActionListener e) {
        addButton.addActionListener(e);
    }

    public void removeRandomCar(ActionListener e) {
        removeButton.addActionListener(e);
    }


    @Override
    public Component getPanel() {
        return this;
    }
}

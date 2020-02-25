//import java.awt.event.ActionListener;

import java.awt.*;

public interface IController {
/*
    void setGasAction(ActionListener e);

    void setBrakeAction(ActionListener e);

    void setTurboOnAction(ActionListener e);

    void setTurboOffAction(ActionListener e);

    void raiseRampAction(ActionListener e);

    void lowerRampAction(ActionListener e);

    void startEngineAction(ActionListener e);

    void stopEngineAction(ActionListener e);
*/

    public Component getPanel();

    void bindButtons();
}

import java.awt.event.ActionListener;

interface ISignalObserver {

    int getGasAmount();

    void repaint();

    void setGasAction(ActionListener e);

    void setBrakeAction(ActionListener e);

    void setTurboOnAction(ActionListener e);

    void setTurboOffAction(ActionListener e);

    void raiseRampAction(ActionListener e);

    void lowerRampAction(ActionListener e);

    void startEngineAction(ActionListener e);

    void stopEngineAction(ActionListener e);
}

//If refactor timerlistener to its own class.

/*
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

*/
/* Each step the TimerListener moves all the cars in the list and tells the
 * view to update its images. Change this method to your needs.
 * *//*

class TimerListener implements ActionListener {
    ICarModel model;
    IView view;

    public TimerListener(ICarModel model, IView view) {
        this.model = model;
        this.view = view;
    }

    public void actionPerformed(ActionEvent e) {
        model.update();
        view.repaint();
    }
}

    // Add to main
    ActionListener listener = new TimerListener(carModel, view);
    Timer timer = new Timer(delay, listener);

    IController carController = new CarController(view, carModel, timer);

    // The delay (ms) corresponds to 40 updates a sec (hz) for updating screen.
    private static int delay = 25;

    //#################


    //To chainge in carController:
    // Constructor, remove delay
    public CarController(IView view, ICarModel model, Timer timer) {
        this.timer = timer;
        this.view = view;
        this.model = model;
    }
*/

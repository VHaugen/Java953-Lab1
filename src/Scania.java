import java.awt.*;

public class Scania extends Transporter {


    /**
     * This constructor creates a nice Scania S 500 truck
     * just select color and you are good to go!
     *
     * @param _color The <code>Color</code> of this <code>Car</code>.
     */
    Scania(Color _color,Engine engine,Ramp ramp) {
        super(2, engine, _color, "Scania S 500", ramp);
    }


    /**
     * Raises the bed the given amount of degrees until 70°.
     *
     * @param angle The angel in degrees
     */
    public void raiseRamp(int angle) {
        if (getCurrentSpeed() == 0) {
            ramp.raise();
        }
    }

    /**
     * Lowers the bed the given amount of degrees until 0°.
     *
     * @param angle The angel in degrees
     */
    protected void lowerRamp(int angle) {
        if (getCurrentSpeed() == 0) {
            ramp.lower();
        }
    }

}

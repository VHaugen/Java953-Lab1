import java.awt.*;

public class Scania extends Transporter {


    /**
     * This constructor creates a nice Scania S 500 truck
     * just select color and you are good to go!
     *
     * @param _color  The <code>Color</code> of this <code>Car</code>.
     */
    Scania(Color _color) {
        super(2, 500, _color, "Scania S 500", 1, 70);
    }


    /**
     * Raises the bed the given amount of degrees until 70°.
     *
     * @param angle  The angel in degrees
     */
    public void raiseRamp(int angle) {
        if (currentSpeed == 0) {
            bed.raise(angle);
        }
    }

    /**
     * Lowers the bed the given amount of degrees until 0°.
     *
     * @param angle  The angel in degrees
     */
    protected void lowerRamp(int angle) {
        if (currentSpeed == 0) {
            bed.lower(angle);
        }
    }

}

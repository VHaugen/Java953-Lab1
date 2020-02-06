public class Bed {

    private int angle = 0;
    private int maxAngle;
    private int increment;

    /**
     * @param _increment The value that standard angle change uses;
     * @param _maxAngle  Represents the max allowed angle value of the bed;
     */
    public Bed(int _increment, int _maxAngle) {
        increment = _increment;
        maxAngle = _maxAngle;
    }

    /**
     * raises the bed by value;
     *
     * @param amount The value you want the bed angle to be;
     */
    public void raise(int amount) {
        while (angle + increment < amount && amount < maxAngle)
            angle += increment;
    }

    public int getAngle() {
        return angle;
    }

    /**
     * raises bed fixed value;
     */
    public void raise() {
        while (maxAngle < angle + increment) {
            angle += increment;
        }
    }

    /**
     * lowers bed by value;
     *
     * @param amount how much you want to lower with;
     */
    public void lower(int amount) {
        while (0 < angle - amount) {
            angle -= amount;
        }
    }

    /**
     * lowers bed to lowest state = 0;
     */
    public void lower() {
        angle = 0;
    }

}

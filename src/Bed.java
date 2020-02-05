public class Bed {

    private int angle = 0;
    private int maxAngle;
    private int increment;


    public Bed(int _increment, int _maxAngle) {
        _increment = increment;
        _maxAngle = maxAngle;
    }

    public void raise(int amount) {
        while (amount < angle + increment) {
            angle += increment;
        }
    }

    public int getAngle() {
        return angle;
    }

    public void raise() {
        while (maxAngle < angle + increment) {
            angle += increment;
        }
    }

    public void lower(int amount) {
        while (0 < angle - amount) {
            angle -= amount;
        }
    }

    public void lower() {
        angle = 0;
    }

}

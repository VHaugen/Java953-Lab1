public class Ramp {
    private int angle = 0;
    private int maxAngle;

    /**
     * Creates a ramp that can be between 0 to 70 degrees.
     */
    public Ramp(int maxAngle) {
        this.maxAngle = maxAngle;
    }

    public Ramp(int maxAngle, int angle) {
        this.maxAngle = maxAngle;
        this.angle = angle;
    }

    public Ramp(Ramp ramp) {
        this.maxAngle = ramp.maxAngle;
        this.angle = ramp.angle;
    }

    /**
     * Raises the ramp one degree.
     */
    public Ramp raise() {
        int newAngle = angle;
        if (0 < angle) newAngle--;
        return new Ramp(maxAngle, newAngle);
    }

    /**
     * Lowers the ramp one degree.
     */
    public Ramp lower() {
        int newAngle = angle;
        if (maxAngle > angle) newAngle++;
        return new Ramp(maxAngle, newAngle);
    }

    /**
     * @return Returns the current angle of the ramp.
     */
    public int getAngle() {
        return angle;
    }

    /**
     * @return Returns the max angle of the ramp.
     */
    public int getMaxAngle() {
        return maxAngle;
    }
}

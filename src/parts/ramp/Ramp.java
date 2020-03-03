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
        if (0 < angle) angle--;
        return new Ramp(maxAngle, angle);
    }

    /**
     * Lowers the ramp one degree.
     */
    public Ramp lower() {
        if (maxAngle > angle) angle++;
        return new Ramp(maxAngle, angle);
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

    /**
     * @param angle Sets the angle of the ramp to chosen value.
     */
    protected void setAngle(int angle) {
        if (angle >= 0 && angle <= maxAngle) this.angle = angle;
    }

}

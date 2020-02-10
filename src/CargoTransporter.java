import java.awt.*;

abstract class CargoTransporter<T extends IPositionable> extends Transporter {

    private Cargo<T> cargo;

    /**
     *
     * @param engine The chosen engine type.
     * @param color Which color the CarTransporter should have.
     * @param modelName Its modelname.
     * @param ramp What kind of ramp it should have.
     * @param cargo Cargo and which type it should be able to load.
     */
    public CargoTransporter(Engine engine, Color color, String modelName, Ramp ramp, Cargo<T> cargo) {
        super(engine, color, modelName, ramp);
        this.cargo = cargo;
    }

    /**
     * Moves this <code>CargoTransporter</code> in the current direction according to the current speed.
     * And also uppdates the <code>Position</code> of the <code>Cargo</code>
     */
    @Override
    public void move() {
        super.move();
        cargo.updatePositions(getPos());
    }

    /**
     * Loads an <code>IPositionable</code> who is within a distance of 5 from this <code>CargoTransporter</code>
     * to the <code>Cargo</code>.
     *
     * @param movable The car that will be loaded to the trailer.
     * @return <code>True</code> if the given <code>IPositionable</code> was within range otherwise <code>False</code>
     */
    public boolean load(T movable) {
        if (isSafeToLoad() && isInRange(movable)) {
            return cargo.load(movable);
        } else {
            return false;
        }
    }

    /**
     * Removes one <code>IPositionable</code> from the <code>Cargo</code> and places it a distance 2 away.
     *
     * @return The removed <code>IPositionable</code> if any. Otherwise <code>null</code>.
     */
    public T unLoad() {
        if (isSafeToLoad()) {
            T movable = cargo.unload();
            if (movable != null) {
                movable.setPos(getPos().add(unLoadPosition())); // TODO unLoad behind of in front
                return movable;
            }
        }
        return null;
    }

    /**
     *
     * @return Returns the entire cargo.
     */
    public Cargo<T> getCargo(){
        return cargo;
    }

    /**
     * Checks if the CargoTransporter is safe to load/unload. Ramp has to be at 0 angle and 0 speed.
     * @return True if angle is 0 and speed is 0.
     */
    protected boolean isSafeToLoad() {
        return getRamp().getAngle() == getRamp().getMaxAngle() && getCurrentSpeed() == 0;
    }

    /**
     *
     * @param movable Tests if object is in range to check it it's allowed to be loaded.
     * @return If it's in range, it returns true.
     */
    private boolean isInRange(T movable) {
        return getPos().distanceTo(movable.getPos()) <= 5;
    }


    /**
     *
     * @return Return new position object to replace the old.
     */
    protected Position unLoadPosition() {
        return new Position(-getMotion().getVelX() * 2, -getMotion().getVelY() * 2);

    }
}

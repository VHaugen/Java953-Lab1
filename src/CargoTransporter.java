import java.awt.*;

abstract class CargoTransporter<T extends IPositionable> extends Transporter {

    private Cargo<T> cargo;


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
        T movable;
        if (isSafeToLoad()) {
            movable = cargo.unload();
            if (movable != null) {
                movable.setPos(getPos().add(unLoadPosition())); // TODO unLoad behind of in front
                return movable;
            }
        }
        return null;
    }

    public Cargo<T> getCargo(){
        return cargo;
    }

    protected boolean isSafeToLoad() {
        return ramp.getAngle() == 0 && getCurrentSpeed() == 0;
    }

    private boolean isInRange(T movable) {
        return getPos().distanceTo(movable.getPos()) <= 5;
    }

    protected Position unLoadPosition() {
        return new Position(-getMotion().getVelX() * 2, -getMotion().getVelY() * 2);

    }
}

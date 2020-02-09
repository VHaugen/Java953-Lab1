import java.awt.*;

abstract class CargoTransporter extends Transporter {

    private Cargo<IMovable> cargo;


    public CargoTransporter(Motor motor, Color color, String modelName, Ramp ramp, Cargo cargo) {
        super(motor, color, modelName, ramp);
        this.cargo = cargo;
    }

    @Override
    public void move() {
        super.move();
        cargo.updatePositions(getPos());
    }

    private boolean isSafeToLoad() {
        return ramp.getAngle() == 0 && getCurrentSpeed() == 0;
    }

    /**
     * Load a car to the trailer
     *
     * @param movable The car that will be loaded to the trailer.
     */
    public boolean load(IMovable movable) {
        if (isSafeToLoad() && isInRange(movable)) {
            return cargo.load(movable);
        } else {
            return false;
        }
    }

    /**
     * Removes item/vehicle from the first position of the lane.
     */
    public IMovable unLoad() {
        IMovable movable;
        if (isSafeToLoad()) {
            movable = cargo.unload();

            if (movable != null ) {
                movable.setPos(getPos().add(unLoadPosition())); // TODO unLoad behind of in front
                return movable;
            }
        }

        return null;
    }

    private boolean isInRange(IMovable movable) {
        return getPos().distanceTo(movable.getPos()) <= 5;
    }


    private Position unLoadPosition(){
        return new Position(-getMotion().getVelX() * 2, -getMotion().getVelY() *2);

    }
}

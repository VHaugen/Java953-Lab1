import java.awt.*;
import java.util.*;
import java.util.List;

public class Ferry extends Motorized implements IFerryCargo {
    protected Ramp ramp;
    private int maxLaneLength;
    private boolean laneFull;
    private Queue<IFerry> lane;

    /**
     * This constructor is generic and is made to take standard arguments
     * to specify only the neccasery arguments for creating a ferry.
     * OR SO IM TOLD?!?!?!
     *
     * @param engine   The power of the engine in BHP.
     * @param _color         The <code>Color</code> of this <code>Ferry</code>.
     * @param _modelName     The model name of this <code>Ferry</code>
     * @param _maxLaneLength Specify length of lane.
     */
    Ferry(Engine engine, Color _color, String _modelName, int _maxLaneLength) {
        super(engine, _color, _modelName);
        maxLaneLength = _maxLaneLength;
        //Use to check if lane is full.
        laneFull = false;
        lane = new LinkedList<>();
        ramp = new Ramp(90); //TODO Is max angle correct??
        stopEngine();
    }

    /**
     * @param item The vehicle or object you want to load to the ferry.
     */
    public boolean load(IFerry item) {
        if (ramp.getAngle() == 0 && getCurrentSpeed() == 0) {
            return addToLane(item);
        }
        return false;
    }

    /**
     * Removes item/vehicle from the first position of the lane.
     */
    public boolean unload() {
        if (ramp.getAngle() == 0 && getCurrentSpeed() == 0) {
            return removeFromLane();
        }
        return false;
    }

    //Helper method to unload. checks if lane has an item and then removes it.
    private boolean removeFromLane() {
        if (lane.size() > 0) {
            lane.remove();
            checkLane();
            return true;
        }
        return false;
    }

    //Helper method to load. Checks lane and adds item to lane then checks size again.
    private boolean addToLane(IFerry item) {
        if (!checkLane()) {
            lane.add(item);
            checkLane();
            return true;
        } else {
            return false;
        }
    }

    //Use to check if lane is full and set isLaneFull to true or false if lane is full or not.
    private boolean checkLane() {
        return laneFull = lane.size() >= maxLaneLength;
    }

    /**
     *
     * @return Gives the length/spaces the lane has.
     */
    public int getMaxLaneLength() {
        return maxLaneLength;
    }


    /**
     *
     * @return Gives current lane load and max length/spaces.
     */
    public int[] getLaneCurrentMax() {
        int[] getLoad = new int[2];
        getLoad[0] = lane.size();
        getLoad[1] = maxLaneLength;
        return getLoad;
    }

    /**
     *
     * @return Gives current occupied spaces on the lane.
     */
    public int getLaneLoad() {
        return lane.size();
    }

    /**
     *
     * @return Returns true if the lane is fully occupied.
     */
    public boolean getLaneFull() {
        return laneFull;
    }

    /**
     *
     * @param amount Accepts values between 0-1 for gassing.
     */
    @Override
    public void gas(double amount) {
        if (acceptableValue(amount) && ramp.getAngle() > 0)
            incrementSpeed(amount);
    }

    /**
     * Raises ramp
     */
    public void raiseRamp() {
        if (getCurrentSpeed() == 0) {
            ramp.raise();
        }
    }

    /**
     * Lowers ramp
     */
    public void lowerRamp() {
        if (getCurrentSpeed() == 0) {
            ramp.lower();
        }
    }

}

import java.awt.*;
import java.util.*;
import java.util.List;

public class Ferry extends Motorized implements ITransporter {
    protected Bed bed;
    private int maxLaneLength;
    private boolean laneFull;
    private Queue<IFerry> lane;

    /**
     * This constructor is generic and is made to take standard arguments
     * to specify only the neccasery arguments for creating a ferry.
     * OR SO IM TOLD?!?!?!
     *
     * @param _enginePower   The power of the engine in BHP.
     * @param _color         The <code>Color</code> of this <code>Ferry</code>.
     * @param _modelName     The model name of this <code>Ferry</code>
     * @param _maxLaneLength Specify length of lane.
     */
    Ferry(double _enginePower, Color _color, String _modelName, int _maxLaneLength) {
        super(_enginePower, _color, _modelName);
        maxLaneLength = _maxLaneLength;
        //Use to check if lane is full.
        laneFull = false;
        lane = new LinkedList<>();
        bed = new Bed(90, 90);
        stopEngine();
    }

    /**
     * @param item The vehicle or object you want to load to the ferry.
     */

    public boolean load(IFerry item) {
        if (bed.getAngle() == 0 && currentSpeed == 0) {
            return addToLane(item);
        }
        return false;
    }

    /**
     * Removes item/vehicle from the lane.
     */
    public boolean unload() {
        if (bed.getAngle() == 0 && currentSpeed == 0) {
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

    public int getMaxLaneLength() {
        return maxLaneLength;
    }

    public int[] getLaneCurrentMax() {
        int[] getLoad = new int[2];
        getLoad[0] = lane.size();
        getLoad[1] = maxLaneLength;
        return getLoad;
    }

    public int getLaneLoad() {
        return lane.size();
    }

    public boolean getLaneFull() {
        return laneFull;
    }

    @Override
    public void gas(double amount) {
        if (acceptableValue(amount) && bed.getAngle() > 0)
            incrementSpeed(amount);
    }

    public void raiseRamp() {
        if (currentSpeed == 0) {
            bed.raise();
        }
    }

    public void lowerRamp() {
        if (currentSpeed == 0) {
            bed.lower();
        }
    }
}

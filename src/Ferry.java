import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Ferry extends Motorized implements ITransporter {
    private Bed bed;
    private int maxLaneLength;
    private int numOfLanes;
    private boolean[] isLaneFull;
    private List<Queue<IFerry>> lanes = new ArrayList<>();

    /**
     * This constructor is generic and is made to take standard arguments
     * to specify only the neccasery arguments for creating a ferry.
     * OR SO IM TOLD?!?!?!
     *
     * @param _enginePower   The power of the engine in BHP.
     * @param _color         The <code>Color</code> of this <code>Ferry</code>.
     * @param _modelName     The model name of this <code>Ferry</code>
     * @param _maxLaneLength Specify length of lane.
     * @param _numOfLanes    Specify number of lanes.
     */
    Ferry(double _enginePower, Color _color, String _modelName, int _maxLaneLength, int _numOfLanes) {
        super(_enginePower, _color, _modelName);
        maxLaneLength = _maxLaneLength;
        numOfLanes = _numOfLanes;
        //Use to check if lane is full.
        isLaneFull = new boolean[_numOfLanes];
        Arrays.fill(isLaneFull, Boolean.FALSE);
        bed = new Bed(90, 90);
        stopEngine();
    }

    /**
     * @param item The vehicle or object you want to load to the ferry.
     * @param lane Which lane you want to add your item to.
     *             If full it tries to add to the other. Else full.
     */

    public boolean load(IFerry item, int lane) {
        if (bed.getAngle() == 0 && currentSpeed == 0) {
            if (lane < numOfLanes) {
                if (lanes.get(lane).size() < maxLaneLength) {
                    lanes.get(lane).add(item);
                    checkLane(lane);
                    return true;
                } else {
                    for (int i = 0; i < isLaneFull.length; i++) {
                        if (!isLaneFull[i]) {
                            lanes.get(i).add(item);
                            checkLane(i);
                            return true;
                        }
                        if (i == isLaneFull.length - 1) {
                            System.out.println("Ferry is fully loaded");
                            return false;
                        }
                    }
                }
            }
        } else {
            System.out.println("Bed is not lowered.");
            return false;
        }
        return false;
    }

    /**
     * @param lane Removes item/vehicle at chosen lane.
     */
    public boolean unload(int lane) {
        if (bed.getAngle() == 0 && currentSpeed == 0) {
            if (lane <= numOfLanes) {
                if (lanes.get(lane).size() > 0) {
                    IFerry item = lanes.get(lane).peek();
                    item.setPosX(this.posX);
                    item.setPosY(this.posY);
                    lanes.get(lane).remove();
                    checkLane(lane);
                    return true;
                } else {
                    System.out.println("Lane is empty!");
                    return false;
                }
            } else {
                System.out.println("Lane doesn't exist.");
                return false;
            }
        } else {
            System.out.println("Bed is not lowered.");
            return false;
        }
        return false;
    }

    //Use to check if lane is full and set isLaneFull to true or false if lane is full or not.
    private void checkLane(int lane) {
        isLaneFull[lane] = maxLaneLength <= lanes.get(lane).size();
    }

    public int getMaxLaneLength () {
        return maxLaneLength;
    }

    public int getNumOfLanes () {
        return numOfLanes;
    }

    public boolean[] getIsLaneFull () {
        return isLaneFull;
    }

    @Override
    public void gas(double amount) {
        if (acceptableValue(amount) && bed.getAngle() == 0)
            incrementSpeed(amount);
    }

    public void raiseRamp() {
        if (currentSpeed == 0) {
            bed.raise();
        }
    }

    protected void lowerRamp() {
        if (currentSpeed == 0) {
            bed.lower();
        }
    }
}

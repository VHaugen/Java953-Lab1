import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Ferry extends Motorized implements ITransporter {
    Bed bed;
    private int maxLaneLength;
    private int numOfLanes;
    private boolean[] isLaneFull;
    private List<Queue<IFerry>> lanes = new ArrayList<>();

    /**
     * This constructor is generic and is made to take standard arguments
     * to specify only the neccasery arguments for creating a ferry.
     * OR SO IM TOLD?!?!?!
     *
     * @param _enginePower The power of the engine in BHP.
     * @param _color       The <code>Color</code> of this <code>Ferry</code>.
     * @param _modelName   The model name of this <code>Ferry</code>
     * @param _maxLaneLength Specify length of lane.
     * @param _numOfLanes Specify number of lanes.
     */
    Ferry(double _enginePower, Color _color, String _modelName, int _maxLaneLength, int _numOfLanes) {
        super(_enginePower, _color, _modelName);
        maxLaneLength = _maxLaneLength;
        numOfLanes = _numOfLanes;
        //Use to check if lane is full.
        isLaneFull = new boolean[_numOfLanes];
        Arrays.fill(isLaneFull,Boolean.FALSE);
    }

    /**
     *
     * @param item The vehicle or object you want to load to the ferry.
     * @param lane Which lane you want to add your item to.
     *             If full it tries to add to the other. Else full.
     *
     */

    //TODO add check for bed raised. IF. SAME FOR UNLOAD
    public void load(IFerry item, int lane) throws Exception {
        if (lane < numOfLanes) {
            if (lanes.get(lane).size() < maxLaneLength) {
                lanes.get(lane).add(item);
                checkLane(lane);
            } else {
                for (int i = 0; i < isLaneFull.length; i++) {
                    if (!isLaneFull[i]) {
                        lanes.get(i).add(item);
                        break;
                    }
                    if (i == isLaneFull.length-1) {
                        System.out.println("Ferry is fully loaded");
                    }
                }
            }
        }
    }

    /**
     * @param lane Removes item/vehicle at chosen lane.
     */
    public void unload(int lane) {
        if (lane <= numOfLanes) {
            if (lanes.get(lane).size() > 0) {
                lanes.get(lane).remove();
                checkLane(lane);
            } else {
                System.out.println("Lane is empty!");
            }
        } else {
            System.out.println("Lane doesn't exist.");
        }
    }

    //Use to check if lane is full and set isLaneFull to true or false if lane is full or not.
    private void checkLane(int lane) {
        isLaneFull[lane] = maxLaneLength <= lanes.get(lane).size();
    }

    @Override
    public void move() {

    }

    @Override
    public void turnLeft() {

    }

    @Override
    public void turnRight() {

    }

}

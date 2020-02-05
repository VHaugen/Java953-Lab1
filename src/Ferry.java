import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Ferry extends Motorized {
    Bed bed;
    private static final int maxLaneLength = 5;
    private int numOfLanes;
    private List<Queue<IFerry>> lanes = new ArrayList<>();

    /**
     * This constructor is generic and is made to take standard arguments
     * to specify only the neccasery arguments for creating a ferry.
     * OR SO IM TOLD?!?!?!
     *
     * @param _enginePower The power of the engine in BHP.
     * @param _color       The <code>Color</code> of this <code>Ferry</code>.
     * @param _modelName   The model name of this <code>Ferry</code>
     */
    Ferry(double _enginePower, Color _color, String _modelName, int _numOfLanes) {
        super(_enginePower, _color, _modelName);
        numOfLanes = _numOfLanes;
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

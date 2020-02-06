import java.util.Stack;

public class Cargo {
    //TODO <> To generic class? T? All IFerry?
    private Stack<IFerry> list;

    //Specify max number of objects in the list.
    private int maxCapacity;

    //Just an helper instance variable to check if it's full.
    private boolean isFull;

    public Cargo(int maxCapacity) {
        this.list = new Stack<>();
        this.maxCapacity = maxCapacity;
        this.isFull = false;
    }

    /**
     * @param item Add item to your list.
     * @return Returns <b>true</b> if it successfully added the item to the list, otherwise <b>false</b>.
     */
    public boolean load(IFerry item) {
        if (!checkLane()) {
            list.add(item);
            checkLane();
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return Returns <b>true</b> if it successfully removed the item from the head of the list,
     * otherwise <b>false</b>.
     */
    public boolean unload() {
        if (list.size() > 0) {
            list.pop();
            checkLane();
            return true;
        }
        return false;
    }

    /**
     * @return Returns <b>true</b> if it successfully removed the first item of the list,
     * otherwise <b>false</b>.
     */
    public boolean unloadFirst() {
        if (list.size() > 0) {
            list.remove(0);
            checkLane();
            return true;
        }
        return false;
    }

    //Helper method to load/unload. Returns bool and sets 'isFull' to a bool-value.
    private boolean checkLane() {
        return isFull = list.size() >= maxCapacity;
    }

    /**
     * @return Gives the length/spaces the lane has.
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * @return Gives currently occupied space.
     */
    public int getLoadedSpace() {
        return list.size();
    }

    /**
     * @return Returns true if the lane is fully occupied.
     */
    public boolean getIsFull() {
        return isFull;
    }
}

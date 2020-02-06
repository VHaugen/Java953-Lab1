import java.util.Stack;

public class Cargo<T extends IMovable> {
    //TODO <> To generic class? T? All IFerry?
    private Stack<IMovable> list;

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
    public boolean load(IMovable item) {
        if (!checkLoad()) {
            list.add(item);
            checkLoad();
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return Returns the item if it successfully removed the item from the head of the list,
     * otherwise <b>null</b>.
     */
    public IMovable unload() {
        if (list.size() > 0) {
            IMovable item = list.pop();
            checkLoad();
            return item;
        }
        return null;
    }

    /**
     * @return Returns the item if it successfully removed the first position of the list,
     * otherwise <b>null</b>.
     */
    public IMovable unloadFirst() {
        if (list.size() > 0) {
            IMovable item = list.remove(0);
            checkLoad();
            return item;
        }
        return null;
    }

    public void updatePositions(double x, double y) {
        for (IMovable item: list) {
            item.setPosX(x);
            item.setPosY(y);
        }
    }

    //Helper method to load/unload. Returns bool and sets 'isFull' to a bool-value.
    private boolean checkLoad() {
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
    public int getCurrentLoad() {
        return list.size();
    }

    /**
     * @return Returns true if the lane is fully occupied.
     */
    public boolean getIsFull() {
        return isFull;
    }
}

import java.util.Stack;

public class Cargo<C extends IDriveable> {
    protected Stack<C> list;

    //Specify max number of objects in the list.
    private int maxCapacity;

    //Just an helper instance variable to check if it's full.
    private boolean isFull;

    /**
     *  Creates a container with IPositionable objects.
     *
     * @param maxCapacity Specify maximum number of objects in the cargo.
     */
    public Cargo(int maxCapacity) {
        this.list = new Stack<>();
        this.maxCapacity = maxCapacity;
        this.isFull = false;
    }

    /**
     *  Loads an IPositionable to the <code>Cargo</code>.
     *
     * @param item Add item to your list.
     * @return Returns <b>true</b> if it successfully added the item to the list, otherwise <b>false</b>.
     */
    public boolean load(C item) {
        if (!checkLoad()) {
            list.add(item);
            checkLoad();
            return true;
        } else {
            return false;
        }
    }

    /**
     *  Unloads an IPositionable from the <code>Cargo</code>.
     *
     * @return Returns the item if it successfully removed the item from the head of the list,
     * otherwise <b>null</b>.
     */
    protected C unload() {
        if (list.size() > 0) {
            C item = list.pop();
            checkLoad();
            return (C) item.createVehicle(item.getMotion());
        }
        return null;
    }

    /**
     *
     * @param pos Enter a positional object.
     *            It will give every object in the cargo the positional objects coordinates.
     */
    protected void updatePositions(Position pos) {
        Stack<C> newList = new Stack<>();
        for (C item : list) {
            newList.add((C) item.createVehicle(new Motion(item.getMotion(), new Position(pos))));
        }
        list = newList;
    }

    //Helper method to load/unload. Returns bool and sets 'isFull' to a bool-value.
    protected boolean checkLoad() {
        return isFull = list.size() >= maxCapacity;
    }

    /**
     * @return Gives the max cargo space.
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * @return Gives current cargo load.
     */
    public int getCurrentLoad() {
        return list.size();
    }

    /**
     * @return Returns true if the cargo is fully occupied.
     */
    public boolean getIsFull() {
        return isFull;
    }

    /**
     * @return Returns true if cargo is empty.
     */
    public boolean getIsEmpty() {
        return list.size() <= 0;
    }
}

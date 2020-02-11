public class CargoFirstOut<C extends IPositionable> extends Cargo<C> {
    /**
     * Creates a container with IPositionable objects.
     *
     * @param maxCapacity Specify maximum number of objects in the cargo.
     */
    public CargoFirstOut(int maxCapacity) {
        super(maxCapacity);
    }

    /**
     * @return Returns the item if it successfully removed the first position of the list,
     * otherwise <b>null</b>.
     */
    @Override
    protected C unload() {
        if (list.size() > 0) {
            C item = list.remove(0);
            checkLoad();
            return item;
        }
        return null;
    }
}

public class RepairCenter<T extends IMovable> {

    public Cargo<T> getCarQue() {
        return carQue;
    }

    private Cargo<T> carQue;

    /**
     * Creates a repaircenter for vehicles.
     * @param maxCars Specifies max number of vehicles that can be in the repair center.
     */
    public RepairCenter(int maxCars) {
        this.carQue = new Cargo<>(maxCars);
    }

    /**
     *
     * @param motorized Adds vehicle to repair queue.
     */
    public void addCarToQue(T motorized)
    {
        carQue.load(motorized);
    }

    /**
     *
     * @return Repaired vehicle is removed from the queue and returned.
     */
    public T RemoveCarFromQue()
    {
        return carQue.unload();
    }


}

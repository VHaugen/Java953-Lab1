import java.util.Stack;

public class RepairCenter<T extends IMovable> {


    private Cargo<T> carQue;

    public RepairCenter(int maxCars) {
        this.carQue = new Cargo<T>(maxCars);
    }

    public void addCarToQue(T moterized)
    {
        carQue.load(moterized);
    }
    public T RemoveCarFromQue()
    {
        return (T)carQue.unload();
    }


}

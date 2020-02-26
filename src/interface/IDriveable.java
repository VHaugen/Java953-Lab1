public interface IDriveable extends IMovable {

    void gas(double amount);

    void brake(double amount);

    void stopEngine();

    void startEngine();

    double getCurrentSpeed();

    String getModelName();
}

public interface IDriveable extends IMovable {

    IDriveable gas(double amount);

    IDriveable brake(double amount);

    IDriveable stopEngine();

    IDriveable startEngine();

    double getCurrentSpeed();

    String getModelName();
}

public interface IDriveable extends IMovable {

    IDriveable gas(double amount);

    IDriveable brake(double amount);

    IDriveable stopEngine();

    IDriveable startEngine();

    IDriveable createVehicle(Motion m);

    Motion getMotion();

    double getCurrentSpeed();

    String getModelName();
}

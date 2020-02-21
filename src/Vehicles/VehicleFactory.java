public class VehicleFactory {
    public static IDriveable createSaab() {
        return new Saab95();
    }
    public static IDriveable createVolvo() {
        return new Volvo240();
    }
    public static IDriveable createScania() {
        return new Scania();
    }
}

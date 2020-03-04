public class VehicleFactory {
    public static ITurbo createSaab() {
        return new Saab95();
    }
    public static IDriveable createVolvo() {
        return new Volvo240();
    }
    public static ITransporter createScania() {
        return new Scania();
    }
}

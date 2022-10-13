public class TransportFactory {
    public Transport createTransport(boolean isCar){

        if (isCar) return CarFactory.createCar();

        return null;
    }
}

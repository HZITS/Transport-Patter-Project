public class TransportFactory {
    public Transport createTransport(boolean isCar){

        if (isCar) return new Transport(CarFactory.createCar(),null);

        return null;
    }
}

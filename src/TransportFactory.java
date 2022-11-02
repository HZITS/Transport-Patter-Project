import ConcreteObjects.Plane;

public class TransportFactory {
    public Transport createTransport(boolean isCar){
        if (isCar) return new Transport(CarFactory.startFactory(),null);
        else return new Transport(null, PlaneFactory.startFactory());
    }
}

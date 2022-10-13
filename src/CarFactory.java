import CarSub.BodyType.Sedan;
import CarSub.CarDecorator;
import ConcreteObjects.Car;

public class CarFactory extends TransportFactory{
    public static Car createCar() {
        return new Sedan(new CarDecorator());
    }
}

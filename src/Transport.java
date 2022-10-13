import ConcreteObjects.Car;
import ConcreteObjects.Plane;

abstract class Transport {
    String name;
    Car car;
    Plane plane;

    public Transport(String name, Car car, Plane plane) {
        this.name = name;
        this.car = car;
        this.plane = plane;
    }
}

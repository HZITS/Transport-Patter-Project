package CarSub;

import ConcreteObjects.Car;

public class CarDecorator extends Car {
    public Car car;

    public CarDecorator(Car car){
        this.car=car;
    }

    public Car getCar() {
        return car;
    }
}

package CarSub.BodyType;

import CarSub.CarDecorator;
import ConcreteObjects.Car;

public class Sedan extends CarDecorator {
    public Sedan(Car car) {
        super(car);
    }

    public String getDescription(){
        return car.getDescription()+" with body type Sedan";
    }
}

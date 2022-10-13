package CarSub.BodyType;

import CarSub.CarDecorator;
import ConcreteObjects.Car;

public class Hatchback extends CarDecorator {
    public Hatchback(Car car) {
        super(car);
    }

    @Override
    public double getSpeed() {
        return car.getSpeed()+10;
    }
    public double getKpl() {
        return car.getKpl()-0.03;
    }
    public String getDescription(){
        return car.getDescription()+" with body type Hatchback";
    }
}

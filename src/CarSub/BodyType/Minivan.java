package CarSub.BodyType;

import CarSub.CarDecorator;
import ConcreteObjects.Car;

public class Minivan extends CarDecorator {
    public Minivan(Car car) {
        super(car);
    }
    @Override
    public double getSpeed() {
        return car.getSpeed()+10;
    }
    public double getKpl() {
        return car.getKpl()+0.06;
    }
    public String getDescription(){
        return car.getDescription()+" with body type Minivan";
    }
}

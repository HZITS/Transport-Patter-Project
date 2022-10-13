package CarSub.BodyType;

import CarSub.CarDecorator;
import ConcreteObjects.Car;

public class Sport extends CarDecorator {
    public Sport(Car car) {
        super(car);
    }
    @Override
    public double getSpeed() {
        return car.getSpeed()+90;
    }
    public double getKpl() {
        return car.getKpl()+0.1;
    }
    public String getDescription(){
        return car.getDescription()+" with body type Sport";
    }
}

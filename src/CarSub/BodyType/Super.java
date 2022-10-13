package CarSub.BodyType;

import CarSub.CarDecorator;
import ConcreteObjects.Car;

public class Super extends CarDecorator {
    public Super(Car car) {
        super(car);
    }
    @Override
    public double getSpeed() {
        return car.getSpeed()+210;
    }
    public double getKpl() {
        return car.getKpl()+0.3;
    }
    public String getDescription(){
        return car.getDescription()+" with body type Super";
    }
}

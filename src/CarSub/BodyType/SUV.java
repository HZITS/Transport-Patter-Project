package CarSub.BodyType;

import CarSub.CarDecorator;
import ConcreteObjects.Car;

public class SUV extends CarDecorator {
    public SUV(Car car) {
        super(car);
    }
    @Override
    public double getSpeed() {
        return car.getSpeed()-5;
    }
    public double getKpl() {
        return car.getKpl()+0.07;
    }
    public String getDescription(){

        return car.getDescription()+" with body type SUV";
    }
}

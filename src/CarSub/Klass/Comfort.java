package CarSub.Klass;

import CarSub.CarDecorator;
import ConcreteObjects.Car;

public class Comfort extends CarDecorator {
    public Comfort(Car car) {
        super(car);
    }
    @Override
    public double getSpeed() {
        return car.getSpeed()+10;
    }
    public double getKpl() {
        return car.getKpl();
    }
    public double getFuelPrice() {
        return car.getFuelPrice()+10;
    }
    public String getDescription(){
        return car.getDescription()+" Comfort class";
    }
}

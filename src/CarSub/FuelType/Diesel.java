package CarSub.FuelType;

import CarSub.CarDecorator;
import ConcreteObjects.Car;

public class Diesel extends CarDecorator {
    public Diesel(Car car) {
        super(car);
    }
    @Override
    public double getSpeed() {
        return car.getSpeed();
    }
    public double getKpl() {
        return car.getKpl()*0.8;
    }
    public double getFuelPrice() {
        return car.getFuelPrice()*2;
    }
    public String getDescription(){
        return car.getDescription()+" with fuel type Diesel";
    }
}

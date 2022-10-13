package CarSub.FuelType;

import CarSub.CarDecorator;
import ConcreteObjects.Car;

public class Hybrid extends CarDecorator {
    public Hybrid(Car car) {
        super(car);
    }
    @Override
    public double getSpeed() {
        return car.getSpeed()+8;
    }
    public double getKpl() {
        return car.getKpl()*0.67;
    }
    public double getFuelPrice() {
        return car.getFuelPrice()-20;
    }
    public String getDescription(){
        return car.getDescription()+" with fuel type Hybrid";
    }
}

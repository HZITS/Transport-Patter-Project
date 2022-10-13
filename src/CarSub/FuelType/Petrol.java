package CarSub.FuelType;

import CarSub.CarDecorator;
import ConcreteObjects.Car;

public class Petrol extends CarDecorator {
    public Petrol(Car car) {
        super(car);
    }
    @Override
    public String getDescription(){
        return car.getDescription()+" with fuel type petrol";
    }
}

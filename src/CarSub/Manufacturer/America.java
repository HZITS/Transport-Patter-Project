package CarSub.Manufacturer;

import CarSub.CarDecorator;
import ConcreteObjects.Car;

public class America extends CarDecorator {

    public America(Car car) {
        super(car);
    }
    @Override
    public double getSpeed() {
        return car.getSpeed()+13;
    }
    public double getKpl() {
        return car.getKpl()*1.05;
    }
    public double getFuelPrice() {
        return car.getFuelPrice();
    }
    public String getDescription(){
        return car.getDescription()+"American ";
    }
}

package CarSub.Manufacturer;

import CarSub.CarDecorator;
import ConcreteObjects.Car;

public class Europe extends CarDecorator {

    public Europe(Car car) {
        super(car);
    }
    @Override
    public double getSpeed() {
        return car.getSpeed()+10;
    }
    public double getKpl() {
        return car.getKpl()*0.95;
    }
    public double getFuelPrice() {
        return car.getFuelPrice();
    }
    public String getDescription(){
        return car.getDescription()+"Europe ";
    }
}

package CarSub.Klass;

import CarSub.CarDecorator;
import ConcreteObjects.Car;

public class Business extends CarDecorator {

    public Business(Car car) {
        super(car);
    }
    @Override
    public double getSpeed() {
        return car.getSpeed()+15;
    }
    public double getKpl() {
        return car.getKpl()*0.95;
    }
    public double getFuelPrice() {
        return car.getFuelPrice()+20;
    }
    public String getDescription(){
        return car.getDescription()+" Business class";
    }
}

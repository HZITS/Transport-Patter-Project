import ConcreteObjects.Car;
import ConcreteObjects.Plane;

public class Transport {
    String name;
    Car car;
    Plane plane;

    public Transport(Car car, Plane plane) {
        this.car = car;
        this.plane = plane;
    }

    public String getDescription(){
        if(plane==null){
            return car.getDescription();
        }else return plane.getDescription();
    }
}

package PlaneSub.Klass;

import ConcreteObjects.Plane;
import PlaneSub.PlaneDecorator;

public class Business extends PlaneDecorator {
    public Business(Plane plane) {
        super(plane);
    }
    @Override
    public double getSpeed() {
        return plane.getSpeed();
    }
    public double getBaggage() {
        return plane.getBaggage()*4;
    }

    public String getDescription(){
        return plane.getDescription()+" Business class";
    }
}


package PlaneSub.Klass;

import ConcreteObjects.Plane;
import PlaneSub.PlaneDecorator;

public class Economy extends PlaneDecorator {
    public Economy(Plane plane) {
        super(plane);
    }
    @Override
    public double getSpeed() {
        return plane.getSpeed();
    }
    public double getBaggage() {
        return plane.getBaggage()*2;
    }

    public String getDescription(){
        return plane.getDescription()+" Economy class";
    }
}
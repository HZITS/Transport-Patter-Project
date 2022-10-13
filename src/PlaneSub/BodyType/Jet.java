package PlaneSub.BodyType;

import ConcreteObjects.Plane;
import PlaneSub.PlaneDecorator;

public class Jet extends PlaneDecorator {
    public Jet(Plane plane) {
        super(plane);
    }
    @Override
    public double getSpeed() {
        return plane.getSpeed()+560;
    }
    public double getBaggage() {
        return plane.getBaggage()+22;
    }
    public String getDescription(){
        return plane.getDescription()+" with body type Jet";
    }
}


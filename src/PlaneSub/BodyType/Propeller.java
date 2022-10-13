package PlaneSub.BodyType;

import ConcreteObjects.Plane;
import PlaneSub.PlaneDecorator;

public class Propeller extends PlaneDecorator {
    public Propeller(Plane plane) {
        super(plane);
    }
    @Override
    public double getSpeed() {
        return plane.getSpeed()-90;
    }
    public double getBaggage() {
        return plane.getBaggage()+200;
    }
    public String getDescription(){
        return plane.getDescription()+" with body type Propeller";
    }
}
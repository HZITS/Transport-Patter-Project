package Strategy;

import ConcreteObjects.Plane;

public class PlaneDisplacement implements DisplacementStrategy {
    Plane plane = new Plane();
    @Override
    public double displacement(double distance){
        return (distance/plane.getSpeed());
    }
}

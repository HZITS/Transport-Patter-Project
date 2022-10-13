package PlaneSub;

import ConcreteObjects.Plane;

public class PlaneDecorator extends Plane {
    public Plane plane;
    public PlaneDecorator(Plane plane){
        this.plane=plane;
    }

    public PlaneDecorator() {

    }

    public Plane getPlane() {
        return plane;
    }
}

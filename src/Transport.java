import ConcreteObjects.Car;
import ConcreteObjects.Plane;
import Strategy.*;

public class Transport {
    String name;
    Car car;
    Plane plane;
    DisplacementStrategy displacementStrategy;
    MoneyStrategy moneyStrategy;
    private CarDisplacement carDisplacement = new CarDisplacement();
    private CarMoneyCons carMoneyCons = new CarMoneyCons();
    private PlaneDisplacement planeDisplacement = new PlaneDisplacement();
    private PlaneMoneyCons planeMoneyCons = new PlaneMoneyCons();
    public Transport(Car car, Plane plane) {
        setCar(car);
        setPlane(plane);
    }

    public void setDisplacementStrategy(DisplacementStrategy displacementStrategy){
        this.displacementStrategy = displacementStrategy;
    }
    public void setMoneyStrategy(MoneyStrategy moneyStrategy){
        this.moneyStrategy = moneyStrategy;
    }
    public void setCar(Car car){
        this.car = car;
        if(car!=null) {
            carDisplacement.setCar(car);
            setDisplacementStrategy(carDisplacement);
            carMoneyCons.setCar(car);
            setMoneyStrategy(carMoneyCons);
        }
    }
    public void setPlane(Plane plane){
        this.plane = plane;
        if(plane!=null) {
            setDisplacementStrategy(planeDisplacement);
            setMoneyStrategy(planeMoneyCons);
        }
    }
    public double displacement(int distance){return displacementStrategy.displacement(distance);}
    public double money(int distance){return moneyStrategy.money(distance);}
    public String getDescription(){
        if(plane==null){
            return car.getDescription();
        }else return plane.getDescription();
    }
}

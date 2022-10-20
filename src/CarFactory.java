import CarSub.BodyType.*;
import CarSub.FuelType.*;
import ConcreteObjects.Car;

import java.util.Scanner;

public class CarFactory extends TransportFactory{

    public static Car startFactory(){
        Car car;
        System.out.println("Choose body type of car");
        car = carBodyTypes();
        System.out.println("Choose fuel type of car");
        car = carFuelTypes(car);
        return car;
    }

    private static Car carFuelTypes(Car car) {
        System.out.println("1) Petrol");
        System.out.println("2) Diesel");
        System.out.println("3) Electric");
        System.out.println("4) Hybrid");
        System.out.println("5) NaturalGas");
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        while (type<1 || type>5){
            System.out.println("Please type number between 1 and 5");
            System.out.println("1) Petrol");
            System.out.println("2) Diesel");
            System.out.println("3) Electric");
            System.out.println("4) Hybrid");
            System.out.println("5) NaturalGas");
            type=sc.nextInt();
        }
        return carFuelType(type,car);
    }

    private static Car carFuelType(int type,Car car){
        if(type==1) return new Petrol(car);
        else if(type==2) return new Diesel(car);
        else if(type==3) return new Electric(car);
        else if(type==4) return new Hybrid(car);
        else if(type==5) return new NaturalGas(car);
        else return null;
    }

    private static Car carBodyTypes() {
        System.out.println("1) Sedan");
        System.out.println("2) Hatchback");
        System.out.println("3) SUV");
        System.out.println("4) Sport");
        System.out.println("5) Super");
        System.out.println("6) Minivan");
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        while (type<1 || type>6){
            System.out.println("Please type number between 1 and 6");
            System.out.println("1) Sedan");
            System.out.println("2) Hatchback");
            System.out.println("3) SUV");
            System.out.println("4) Sport");
            System.out.println("5) Super");
            System.out.println("6) Minivan");
            type=sc.nextInt();
        }
        return carBodyType(type);
    }

    private static Car carBodyType(int type){
        if(type==1) return new Sedan(new Car());
        else if(type==2) return new Hatchback(new Car());
        else if(type==3) return new SUV(new Car());
        else if(type==4) return new Sport(new Car());
        else if(type==5) return new Super(new Car());
        else if(type==6) return new Minivan(new Car());
        else return null;
    }

}
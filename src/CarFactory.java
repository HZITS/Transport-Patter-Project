import ConcreteObjects.Car;

import java.util.Scanner;

public class CarFactory extends TransportFactory{
    public static Car createCar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Would you like to customize or straight to the point:");
        System.out.println("1. Yes");
        System.out.println("2. No");

        System.out.print("\nEnter option (1-2): ");
        Car car = null;
        int option = sc.nextInt();
        switch (option) {
            case 1:
                car = startFactory();
                break;
            case 2:
                break;
            default:
                System.out.println("\nInput number invalid");
                break;
        }
        return car;
    }
        private static Car startFactory(){
            System.out.println("Choose body type of car");
            carBodyTypes();
            System.out.println("Choose fuel type of car");
            carFuelTypes();
            System.out.println("Choose free or toll road");
            carTollRoad();
            System.out.println("Choose with driver or without");
            carDriver();
            return new Car();
        }

    private static void carTollRoad() {
    }

    private static void carFuelTypes() {
    }

    private static void carBodyTypes() {
        
    }
    private static void carDriver(){

    }

}


import ConcreteObjects.Plane;
import PlaneSub.BodyType.Biplane;
import PlaneSub.BodyType.Jet;
import PlaneSub.BodyType.Propeller;
import PlaneSub.Klass.Business;
import PlaneSub.Klass.Economy;
import PlaneSub.Klass.Luxury;

import java.util.Scanner;

public class PlaneFactory extends TransportFactory {
    public static Plane createPlane() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Would you like to customize or straight to the point:");
        System.out.println("1. Yes");
        System.out.println("2. No");

        System.out.print("\nEnter option (1-2): ");
        Plane plane = null;
        int option = sc.nextInt();
        switch (option) {
            case 1:
                plane = startFactory();
                break;
            case 2:

                break;
            default:
                System.out.println("\nInput number invalid");
                break;
        }
        return plane;
    }
    private static Plane startFactory(){
        System.out.println("Choose body type of plane");
        planeBodyTypes();
        System.out.println("Choose fuel type of car");
        PlaneKlasses();

        return new Plane();
    }



    private static Plane planeBodyTypes() {
        System.out.println("Enter number:");
        System.out.println("1) Default");
        System.out.println("2) Biplane");
        System.out.println("3) Jet");
        System.out.println("4) Propeller");
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        while (type<1 && type>4){
            System.out.println("Please type number between 1 and 4");
            System.out.println("1) Default");
            System.out.println("2) Biplane");
            System.out.println("3) Jet");
            System.out.println("4) Propeller");
            type=sc.nextInt();
        }
        return PlaneBodyType(type);

    }
    private static Plane PlaneBodyType(int type){
        if(type==1) return new Plane();
        else if(type==2) return new Biplane(new Plane());
        else if(type==3) return new Jet(new Plane());
        else if(type==4) return new Propeller(new Plane());
        else return null;
    }
    private static Plane PlaneKlasses() {
        System.out.println("Enter number:");
        System.out.println("1) Default");
        System.out.println("2) Economy");
        System.out.println("3) Business");
        System.out.println("4) Luxury");
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        while (type<1 && type>4){
            System.out.println("Please type number between 1 and 4");
            System.out.println("1) Default");
            System.out.println("2) Economy");
            System.out.println("3) Business");
            System.out.println("4) Luxury");
            type=sc.nextInt();
        }
        return PlaneKlass(type);

    }
    private static Plane PlaneKlass(int type){
        if(type==1) return new Plane();
        else if(type==2) return new Economy(new Plane());
        else if(type==3) return new Business(new Plane());
        else if(type==4) return new Luxury(new Plane());
        else return null;
    }
}
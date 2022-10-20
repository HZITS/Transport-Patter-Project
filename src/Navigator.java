import java.util.Scanner;

public class Navigator {
    Scanner sc = new Scanner(System.in);
    TransportFactory tf = new TransportFactory();
    Transport transport;

    public void qwerty(){
        System.out.println("");
        System.out.println("1. Customize");
        System.out.println("2. Choose option(cheapest or fastest)");
        int option = sc.nextInt();
        if(option==1){
            transport = customize();
            System.out.println(transport.getDescription());
        }else{
            System.out.println("Choose option:");
            System.out.println("1. Cheapest");
            System.out.println("2. Fastest");
            option = sc.nextInt();
            if(option==1) cheapTrip();
            else fastTrip();
        }
    }

    public Transport customize(){
        whileStatement:
        while (true) {
            System.out.println("\nWould you like to travel by a plane or a car?\n");
            System.out.println("1. Plane");
            System.out.println("2. Car");
            System.out.println("0. Exit");

            System.out.print("\nEnter option (1-2): ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    return tf.createTransport(false);
                case 2:
                    return tf.createTransport(true);
                case 0:
                    System.out.println("\nAuf viedersehn!");
                    break whileStatement;
                default:
                    System.out.println("\nInput number invalid");
                    break;
            }
        }
        return null;
    }
    public void cheapTrip(){

    }
    public void fastTrip(){

    }
}

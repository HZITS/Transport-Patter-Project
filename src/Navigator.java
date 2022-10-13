import java.util.Scanner;

public class Navigator {
    Scanner sc = new Scanner(System.in);
    TransportFactory tf = new TransportFactory();

    public void start(){
        Transport transport = null;
        whileStatement:
        while (true) {
            System.out.println("\nWelcome to 3Gis!\nWould you like to travel by a plane or a car?\n");
            System.out.println("1. Plane");
            System.out.println("2. Car");
            System.out.println("0. Exit");

            System.out.print("\nEnter option (1-2): ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    transport = tf.createTransport(false);
                    break;
                case 2:
                    transport = tf.createTransport(true);
                    break;
                case 0:
                    System.out.println("\nAuf viedersehn!");
                    break whileStatement;
                default:
                    System.out.println("\nInput number invalid");
                    break;
            }
        }
    }
}

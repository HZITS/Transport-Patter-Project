import DataBase.DB;

import java.util.Scanner;

public class Program {
    DB db = DB.getInstance();
    Navigator navigator = new Navigator();
    public void start(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nWelcome to 3Gis!");
        System.out.println("Please verify or create an account");
        System.out.println("1.Login");
        System.out.println("2.Create");
        int option=sc.nextInt();
//        Transport transport;
        if(option==1) {
            System.out.println("My friend you are admin or user?");
            System.out.println("1 for admins");
            System.out.println("2 for users");
            option = sc.nextInt();
            if (option == 1) {
                if (db.login_admin()) {
                    while (option!=7) {
                        System.out.println("My friend what do you want to do");
                        System.out.println("Do you want to see other people? press 1");
                        System.out.println("Is there particular person you want to find press 2");
                        System.out.println("Do you want to kill user press 3");
                        System.out.println("DO you want to ban user for saying N word press 4");
                        System.out.println("Do you want to unban user? press 5");
                        System.out.println("Do you want to restore user? press 6");
                        System.out.println("If you want to exit press 7");
                        option = sc.nextInt();
                        String name;
                        int id;
                        switch (option) {
                            case 1:
                                db.get_users();
                                break;
                            case 2:
                                name = sc.nextLine();
                                name = sc.nextLine();
                                db.get_users_by_name(name);
                                break;
                            case 3:
                                System.out.print("Enter id of user: ");
                                id = sc.nextInt();
                                db.deleteUser(id);
                                break;
                            case 4:
                                System.out.print("Enter id of user: ");
                                id = sc.nextInt();
                                db.banUser(id);
                                break;
                            case 5:
                                System.out.print("Enter id of user: ");
                                id = sc.nextInt();
                                db.unBanUser(id);
                                break;
                            case 6:
                                System.out.print("Enter id of user: ");
                                id = sc.nextInt();
                                db.restoreUser(id);
                                break;
                            default:
//                                System.out.println("\nInput number invalid");
                                break;
                        }
                    }
                }
            } else if (option == 2) {
                if (db.login_user()) {
                    logined_user();
/*                transport = navigator.customize();
                if(transport.car!=null){
                    System.out.println(transport.car.getDescription());
                }else{
                    System.out.println(transport.plane.getDescription());
                }*/
                }

            } else if (option == 2){
                if(db.create_user()){
                    logined_user();
                }
            }
        }
    }
    private void logined_user(){
        Scanner sc = new Scanner(System.in);
        String A, B;
        int[] distance = new int[5];
        System.out.println("All cities: Almaty, Astana, Shymkent, Aktobe, Karaganda, Taraz, Pavlodar, Ust-kamenogorsk, Semey, Atyrau, Kyzylorda, Kostanai, Uralsk, Aktau.");
        System.out.println("Destination point A");
//        A = sc.nextLine();
        A = sc.nextLine();
        System.out.println("Destination point B");
        B = sc.nextLine();
        System.out.println(A + " | " + B);
        distance[1] = db.routes(A, B);
        System.out.println("Distance is " + distance[1] + " km");
        navigator.qwerty(A, B, distance[1]);
    }
}

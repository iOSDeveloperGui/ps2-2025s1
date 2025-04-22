import java.util.Scanner;

public class Main{

    //MARK: Instances
    private static TheaterSystem theater = new TheaterSystem();
    private static Scanner scanner = new Scanner(System.in);

    //MARK: Main
    public static void main(String[]args){

        //MARK: Showing Menu
        int option = 0;
        while(option != 4){
            System.out.print(
                """
                ==============================================
                            *** MACK THEATHER ***
                ==============================================
                1) Register show
                2) Register client
                3) Purchase of tickets
                4) Exit
                ============================================== 
                """
            );
            System.out.print("---> Select an option: ");

            // MARK: Getting the chosen option 
            option = scanner.nextInt();
            
            switch(option){
                case 1: {
                    registerShow();
                    break;
                }
                case 2:{
                    registerClient();
                    break;
                }
                case 3:{
                    theater.purchaseTickets();
                    break;
                }
                case 4:{
                    exitProgram();
                    break;
                }

            }
        }

    }

    //MARK: MethodRegisterShow
    public static void registerShow(){
        Scanner sc = new Scanner(System.in); 
        //MARK: Showing Menu
        System.out.println("""
        ==============================================
                    *** SHOW REGISTRATION ***
        ==============================================
        """);

        System.out.print("Show name: ");
        String name = sc.nextLine();
        
        System.out.print("Insert the date (dd/MM/yyyy): ");
        String date = sc.nextLine();

        System.out.print("Time (hh:mm): ");
        String time = sc.nextLine();

        System.out.print("Insert the full price: ");
        Double price = sc.nextDouble();
        scanner.nextLine();

        //MARK: Creating a object and adding in ArrayList
        Show show = new Show(name, date, time, price);
        theater.addShow(show);
        
        //MARK: Registered with successful
        System.out.println();
        System.out.println("Registered with successful :) ");
        System.out.println();
        System.out.println(">>> Returning to the main menu <<<");
    }

    //MARK: MethodRegisterClient
    public static void registerClient(){
        
        //MARK: Showing Menu
        System.out.println("""
        ==============================================
                *** COSTUMER REGISTRATION ***
        ==============================================
        """);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        
        System.out.print("Enter your ID: ");
        String id = scanner.nextLine();
        //String condition = (id < 12) ? "Enter a able ID: " : costumer.getId();

        //MARK: Creating a object and adding in ArrayList
        Costumer costumer = new Costumer(name, id);
        theater.addCostumer(costumer);

        //MARK: Registered with successful
        System.out.println();
        System.out.println(" Registered with successful :) ");
        System.out.println();
        System.out.println(" >>> Return to the main menu <<<");
    
    }


    //MARK: MethodExit
    public static void exitProgram() {
        System.out.println("""
                ==============================================
                            Project developed by: 
                
                          Guilherme Silva Dias - 10427415
                                 Class: 02J12
                           
                ==============================================
                """);
    }
    

}
/* 
                    Project developed by: 
                Guilherme Silva Dias - 10427415
*/
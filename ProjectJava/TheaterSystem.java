import java.util.ArrayList;
import java.util.Scanner;

public class TheaterSystem{
    
    //MARK: Atributes
    private Order cart = null;
    private Show selectedShow = null;

    //MARK: ArrayList & references 
    private ArrayList<Costumer> costumers;
    private ArrayList<Show> shows;
    Scanner scanner = new Scanner(System.in);


    //MARK: Constructor
    public TheaterSystem(){
        shows = new ArrayList<>();
        costumers = new ArrayList<>();
    }
    
    //MARK: MethodNewPurchase 
    public void newPurchase(){
        this.cart = new Order();
    }

    //MARK: MethodPresentsShow
    public void presentsShow(Show show){
        this.selectedShow = show;
    }

    //MARK: MethodSelectShow
    public Show selectShow(int number){
        return selectedShow;
    }

    //MARK: MethodNewTicket
    public void newTicket(int type, int seatNumber){
        Ticket ticket = selectedShow.newTicket(type, seatNumber);
        cart.addTicket(ticket);
    }

    //MARK: MethodFinalizePurchase
    public double finalizePurchase(String id){
        System.out.println("Purchase finalised for CPF: " + id);
        return (cart.calculateTotal());
    }

    //MARK: MethodAddShow
    public void addShow(Show show){
        this.shows.add(show);
    }

    //MARK: MethodAddCostumer 
    public void addCostumer(Costumer costumer){
        this.costumers.add(costumer);
    }

    //MARK: Getters
    public ArrayList<Show> getShows(){
        return this.shows;
    }

    public ArrayList<Costumer> getCostumers(){
        return this.costumers;
    }

    //MARK: Validating the costumers
    public Costumer findCostumerByID(String id){
        for (Costumer costumer : costumers){
            if(costumer.getId().equals(id)){
                return costumer;
            }
        }
        return null;
    }

    //MARK: MethodPurchaseTickets
    public void purchaseTickets(){

        //MARK: Header 
        System.out.println("""
            ==============================================
                    *** TICKET SALES - SHOWS ***
            ==============================================
            """
        );

        //MARK: Condionational If shows is empty
        if(shows.isEmpty() || costumers.isEmpty()){
            System.out.println("First of all, you must register a new Show. Afterward, you need to have a register to access the system. Try Again afterward! :)");
            return;
        }

        //MARK: Initializing a new order 
        newPurchase();

        //MARK: Getting all shows and incrementing the index
        for(int i = 0; i < shows.size(); i++){
            Show s = shows.get(i);
            System.out.printf("%d) %s %s %s R$ %.2f\n", 
            i + 1, s.getName(), s.getDate(), s.getHour(), s.getPrice());
        }

        //MARK: Getting the chosen option
        System.out.print("Select a show: ");
        int showIndex = scanner.nextInt() -1;

        //MARK: Validating the input show 
        if(showIndex < 0 || showIndex >= shows.size()){
            System.out.println("Invalid Option! >>> Returning to the main menu <<<");
            return; 
        }
        
        //MARK: Getting the show 
        selectedShow = shows.get(showIndex);
        presentsShow(selectedShow);
        
        //MARK: Process seat selection and ticket purchase
        boolean buyMore = true;
        while(buyMore){
            
            //MARK: Showing the available seats
            System.out.println();
            System.out.println("    ||| Available Seats ||| ");
            selectedShow.displaySeats();
            
            //MARK: Geeting the seat
            System.out.print("Select a seat (1-50): ");
            int seatNumber = scanner.nextInt();
            
            //MARK: marking the seat as occupied
            selectedShow.markSeat(seatNumber - 1);
            System.out.println("Seat successfully booked!");
            System.out.println();

            //MARK: Asking for tickets type
            System.out.println();
            System.out.println("    ||| Types of entry |||  ");
            System.out.println("1) Full");
            System.out.println("2) Half ----> 50% Of the amount of the entry");
            System.out.println("3) Teacher ----> 40% Of the amount of the entry");
            System.out.println();
            System.out.print("Select a type of entry: ");
            int ticketType = scanner.nextInt();

            //MARK: Creating the ticket to the cart
            Ticket ticket = selectedShow.newTicket(ticketType, seatNumber);
            cart.addTicket(ticket);

            System.out.print("Do you want to buy another entrance (Y/N)? ");
            String answer = scanner.next().toUpperCase();
            buyMore = answer.equals("Y");     
        }
        
        System.out.println();
        System.out.print("Enter the ID of the Registered costumer: ");
        String costumerID = scanner.next();

        Costumer costumer = findCostumerByID(costumerID);
        
        if(costumer == null){
            System.out.println("Customer not found. Please register first.");
            return;
        }
        
        //MARK: Proceed with finalizing the purchase
        double total = finalizePurchase(costumerID);
        System.out.printf("Total value: R$ %.2f\n", total);
        System.out.println(">>> Returning to the main menu <<<");
        
    }



}

/* 
                    Project developed by: 
                Guilherme Silva Dias - 10427415
*/

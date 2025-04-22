public class Show{
    
    //MARK: References
    Ticket ticket;

    //MARK: Atributes
    private String name;
    private String date;
    private String hour;
    private double price;
    private boolean[] seats = new boolean[50];
    
    
    //MARK: Constructor
    public Show(String name, String date, String hour, double price){
        this.name = name;
        this.date = date;
        this.hour = hour;
        this.price = price;
        
    }

    //MARK: MethodDisplaySeats
    public void displaySeats(){
        for(int i = 0; i < seats.length; i++){
            System.out.print((seats[i]) ? "XX " : (i + 1) + " ");
            if((i + 1) % 10 == 0){ // Adds line break every 10 seats
                System.out.println();
            }
        }
    }
    
    //MARK: MethodNewTicket
    public Ticket newTicket(int type, int seatNumber){
        switch (type){
            case 1:
                return new FullTicket(seatNumber, this);
            case 2:
                return new HalfTicket(seatNumber, this);
            case 3:
                return new TeacherTicket(seatNumber, this);
            default:
                return null;
        }
    }
    
    //MARK: Getters
    public String getName(){
        return this.name;
    }
    
    public String getDate(){
        return this.date;
    }

    public String getHour(){
        return this.hour;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    @Override
    public String toString() {
        return String.format("Show: %s, Date: %s, Hour: %s, Price: R$ %.2f", name, date, hour, price);
    }

    //MARK: MethodIsSeatAvailable
    public boolean isSeatAvailable(int seatNumber){
        if(seats[seatNumber]){
            System.out.println("Seat already taken! Choose another! try again :) ");
            return false;
        }
        return true;
    }

    //MARK: MethodMarkSeat
    public void markSeat(int seatIndex){
        seats[seatIndex] = true;
    }


    
}

/* 
                    Project developed by: 
                Guilherme Silva Dias - 10427415
*/

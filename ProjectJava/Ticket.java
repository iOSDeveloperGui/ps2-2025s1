public abstract class Ticket {
    
    //MARK: Atribute
    private int seatNumber;
    private Show show;

    //MARK: Constructor
    public Ticket(int seatNumber, Show show){
        this.seatNumber = seatNumber;
        this.show = show;
    }
    
    //MARK: Methods
    public abstract double calculateValue();

    //MARK: MethodGetShow
    public Show getShow(){
        return this.show;
    }
}


/* 
                    Project developed by: 
                Guilherme Silva Dias - 10427415
*/

public class FullTicket extends Ticket{

    //MARK: Constructor
    public FullTicket(int seatNumber, Show show){
        super(seatNumber, show);
    }
    
    //MARK: Methods
    @Override
    public double calculateValue(){
        return (getShow().getPrice());
    }
}

/* 
                    Project developed by: 
                Guilherme Silva Dias - 10427415
*/

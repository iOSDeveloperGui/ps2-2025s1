
public class HalfTicket extends Ticket{

    //MARK: Constructor
    public HalfTicket(int seatNumber, Show show){
        super(seatNumber, show);
        
    }
    
    //MARK: MethodCalculateValue
    @Override
    public double calculateValue(){
        return (getShow().getPrice() * 0.5);
    }
}

/* 
                    Project developed by: 
                Guilherme Silva Dias - 10427415
*/
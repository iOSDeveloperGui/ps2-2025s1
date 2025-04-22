public class TeacherTicket extends Ticket{

    //MARK: Constructor
    public TeacherTicket(int seatNumber, Show show){
        super(seatNumber, show);
    }

    //MARK: Methods
    @Override
    public double calculateValue(){
        return (getShow().getPrice() * 0.6);
    }
}

/* 
                    Project developed by: 
                Guilherme Silva Dias - 10427415
*/

import java.util.ArrayList;

public class Order{
    
    //MARK: ArrayList
    private ArrayList<Ticket> tickets = new ArrayList<>();

    //MARK: Constructor
    public Order(){}

    //MARK: MethodAddTicket
    public void addTicket(Ticket ticket){ 
        tickets.add(ticket);
    }   

    //MARK: MethodCalculateTotal
    public double calculateTotal(){ 
        double totalValue = 0;
        for(Ticket ticket : tickets){
            totalValue += ticket.calculateValue();
        }
        return totalValue;
    }
}

/* 
                    Project developed by: 
                Guilherme Silva Dias - 10427415
*/

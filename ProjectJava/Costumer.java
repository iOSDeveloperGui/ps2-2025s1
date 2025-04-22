public class Costumer{
    
    // MARK: Atributes
    private String name;
    private String id;

    // MARK: Constructor
    public Costumer(String name, String id){
        this.name = name;
        this.id = id;
    }

    // MARK: MethodAddOrder
    public void addOrder(Order order){
        System.out.println("Order added to costumer: " + name);
    }

    // MARK: Getters
    public String getName(){
        return this.name;
    }

    public String getId(){
        return this.id;
    }

    public String toString(){
        return "*** COSTUMER REGISTERED ***" +
               "Costumer name: " + this.name +
               "ID: " + this.id +
               ">>> Returns to the main menu <<<";
    }

}

/* 
                    Project developed by: 
                Guilherme Silva Dias - 10427415
*/
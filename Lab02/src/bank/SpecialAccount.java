package bank;

public class SpecialAccount extends Account{

    //MARK: - Atributes
    private double limit;

    //MARK: - Constructor
    public SpecialAccount(int n, double s, double lim){
        super(n,s);
        limit = lim;
    }
    
    //MARK: - Functions
    @Override
    public void deposit(double amount){
        balance = balance + amount * 1.1;
    }

    @Override
    public boolean sacar(double amount){
        if(amount <= balance + limit){
            balance -= amount;
            return true;
        }
        return false;
    }

    public void increase(double amount){
        limit += amount; 
    }
}
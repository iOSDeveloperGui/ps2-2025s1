package bank;

public class InfiniteAccount extends Account{
    //MARK: - Constructor
    public InfiniteAccount(int n, double s){
        super(n,s);
    }

    //MARK: - Functions
    @Override
    public void deposit(double amount){
        balance += amount; 
    }

    @Override
    public boolean sacar(double amount){
        balance -= amount;
        return true;
    }
}
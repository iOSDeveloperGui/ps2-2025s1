package bank;

public class BankAccount extends Account{
    
    //MARK: - Constructor
    public BankAccount(int n, double s){
        super(n,s);
    }

    //MARK: - Functions
    @Override
    public void deposit(double amount){
        balance += amount;
    }

    @Override
    public boolean sacar(double amount){
        if(amount <= balance){
            balance -= amount;
            return true;
        }
        return false; 
    }

}
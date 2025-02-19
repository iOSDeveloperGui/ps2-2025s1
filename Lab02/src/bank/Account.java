package bank;

public abstract class Account{
    
    //MARK: - Atributes
    private int number;
    protected double balance;

    //MARK: - Constructor
    public Account(int n, double s){
        this.number = n;
        this.balance = s;
    }

    //MARK: - Functions
    public double getBalance(){
        return balance;
    }
    
    public abstract void deposit(double amount);
    public abstract boolean sacar(double amount);

    //MARK: - FunctionToString
    public String toString(){
        return String.format("[%s,%s]", number, balance);
    }
    
    
    
}
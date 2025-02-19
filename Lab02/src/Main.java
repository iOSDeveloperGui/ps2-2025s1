import bank.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Account[] accounts = {
            new InfiniteAccount(1111, 50),
            new BankAccount(2222, 99),
            new BankAccount(3333, 1000),
            new SpecialAccount(4444, 800, 200)};
        
        for(int i = 0; i < accounts.length; i++){
            accounts[i].deposit(10);
            accounts[i].sacar(900);
            System.err.print(accounts[i]);
        }
    }
}

import java.util.*;
import static java.lang.System.out;

public class Ihm{
    
    private GerenciadorNomes gerenciador;
    private Scanner scanner = new Scanner(System.in);
    public Ihm(GerenciadorNomes g){
        gerenciador = g;
    }

    public void dialogar(){
        boolean exit = false;
        while(!exit){
            out.println(" **** Main Menu: ****");
            out.println("(1) List Names");
            out.println("(2) Add Name");
            out.println("(3) Exit");
            out.println("Pick a option");
            String op = scanner.nextLine();
            switch (op) {
                case "1":
                showNames();
                    break;
                case "2":
                addName();
                break;
                case "3":
                exit = true;
                break;
                default:
                    break;
            }
        }
        out.println("End of the Program! :)");
    }
    
    private void showNames(){
        List<String> names = gerenciador.getNames();
        out.println("Names: ");
        for(String name: names){
            out.println(name);
        }
    }

    private void addName(){
        out.println("Adding a name");
        String newName = scanner.nextLine();
        gerenciador.addName(newName);
    }


}
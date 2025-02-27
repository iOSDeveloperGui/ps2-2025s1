import java.util.List;

public interface GerenciadorNomes{
    int MAX_CARACTERES_NAMES = 20;
    
    List<String> getNames();

    void addName(String name);

    
}
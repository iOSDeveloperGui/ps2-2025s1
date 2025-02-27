import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class GerenciadorNomesFile implements GerenciadorNomes{

    @Override
    public List<String> getNames(){
        Path path = Paths.get("names.txt");    
        try{
            List<String> strings = Files.readAllLines(path);
            return strings;

        } catch(IOException exception){
            System.out.println("Error!");
        }
        return null;
    }

    @Override
    public void addName(String name) {
        Path filePath = Paths.get("names.txt");
        try{
            Files.writeString(filePath, name + System.lineSeparator(),
            StandardOpenOption.APPEND);
        } catch(IOException exception){
        }
    }
    
}

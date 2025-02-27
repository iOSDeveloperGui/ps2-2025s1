import java.util.*;

public class GerenciadorNomesMem implements GerenciadorNomes{

    private List<String> names = new ArrayList<String>();

    @Override
    public List<String> getNames(){
        return names;
    }

    @Override
    public void addName(String name){
        names.add(name);
    }
}

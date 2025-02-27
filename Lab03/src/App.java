public class App {
    public static void main(String[] args) throws Exception {
        GerenciadorNomes gNames = new GerenciadorNomesFile();
        Ihm ihm = new Ihm(gNames);
        ihm.dialogar();
    }
}

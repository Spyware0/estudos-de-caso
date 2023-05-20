package estudoDeCaso2.main;
import estudoDeCaso2.LeilaoVirtual.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Limpa a tela no windows, no linux e no MacOS
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");

        
        Leilao leilao = new Leilao();
        Interface inter = new Interface(leilao);
        inter.iniciar();
    }
}

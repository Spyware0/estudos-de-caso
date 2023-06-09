package TesteCaixaEletronico;
import gestoes.*;
import java.io.IOException;

public class TesteCaixaEletronico {
    public static void main(String[] args) throws IOException, InterruptedException {

        //limpar console
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
        //
        

        Cliente gabriel = new Cliente("02468", "Gabriel Luis");
        Cliente willian = new Cliente("13579", "Willian Walace");
        
        Conta contag = new Conta(1, gabriel, 12345, 3000);
        Conta contaw = new Conta(2, willian, 54321, 1000);
        
        CadastroContas cadastro = new CadastroContas(2);

        cadastro.adicionaConta(contaw);
        cadastro.adicionaConta(contag);

        Terminal meuTerm = new Terminal(cadastro);
        meuTerm.iniciaOperacao();
    }
    
}

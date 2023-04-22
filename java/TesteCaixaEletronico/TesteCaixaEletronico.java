package TesteCaixaEletronico;
import com.mycompany.conta.*;

public class TesteCaixaEletronico {
    public static void main(String[] args){
        Cliente gabriel = new Cliente("02468", "Gabriel Luis");
        Cliente willian = new Cliente("13579", "Willian Walace");
        
        Conta contag = new Conta(1, gabriel, 12345, 2000);
        Conta contaw = new Conta(2, willian, 54321, 1500);
        
        CadastroContas cadastro = new CadastroContas(2);
        
    }
    
}

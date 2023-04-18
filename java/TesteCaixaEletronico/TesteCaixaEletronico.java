package TesteCaixaEletronico;
import com.mycompany.conta.*;

public class TesteCaixaEletronico {
    public static void main(String[] args){
        Cliente gabriel = new Cliente("623.381.673-41", "Gabriel Luis Dantas Matos");
        Cliente willian = new Cliente("710.131.264-08", "Willian Walace Silva Cutrim");
        
        Conta contag = new Conta(1, gabriel, 12345, 2000);
        Conta contaw = new Conta(2, willian, 54321, 1500);
        
        CadastroContas cadastro = new CadastroContas(2);
        
    }
    
}

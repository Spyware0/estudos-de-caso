package estudoDeCaso2.LeilaoVirtual;
import java.util.Scanner;

public class Interface {
    private Leilao leilao;

    public Interface(Leilao leilao){
        this.leilao = leilao;
    }


    public void iniciar(){
        int opcao = 0;
        while(opcao != 5){
            System.out.println("1 - Adicionar lote\n2 - Lançar lote\n3 - Remover loten\n4 - Sair\n");
            opcao = getInt("a opção >>> ");
        }
    }


    private int getInt(String string) {
        Scanner r = new Scanner(System.in);
        System.out.println("Entre com " + string);
        if (r.hasNextInt()) 
            return r.nextInt();
        
        String st = r.next();
        System.out.println("Erro na Leitura de Dados");
        return 0;
    }
}

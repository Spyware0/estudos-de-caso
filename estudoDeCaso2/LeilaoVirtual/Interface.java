package estudoDeCaso2.LeilaoVirtual;
import java.util.Scanner;

public class Interface {
    private Leilao leilao;

    public Interface(Leilao leilao){
        this.leilao = leilao;
    }

    public void iniciar(){

        String verde = "\033[32m", f = "\033[m", verm = "\033[31m";
        int opcao = 0;
        Scanner str = new Scanner(System.in);
        while(opcao != 5){
            System.out.println("1 - Adicionar lote\n2 - Fazer lance\n3 - Remover lote\n4 - exibir lotes\n5 - Sair\n");
            opcao = getInt("a opção >>> ");
            switch(opcao){
                case 1:
                    System.out.println(this.leilao.adicionaLote(getString("descrição do lote: ")) ? verde + "Lote adicionado" + f: verm + "Lote não adicionado" + f);
                    break;
                case 2:
                    System.out.println(this.leilao.lanceLote(getString("descrição: "), getString("nome: "), (double)getInt("valor: ")));
                    break;
                case 3:
                    System.out.println("Lote removido:\n\n" + this.leilao.removeLote(getInt("número do lote: ")).toString());
                    break;
                case 4:
                    this.leilao.mostraLotes();

            }
        }
        str.close();
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

    private String getString(String texto){
        Scanner str = new Scanner(System.in);
        System.out.println("Entre com " + texto);
        return str.nextLine();
    }
}

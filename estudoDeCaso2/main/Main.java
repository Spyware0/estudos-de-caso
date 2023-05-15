package estudoDeCaso2.main;
import estudoDeCaso2.LeilaoVirtual.*;

public class Main {

    public static void main(String[] args) {
        
        Pessoa p1 = new Pessoa("Gabriel");
        Pessoa p2 = new Pessoa ("kerlyane");
        Pessoa p3 = new Pessoa ("andria");
        
        Leilao leilao = new Leilao();
        leilao.adicionaLote("lote de carros");
        leilao.adicionaLote("lote de barcos");
        
        leilao.lanceLote(0, p3, 600);
        leilao.lanceLote(0, p1, 1000);
        leilao.lanceLote(0, p2, 300);
        
        leilao.close();

        for (Lote lote: leilao.getNaoVendidos()){
            Lote l = leilao.removeLote(lote.getNumero());
            System.out.println(l.toString());
        }

        leilao.close();
    }
}
    

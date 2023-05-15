package estudoDeCaso2.LeilaoVirtual;
import java.util.ArrayList;
import java.util.Iterator;


public class Leilao{
    private ArrayList<Lote> lotes;
    private int numeroProxLote;
    
    public Leilao() {
        this.lotes = new ArrayList<>();
        this.numeroProxLote = 1;
    }

    public void adicionaLote(String descricao) {
        this.lotes.add(new Lote(this.numeroProxLote, descricao));
        this.numeroProxLote++;
    }
    
    public void mostraLotes() {
        Iterator<Lote> it = this.lotes.iterator();
        while (it.hasNext()) {
            Lote lote = it.next();
            System.out.println(lote.getNumero() + ": " + lote.getDescricao());
            Lance melhorLance = lote.getMaiorLance();
            if (melhorLance != null) {
                System.out.println(" Lance:" + melhorLance.getValor());
            } else {
                System.out.println(" (Nenhum Lance)");
            }
        }
    }
    
    public Lote getLote(int numero) {
        if ((numero >= 1) && (numero < this.numeroProxLote)) {
            Lote loteSelecionado = this.lotes.get(numero - 1);
            if (loteSelecionado.getNumero() != numero) {
                System.out.println("Erro!!");
            }
        return loteSelecionado;
        } else {
        System.out.println("Lote numero " + numero + "não existe");
        return null;
        }
    }
    public void lanceLote(int indice, Pessoa p, double valor){
        this.lotes.get(indice).lancePara(p, valor);
    }
    
    public void close(){
        for (Lote lote : this.lotes) {
            Lance lance = lote.getMaiorLance();
            try{
                System.out.println(lote.toString());
                if (lance != null)
                    System.out.println("Lance vendido para " + lance.getLicitante().getNome() + " no valor de " + lance.getValor());
                else
                    System.out.println("nenhum lance no momento");
            }
            catch(IndexOutOfBoundsException ex){
                break;
            }
        }
    }


    public ArrayList<Lote> getNaoVendidos(){
        ArrayList<Lote> naoVendidos = new ArrayList<Lote>();
        
        for (Lote lote : this.lotes) {
            if (!lote.getVendido()) { // obs
                naoVendidos.add(lote);
            }
        }
        
        return naoVendidos; 
     }

    public Lote removeLote(int numero) {
        Lote loteRemovido = null;
        
        Iterator<Lote> iterator = lotes.iterator();
        while (iterator.hasNext()) {
            Lote lote = iterator.next();
            if (lote.getNumero() == numero) {
                loteRemovido = lote;
                iterator.remove();
                break;
            }
        }
        
        return loteRemovido;
    }     
}     

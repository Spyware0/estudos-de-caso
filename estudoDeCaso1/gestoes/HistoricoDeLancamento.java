package gestoes;
public class HistoricoDeLancamento {
    private Lancamento[] lancamentos;
    private int ultimoLancamento;
    
    public HistoricoDeLancamento(int numeroDeLancamentos) {
        this.lancamentos = new Lancamento[numeroDeLancamentos + 1];
    }
    
    public void insereLancamento(Lancamento lancamento) {
        if(this.ultimoLancamento == this.lancamentos.length - 1) {
            for(int i = 0; i < this.lancamentos.length; i++) {
                this.lancamentos[i] = this.lancamentos[i+1];
            }
        }
        else {
            this.ultimoLancamento++;
        }
        this.lancamentos[this.ultimoLancamento] = lancamento;
    }
    
    public String geraHistoricoDeLancamentos() {
        StringBuilder historico = new StringBuilder();
        for (int i = 0; i < this.ultimoLancamento; i++) {
            if (this.lancamentos[i] != null)
                historico.append(this.lancamentos[i].getDescricao()).append(": R$").append(this.lancamentos[i].getValor()).append("\n");
        }
        return historico.toString();
    }

    

}

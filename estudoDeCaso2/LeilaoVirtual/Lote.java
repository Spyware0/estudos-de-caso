package estudoDeCaso2.LeilaoVirtual;

public class Lote {
    private int numero;
    private String descricao;
    private Lance maiorLance;

    public Lote(int numero, String descricao) {
        this.numero = numero;
        this.descricao = descricao;
    }


    public int getNumero() {
        return this.numero;
    }

    public boolean getVendido(){
        if(this.maiorLance != null){
            return true;
        }
        return false;
    }

    public String getDescricao() {
        return this.descricao;
    }


    public Lance getMaiorLance() {
        return this.maiorLance;
    }


    public StringBuilder lancePara(String licitante, double valor) {
        if (this.maiorLance == null || (this.maiorLance.getValor() < valor)) {
            this.setMaiorLance(new Lance(new Pessoa(licitante), valor));
            return new StringBuilder("Seu lance foi o maior registrado no momento");
        }else {
            StringBuilder text = new StringBuilder();
            text.append("Lote no: ").append(this.getNumero()).append("(").append(this.getDescricao()).append(")").append("Atualmente tem um lance de: ").append(this.maiorLance.getValor());
            return text;
        }
    }


    private void setMaiorLance(Lance maiorLance) {
        this.maiorLance = maiorLance;
    }
    
    
    public String toString(){
        return "Número: " + getNumero() + "\nDescrição: " + getDescricao();
    }
}

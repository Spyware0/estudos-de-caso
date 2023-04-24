package gestoes;

public class Caixa {
    private Terminal meuTerminal;
    private CadastroContas bdContas;
    private double saldo;

    public Caixa(Terminal terminal, CadastroContas bd){
        this.meuTerminal = terminal;
        this.bdContas = bd;
    }

    public double consultaSaldo(int numeroDaConta, int senha){
        Conta conta;
        conta = this.bdContas.buscaConta(numeroDaConta);
        if (conta != null)
            return conta.verificaSaldo(senha);
        return -1;
    }

    public boolean efetuaSaque(int numeroDaConta, double valor, int senha){
        if(valor < 0 || (valor%50) != 0 || valor > 500 || valor > this.saldo){
            return false;
        }
        Conta conta = bdContas.buscaConta(numeroDaConta);
        if (conta == null || !conta.debitaValor(valor, senha, "Saque Automatico")){
            return false;
        }

        this.liberaCedulas((int)(valor/50));
        this.saldo -= valor;
        if(this.saldo < 500){
            this.meuTerminal.setModo(0);
        }
        return true;
    }

    public void recarrega(){
        this.saldo = 2000;
        this.meuTerminal.setModo(1);
    }

    private void liberaCedulas(int quantidade){
        while(quantidade-- > 0){
            System.out.println("===/ R$50,00 /===");
        }
    } 

    //
    public boolean depositar(int numeroDaConta, double valor, int senha){
        Conta conta = bdContas.buscaConta(numeroDaConta);
        if (conta == null || !conta.creditaValor(valor, "Depósito")){
            return false;
        }
        this.saldo += valor;
        if(this.saldo < 500){
            this.meuTerminal.setModo(0);
        }
        return true;
    }

    public boolean transferencia(int numeroDaContaEnvia, int numeroDaContaRecebe, double valor, int senha){
        Conta contaEnvia = bdContas.buscaConta(numeroDaContaEnvia);
        Conta contaRecebe = bdContas.buscaConta(numeroDaContaRecebe);

        if (contaEnvia == null || contaRecebe == null || !contaRecebe.creditaValor(valor, "Transferência recebida")){
            return false;
        }

        contaEnvia.debitaValor(valor, senha, "Transferência enviada");
        return true;
    }

    public boolean consultarExtrato(int numeroDaConta, int senha){
        Conta conta = bdContas.buscaConta(numeroDaConta);

        if (conta == null){
            return false;
        }

        for(int i = 0; i < 10; i++)
            if (conta.historico.lancamentos[i] != null)
                System.out.println(conta.historico.lancamentos[i].getDescricao() + ": R$" + conta.historico.lancamentos[i].getValor());
        return true;
    }
}

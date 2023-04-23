package gestoes;
import java.util.Scanner;

public class Terminal {
    private Caixa meuCaixa;
    private int modoAtual;
    
    public Terminal(CadastroContas bd) {
        this.meuCaixa = new Caixa(this, bd);
    }
    
    public void iniciaOperacao() {
        int opcao;
        opcao = this.getOpcao();
        while (opcao != 4) {
            switch (opcao) {
                case 1 :
                    double saldo = this.meuCaixa.consultaSaldo(getInt("Numero da Conta"), getInt("Senha"));
                    if (saldo != -1) {
                        System.out.println("Saldo Atual: " + saldo);
                    }
                    else {
                        System.out.println("Conta/senha inválida");
                    }
                    break;
                case 2:
                    boolean b = this.meuCaixa.efetuaSaque(getInt("Numero da Conta"), (double) getInt("Valor"),getInt("Senha"));
                    if (b) {
                        System.out.println("Retire o dinheiro");
                    }
                    else {
                        System.out.println("Pedido de saque recusado");
                    }
                    break;
                case 3:
                    this.meuCaixa.recarrega();
                    break;
                case 5:
                    boolean bo = this.meuCaixa.depositar(getInt("Numero da Conta"), getInt("Valor") * 1.0,getInt("Senha"));
                    
                    if (bo) {
                        System.out.println("Depósito feito!");
                    }
                    else{
                        System.out.println("Depósito recusado");
                    }

                    break;
           }
           opcao = getOpcao();
        }
    }

    public void setModo(int modo) {
        if (modo == 0 || modo == 1) {
            this.modoAtual = modo;
        }
    }
    
    private int getOpcao() {
        int opcao;
        do {
            if (this.modoAtual == 1) {
                opcao = getInt("Opcao:\n1 - Consulta Saldo\n2 - Saque\n5 - depósito\n4 - Sair");

                if (opcao != 1 & opcao != 2  & opcao != 5 & opcao != 4) {
                    opcao = 0;
                }
        }else {
            opcao = getInt("Opcao:\n3 - Recarrega\n4 - Sair");

            if (opcao != 3 & opcao != 4) {
                opcao = 0;
            }
        }
        } while (opcao == 0);
        return opcao;
    }

    private int getInt(String string) {
        Scanner r = new Scanner(System.in);
        System.out.println("Entre com " + string);
        if (r.hasNextInt()) {
            return r.nextInt();
        }
        String st = r.next();
        System.out.println("Erro na Leitura de Dados");
        r.close();
        return 0;
   }
}

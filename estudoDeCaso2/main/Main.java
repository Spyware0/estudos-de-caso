package com.mycompany.estudodecaso2;
public class Estudodecaso2 {

    public static void main(String[] args) {
        
        Pessoa p1 = new Pessoa("Gabriel");
        Pessoa p2 = new Pessoa ("kerlyane");
        Pessoa p3 = new Pessoa ("andria");
        
        /*
        Lance lance1 = new Lance(p1, 300);
        Lance lance2 = new Lance (p2, 600 );
        Lance lance3 = new Lance (p3, 900);
        */
        
        Leilao leilao = new Leilao();
        leilao.adicionaLote("lote de carros");
        leilao.adicionaLote("lote de barcos");
        
        leilao.lanceLote(0, p3, 600);
        leilao.lanceLote(0, p1, 1000);
        leilao.lanceLote(0, p2, 300);
        
        leilao.close();
        
    }
}
    

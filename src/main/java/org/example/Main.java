package org.example;

public class Main {
    public static void main(String[] args){



        Word w = new Word();
        try {
            w.setWords(".//pt//pt.txt");
        }catch (Exception e){

        }
        w.setAssociated();
        w.setSecret("SecretMessage.txt");
        w.makekey0to44();
        w.countMatch();
        int k = w.biggerCount();
        System.out.println("Chave = "+k);
        for(int i=0;i<w.makekeyx(k).length;i++) {
            System.out.print(w.makekeyx(k)[i]+" ");
        }

        //String a = w.clean();

    }

    public void exemplo(){
        System.out.println("Testes");
    }
}

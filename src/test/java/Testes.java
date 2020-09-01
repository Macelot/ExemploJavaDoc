import org.example.Word;
import org.testng.annotations.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
public class Testes {

    @Test
    public void TestaWord(){
        System.out.println("-------Test Words");
        Word w = new Word();
        try {
            w.setWords(".//pt//pt.txt");
        }catch (Exception e){

        }
        int totalPalabras = w.getWords().size();
        System.out.println("Temos "+totalPalabras);
        assertEquals(totalPalabras,320139);
    }

    @Test
    public void TestSecret(){
        System.out.println("-------Test Secret");
        Word w = new Word();
        w.setSecret("SecretMessage.txt");
        String secret=w.getSecret();
        System.out.println(secret);
    }

    @Test
    public void TestAssociated(){
        System.out.println("-------Test Associated");
        Word w = new Word();
        w.setAssociated();
        Character[] assocciateds=w.getAssociated();
        int p=0;
        for (char associated:assocciateds) {
            System.out.print("p " + p + " ");
            p++;
            System.out.println(associated);
        }
    }

    @Test
    public void TestMakeKey(){
        System.out.println("-------Test makeKey");
        Word w = new Word();
        w.setAssociated();
        String m = w.makeKey(0,"VICCENZO");
        System.out.println(m);
        //WJDDFO.P
        assertEquals(m, "VICCENZO");
    }

    @Test
    public void TestaMakeKey0to5(){
        System.out.println("Testando MakeKey0to5");
        Word palavras = new Word();
        palavras.setAssociated();
        palavras.setSecret("SecretMessage.txt");
        ArrayList<String[]> m = palavras.makekey0to5();
        for (int i=0;i<m.size();i++){
            for(int j=0;j<m.get(i).length;j++){
                System.out.print(m.get(i)[j]+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void TestaMakeKey0to44(){
        System.out.println("Testando MakeKey0to5");
        Word palavras = new Word();
        palavras.setAssociated();
        palavras.setSecret("SecretMessage.txt");
        ArrayList<String[]> m = palavras.makekey0to44();
        for (int i=0;i<m.size();i++){
            System.out.print("key = "+i+" ");
            for(int j=0;j<m.get(i).length;j++){
                System.out.print(m.get(i)[j]+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void testaCountMatch(){
        System.out.println("Testando Contadores");
        Word w = new Word();
        w.setAssociated();
        w.setSecret("SecretMessage.txt");
        try {
            w.setWords(".//pt//pt.txt");
        }catch (Exception e){

        }
        w.makekey0to44();
        int[] ts = w.countMatch();
        for(int i=0;i<ts.length;i++){
            System.out.println("Ts "+i+" "+ts[i]);
        }
        int k = w.biggerCount();
        System.out.println("Chave = "+k);
        for(int i=0;i<w.makekeyx(k).length;i++) {
            System.out.print(w.makekeyx(k)[i]+" ");
        }
    }

    @Test
    public void finalTest(){
        System.out.println("-------Test");
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
    }
}

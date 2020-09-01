package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Word {

    private ArrayList<String> words;//dicionario com as 320139
    private String secret;//frase secreta

    private Character[] associated;
    private ArrayList<String[]> secretsWords;

    private String[] decrypt;
    private String special="#";
    private int sizeAlfa=44;

    private int[] ts;

    /**
     *  Construtor da Classe Word
     *  <p>Este construtor não faz nada é apenas para exemplo...
     *  Agora vamos fazer um exemplo de link, desejamos lincar a classe 'Main' no método exemplo: {@link Main#exemplo()}.</p>
     * @author Marcelo Telles
     * @version 1.0
     */
    public  Word(){

    }

    /**
     *  Método atribuir valor em words
     *  <p>Este método carrega o arquivo definido no parâmetro e seta nosso ArrayList words com as palavras do arquivo, este é nosso dicionário </p>
     * @author Marcelo Telles
     * @version 1.0
     * @param file String - arquivo a ser carregado. Este arquivo tem um dicionário de palavras
     * @throws IOException caso o arquivo não seja localizado
     * @see Word()
     * @since 24/08/2020
     * @serial 1
     */
    public void setWords(String file) throws IOException{
        words = new ArrayList<String>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while(true){
                line = br.readLine();
                if(line!=null){
                    words.add(line);
                }else{
                    break;
                }
            }
            while(line!=null){
                words.add(line);
                line = br.readLine();
            }
        }catch(IOException e){
            System.out.println("Error on load file "+file);
        }
    }

    public ArrayList<String> getWords(){
        return words;
    }

    /**
     * Método atribuir valor em secret
     * @author Marcelo Telles
     * @version 1.0
     * @param file String - arquivo a ser carregado. Este arquivo tem frase secreta
     */
    public void setSecret(String file){
        secret="";
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while(true){
                line = br.readLine();
                if(line!=null){
                    secret = secret + line+special;;
                }else{
                    break;
                }
            }
        }catch(Exception e){
            System.out.println("Error on load file "+file);
        }
    }


    /**
     * Método atribuir valor em associated
     * @author Marcelo Telles
     * @version 1.0
     * */
    public void setAssociated(){
        associated = new Character[sizeAlfa];
        for (int i = 0; i<26;i++){
            associated[i]=(char)(i+65);
        }
        associated[26]='.';
        associated[27]=',';
        associated[28]=';';
        associated[29]='!';
        associated[30]='?';
        associated[31]='Á';
        associated[32]='Ã';
        associated[33]='À';
        associated[34]='Â';
        associated[35]='É';
        associated[36]='Ê';
        associated[37]='Í';
        associated[38]='Ó';
        associated[39]='Õ';
        associated[40]='Ô';
        associated[41]='Ú';
        associated[42]='Ü';
        associated[43]='Ç';
    }

    public String getSecret() {
        return secret;
    }

    public Character[] getAssociated() {
        return associated;
    }

    public void setAssociated(Character[] associated) {
        this.associated = associated;
    }


    //demais getter e setter
    //...

    /**
     * Método para descriptografar
     * @author Marcelo Telles
     * @version 1.0
     * @param key é a chave que achamos que pode descriptografar
     * @param message é a mensagem criptografada
     * @return String com a mensagem descriptografada usando a key informada por parâmetro
     * */
    public String makeKey(int key, String message){
        String result="";
        Character charPos='\0';
        int pos=0;
        for (int i=0;i<message.length();i++){
            charPos=message.charAt(i);
            for (int j=0; j<associated.length;j++){
                if(charPos.equals(associated[j])){
                    pos=j+key;
                    if(pos>=sizeAlfa){
                        pos-=sizeAlfa;
                    }
                    result=result+associated[pos];
                }
            }
        }
        return result;
    }

    /**
     * Método para descriptografar automaticamente
     * @author Marcelo Telles
     * @version 1.0
     * @return ArrayList de String[]s com as mensagens descriptografadas, cada palavra separada em uma posição de um array[]
     * @see Word#makekey0to44()
     * @see #makekey0to44()
     * @since 24/08/2020
     * @deprecated Foi substitruido pelo método makekey0to44 :)
     * */
    public ArrayList<String[]> makekey0to5(){
        //test key 0 up to 5
        secretsWords = new ArrayList<String[]>();
        //split message
        String[] secretWords = getSecret().split(special);
        String[] line;
        for (int i=0;i<5;i++){
            //cript all words with the key i
            line = new String[secretWords.length];
            for (int j=0;j<secretWords.length;j++){
                //System.out.println("Word "+secretWords[j]);
                line[j] = makeKey(i,secretWords[j]);
                //System.out.println("Word "+ line[j]);
            }
            secretsWords.add(line);
        }
        return secretsWords;
    }
    public ArrayList<String[]> makekey0to44(){
        //test key 0 up to sizeAlfa
        secretsWords = new ArrayList<String[]>();
        //split message
        String[] secretWords = getSecret().split(special);
        String[] line;
        for (int i=0;i<sizeAlfa;i++){
            //cript all words with the key i
            line = new String[secretWords.length];
            for (int j=0;j<secretWords.length;j++){
                //System.out.println("Word "+secretWords[j]);
                line[j] = makeKey(i,secretWords[j]);
                System.out.println("key "+i +" Word "+ line[j]);
            }
            secretsWords.add(line);
        }
        return secretsWords;
    }

    /**
     * Método semelhante ao método makeKey
     * @author Marcelo Telles
     * @version 1.0
     * @param x int - chave a ser testada
     * @return array de Strings
     */
    public String[] makekeyx(int x){
        //test only key X
        String[] secretWords = getSecret().split(special);
        String[] line;
        line = new String[secretWords.length];
        for (int j=0;j<secretWords.length;j++){
            line[j] = makeKey(x,secretWords[j]);
        }
        return line;
    }

    /**
     * Método para pegar o valor de decrypt. O valor será concatenado em uma única String
     * @author Marcelo Telles
     * @version 1.0
     * @return String
     */

    public String getDecrypt() {
        String temp="";
        for (String a: decrypt) {
            temp+=a+" ";
        }
        return temp;
    }

    public int[] countMatch(){
        ts = new int[secretsWords.size()];
        for (int i=0; i<secretsWords.size(); i++){
            for (int j=0;j<secretsWords.get(i).length;j++){
                //System.out.println("--"+secretsWords.get(i)[j]);
                //System.out.print("#");
                //verify if word secretsWords.get(i)[j] exists in dictionary
                String limpa=clean(secretsWords.get(i)[j]);
                if(words.contains(limpa.toLowerCase())){
                    //System.out.println("--"+secretsWords.get(i)[j]);
                    //System.out.println("FOUND");
                    ts[i]++;
                }
            }
            //System.out.println();
        }
        return ts;
    }

    public int biggerCount(){
        int m=0;
        int position=0;
        for(int i=0;i<ts.length;i++){
            if(ts[i]>m){
                m=ts[i];//amout of identicals
                position=i;
            }
        }
        return position;
    }

    /**
     * Método para limpar Strings
     * <p>Este método recebe uma String e devolve a mesma sem o seguintes caracteres: , . ! ? </p>
     * @author Marcelo Telles
     * @version 1.0
     * @param source que é a String que deseja limpar
     * @return String recebida por parãmetro sem os , . ! ?
     * @see Word()
     * @since 31/08/2020
     * @serial 1
     */

    public String clean(String source) {
        String revome=",.!?";
        for (int i = 0; i < revome.length(); i++) {
            //System.out.print("Tem "+source);
            //System.out.println(" isso "+revome.substring(i,(i+1)));

            if(source.contains(revome.substring(i,(i+1)))){
                source=source.replace(",","");
            }
            if(source.contains(revome.substring(i,(i+1)))){
                source=source.replace(".","");
            }
            if(source.contains(revome.substring(i,(i+1)))){
                source=source.replace("!","");
            }
            if(source.contains(revome.substring(i,(i+1)))){
                source=source.replace("?","");
            }
        }
        return source;
    }

}

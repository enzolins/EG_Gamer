package RegraDeNegocio;

import java.util.regex.Pattern;

public class ChecarEntrada implements Checagem{

    @Override
    public int checarCaracteres(String nome) {
        int status=0;
        if(!Pattern.matches("[A-Za-zÀ-ü ]+", nome)){
            status++;
        }
        return status;
    }

    @Override
    public int checarEspacos(String nome) {
        int status = 0;
        for(int i=0;i<nome.length();i++){
            if (Character.isWhitespace(nome.charAt(i))){
                if (Character.isWhitespace(nome.charAt(i+1))){
                   status++;
                }
            }
        }
        return status;
    }

    @Override
    public int checarIdade(int idade) {
        int status = 0;
        if (idade<0){
            status++;
        }
        return status;
    }

    @Override
    public int checarQuantidade(int quantidade) {
        int status = 0;
        if (quantidade<0){
            status++;
        }
        return status;
    }

    @Override
    public int checarPreco(double preco) {
        int status = 0;
        if (preco<0){
            status++;
        }
        return status;
    }
    

    
}
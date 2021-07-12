package Exceptions;

import RegraDeNegocio.MostrarMensagens;

public class QuantidadeInvalida extends Exception{
    
    public QuantidadeInvalida(){
        MostrarMensagens.erroQuantidade();
    }
}

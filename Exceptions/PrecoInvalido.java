package Exceptions;

import RegraDeNegocio.MostrarMensagens;

public class PrecoInvalido extends Exception{
    
    public PrecoInvalido(){
        MostrarMensagens.erroPreco();
    }
}

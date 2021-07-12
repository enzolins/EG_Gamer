package Exceptions;

import RegraDeNegocio.MostrarMensagens;

public class NomeInvalido extends Exception {
    
    public NomeInvalido(){
        MostrarMensagens.erroNome();
    }
}

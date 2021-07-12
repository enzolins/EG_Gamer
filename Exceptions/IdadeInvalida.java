package Exceptions;

import RegraDeNegocio.MostrarMensagens;

public class IdadeInvalida extends Exception{
    
   public IdadeInvalida(){
        MostrarMensagens.erroIdade();
    }
}

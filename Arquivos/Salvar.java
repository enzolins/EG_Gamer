package Arquivos;

import java.io.FileWriter;
import java.io.IOException;

import InterfaceGrafica.MenuPrincipal;
import RegraDeNegocio.FuncionarioVendedor;
import RegraDeNegocio.Produtos;

public class Salvar{
    private static Produtos produto = MenuPrincipal.retornarProduto();
    private static int i = produto.getSize();
    private static FuncionarioVendedor funcionarioVendedor = MenuPrincipal.retornarVendedor();
    private static int y = funcionarioVendedor.getSize();
    private static int z;


    public static void salvarProdutos() throws IOException{
        FileWriter wr =  new FileWriter("BancoDeDados" + System.getProperty("file.separator")+"Produtos.txt");
        z = 0;
        while(z<i){
            if(z==i-1){
                wr.write(produto.getNome(z));
            }
            else{
                wr.write(produto.getNome(z) + "\n");
            }
            z += 1;
        }
        wr.close();

    }

    public static void salvarPreco() throws IOException{
        FileWriter wr2 =  new FileWriter("BancoDeDados" + System.getProperty("file.separator")+"Preco.txt");
        z = 0;
        while(z<i){
            if(z==i-1){
                wr2.write(produto.getPreco(z).toString());
            }
            else{
                wr2.write(produto.getPreco(z).toString() + "\n");
            }
            z += 1;
        }
        wr2.close();

    }



public static void salvarQuantidade() throws IOException{
    FileWriter wr3 =  new FileWriter("BancoDeDados" + System.getProperty("file.separator")+"Quantidade.txt");
    z = 0;
    while(z<i){
        if(z==i-1){
            wr3.write(produto.getQuantidade(z).toString());
        }
        else{
            wr3.write(produto.getQuantidade(z).toString() + "\n");
        }
        z += 1;
    }
    wr3.close();

}

public static void salvarCategoria() throws IOException{
    FileWriter wr =  new FileWriter("BancoDeDados" + System.getProperty("file.separator")+"Categoria.txt");
    z = 0;
    while(z<i){
        if(z==i-1){
            wr.write(produto.getCategoria(z));
        }
        else{
            wr.write(produto.getCategoria(z) + "\n");
        }
        z += 1;
    }
    wr.close();

}

public static void salvarFuncionarios() throws IOException{
    FileWriter nome = new FileWriter("BancoDeDados" + System.getProperty("file.separator")+"NomeFuncionarios.txt");
    FileWriter idade = new FileWriter("BancoDeDados" + System.getProperty("file.separator")+"IdadeFuncionarios.txt");
    FileWriter sexo = new FileWriter("BancoDeDados" + System.getProperty("file.separator")+"SexoFuncionarios.txt");
    
    //NOME
    z = 0;
    while(z<y){
        if(z==y-1){
            nome.write(funcionarioVendedor.getNome(z));
        }
        else{
            nome.write(funcionarioVendedor.getNome(z) + "\n");
        }
        z += 1;
    }

    //IDADE
    z = 0;
    while(z<y){
        if(z==y-1){
            idade.write("" + funcionarioVendedor.getIdade(z) );
        }
        else{
            idade.write("" + funcionarioVendedor.getIdade(z) + "\n");
        }
        z += 1;
    }

    //SEXO
    z = 0;
    while(z<y){
        if(z==y-1){
            sexo.write(funcionarioVendedor.getSexo(z));
        }
        else{
            sexo.write(funcionarioVendedor.getSexo(z) + "\n");
        }
        z += 1;
    }

    nome.close();
    idade.close();
    sexo.close();
}

}

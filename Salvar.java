
import java.io.FileWriter;
import java.io.IOException;

public class Salvar{
    private static Produtos produto = MenuPrincipal.retornarProduto();
    private static int i = produto.getSize();
    private static int z;


    public static void salvarProdutos() throws IOException{
        FileWriter wr =  new FileWriter("Produtos.txt");
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
        FileWriter wr2 =  new FileWriter("Preco.txt");
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
    FileWriter wr3 =  new FileWriter("Quantidade.txt");
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
    FileWriter wr =  new FileWriter("Categoria.txt");
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

}

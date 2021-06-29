
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Carregar {
    private static Produtos produto = MenuPrincipal.retornarProduto(); 
   

    public static void carregarProdutos() throws FileNotFoundException{
        File file = new File("Produtos.txt");
        Scanner ler = new Scanner(file);
        

        while(ler.hasNextLine()){
            produto.setNome(ler.nextLine());
        }
        ler.close();
    }

    public static void carregarPreco() throws FileNotFoundException{
        File file2 = new File("Preco.txt");
        Scanner ler2 = new Scanner(file2);
        

        while(ler2.hasNextLine()){
            produto.setPreco(Double.parseDouble(ler2.nextLine()));
        }
        ler2.close();
    }

    public static void carregarQuantidade() throws FileNotFoundException{
        File file3 = new File("Quantidade.txt");
        Scanner ler3 = new Scanner(file3);
        

        while(ler3.hasNextLine()){
            produto.setQuantidade(Integer.parseInt(ler3.nextLine()));
        }
        ler3.close();
    }

    public static void carregarCategoria() throws FileNotFoundException{
        File file = new File("Categoria.txt");
        Scanner ler = new Scanner(file);
        

        while(ler.hasNextLine()){
            produto.setCategoria(ler.nextLine());
        }
        ler.close();
    }
}

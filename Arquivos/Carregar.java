package Arquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import InterfaceGrafica.MenuPrincipal;
import RegraDeNegocio.FuncionarioVendedor;
import RegraDeNegocio.Produtos;

public class Carregar {
    private static Produtos produto = MenuPrincipal.retornarProduto(); 
    private static FuncionarioVendedor funcionarioVendedor = MenuPrincipal.retornarVendedor();
   

    public static void carregarProdutos() throws FileNotFoundException{
        File file = new File("BancoDeDados" + System.getProperty("file.separator")+"Produtos.txt");
        Scanner ler = new Scanner(file);
        

        while(ler.hasNextLine()){
            produto.setNome(ler.nextLine());
        }
        ler.close();
    }

    public static void carregarPreco() throws FileNotFoundException{
        File file2 = new File("BancoDeDados" + System.getProperty("file.separator")+"Preco.txt");
        Scanner ler2 = new Scanner(file2);
        

        while(ler2.hasNextLine()){
            produto.setPreco(Double.parseDouble(ler2.nextLine()));
        }
        ler2.close();
    }

    public static void carregarQuantidade() throws FileNotFoundException{
        File file3 = new File("BancoDeDados" + System.getProperty("file.separator")+"Quantidade.txt");
        Scanner ler3 = new Scanner(file3);
        

        while(ler3.hasNextLine()){
            produto.setQuantidade(Integer.parseInt(ler3.nextLine()));
        }
        ler3.close();
    }

    public static void carregarCategoria() throws FileNotFoundException{
        File file = new File("BancoDeDados" + System.getProperty("file.separator")+"Categoria.txt");
        Scanner ler = new Scanner(file);
        

        while(ler.hasNextLine()){
            produto.setCategoria(ler.nextLine());
        }
        ler.close();
    }

    public static void carregarFuncionarios() throws FileNotFoundException{
        File nome = new File("BancoDeDados" + System.getProperty("file.separator")+"NomeFuncionarios.txt");
        File idade = new File("BancoDeDados" + System.getProperty("file.separator")+"IdadeFuncionarios.txt");
        File sexo = new File("BancoDeDados" + System.getProperty("file.separator")+"SexoFuncionarios.txt");

        Scanner lerNome = new Scanner(nome);
        Scanner lerIdade = new Scanner(idade);
        Scanner lerSexo = new Scanner(sexo);

        //NOME
        while (lerNome.hasNextLine()) {
            funcionarioVendedor.setNome(lerNome.nextLine());
        }

        lerNome.close();

        //IDADE
        while (lerIdade.hasNextLine()) {
            funcionarioVendedor.setIdade(Integer.parseInt(lerIdade.nextLine()));
        }

        lerIdade.close();

        //SEXO
        while (lerSexo.hasNextLine()) {
            funcionarioVendedor.setSexo(lerSexo.nextLine());
        }  
        
        lerSexo.close();

    }
}

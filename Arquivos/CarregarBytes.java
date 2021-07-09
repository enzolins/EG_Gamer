package Arquivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import InterfaceGrafica.MenuPrincipal;
import RegraDeNegocio.Cliente;
import RegraDeNegocio.FuncionarioVendedor;

public class CarregarBytes {
    private static Cliente cliente = MenuPrincipal.retornarCliente();
    private static FuncionarioVendedor funcionarioVendedor = MenuPrincipal.retornarVendedor();

    public static void carregarClientes() throws IOException,FileNotFoundException{
        BufferedReader brNome = new BufferedReader(new FileReader("BancoDeDados" + System.getProperty("file.separator")+"NomeClientes.txt"));
        BufferedReader brIdade = new BufferedReader(new FileReader("BancoDeDados" + System.getProperty("file.separator")+"IdadeClientes.txt"));
        BufferedReader brSexo = new BufferedReader(new FileReader("BancoDeDados" + System.getProperty("file.separator")+"SexoClientes.txt"));
        BufferedReader brStatus = new BufferedReader(new FileReader("BancoDeDados" + System.getProperty("file.separator")+"StatusClientes.txt"));

        String i="";
        //NOME
        while((i=brNome.readLine()) !=null){
            cliente.setNome(i);
        }

        //IDADE
        while((i=brIdade.readLine()) !=null){
            cliente.setIdade(Integer.parseInt(i));
        }   

        //SEXO
        while((i=brSexo.readLine()) !=null){
            cliente.setSexo(i);
        }  

        //STATUS
        while((i=brStatus.readLine()) !=null){
            cliente.setStatus(Integer.parseInt(i));
        }   
        
        brNome.close();
        brIdade.close();
        brSexo.close();
        brStatus.close();
    }

    public static void carregarVendas() throws IOException, FileNotFoundException{
        BufferedReader brVendas = new BufferedReader(new FileReader("BancoDeDados" + System.getProperty("file.separator")+"RegistroDeVendas.txt"));
        String i="";
        //NOME
        while((i=brVendas.readLine()) !=null){
            funcionarioVendedor.setVendas(i);
        }

        brVendas.close();
    }

    public static void carregarCompra() throws IOException, FileNotFoundException{
        BufferedReader brCompra = new BufferedReader(new FileReader("BancoDeDados" + System.getProperty("file.separator")+"RegistroDeCompras.txt"));
        String i="";
        //NOME
        while((i=brCompra.readLine()) !=null){
            cliente.setCompras(i);;
        }

        brCompra.close();
    }
}
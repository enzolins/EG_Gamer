package Arquivos;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import InterfaceGrafica.MenuPrincipal;
import RegraDeNegocio.Cliente;

public class SalvarBytes {
    private static Cliente cliente = MenuPrincipal.retornarCliente();
    private static int i = cliente.getSize();

    public static void salvarCliente() throws IOException{
        OutputStream os = new FileOutputStream("BancoDeDados" + System.getProperty("file.separator")+"NomeClientes.txt");
        PrintStream ps = new PrintStream(os);
        OutputStream os2 = new FileOutputStream("BancoDeDados" + System.getProperty("file.separator")+"IdadeClientes.txt");
        PrintStream ps2 = new PrintStream(os2);
        OutputStream os3 = new FileOutputStream("BancoDeDados" + System.getProperty("file.separator")+"SexoClientes.txt");
        PrintStream ps3 = new PrintStream(os3);

        ps.print(criarNome());
        ps2.print(criarIdade());
        ps3.print(criarSexo());

        ps.flush();
        ps.close();
        ps2.flush();
        ps2.close();
        ps3.flush();
        ps3.close();
    }

    public static void salvarStatus() throws IOException{
        OutputStream os = new FileOutputStream("BancoDeDados" + System.getProperty("file.separator")+"StatusClientes.txt");
        PrintStream ps = new PrintStream(os);

        ps.print(criarStatus());

        ps.flush();
        ps.close();

    }

    private static String criarNome(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        for(int z = 0; z<i; z++){
            if(z==i-1)
            ps.print(cliente.getNome(z));
            else
            ps.println(cliente.getNome(z));
        }

        return baos.toString();
    }

    private static String criarIdade(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        for(int z = 0; z<i; z++){
            if(z==i-1)
            ps.print(cliente.getIdade(z));
            else
            ps.println(cliente.getIdade(z));
        }

        return baos.toString();
    }

    private static String criarSexo(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        for(int z = 0; z<i; z++){
            if(z==i-1)
            ps.print(cliente.getSexo(z));
            else
            ps.println(cliente.getSexo(z));
        }

        return baos.toString();
    }

    private static String criarStatus(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        for(int z = 0; z<i; z++){
            if(z==i-1)
            ps.print(cliente.getStatus(z));
            else
            ps.println(cliente.getStatus(z));
        }

        return baos.toString();
    }
}
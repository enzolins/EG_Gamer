import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CarregarBytes {
    private static Cliente cliente = MenuPrincipal.retornarCliente();

    public static void carregarClientes() throws IOException,FileNotFoundException{
        BufferedReader brNome = new BufferedReader(new FileReader("NomeClientes.txt"));
        BufferedReader brIdade = new BufferedReader(new FileReader("IdadeClientes.txt"));
        BufferedReader brSexo = new BufferedReader(new FileReader("SexoClientes.txt"));
        BufferedReader brStatus = new BufferedReader(new FileReader("StatusClientes.txt"));

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
}
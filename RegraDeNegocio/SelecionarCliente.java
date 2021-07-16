package RegraDeNegocio;
import InterfaceGrafica.MenuPrincipal;

public class SelecionarCliente {
    private static Cliente cliente = MenuPrincipal.retornarCliente();
    private static int id;
    
    public static int retornarIdDoCliente(String nome){
        id=0;
        while(!cliente.getNome(id).equals(nome)){
            id += 1;
        }
        return id; 
    }
}

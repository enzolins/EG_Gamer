package RegraDeNegocio;
import InterfaceGrafica.MenuPrincipal;

public class ListarClientes implements Listar{

    private Cliente cliente =  MenuPrincipal.retornarCliente();
    
    private String saida="";

    @Override
    public void listarTodos() {
        saida = "";
        for (int z = 0; z < cliente.getSize(); z++){

            saida = saida + ("Nome: " + cliente.getNome(z) + "  "
            + "Idade: " + cliente.getIdade(z) + "  "
            + "Sexo: " + cliente.getSexo(z) + "\n");
        }
    }

    @Override
    public void listarDisponiveis() {
        saida = "";
        for (int z = 0; z < cliente.getSize(); z++){
            if(cliente.getStatus(z) == 1){
                saida = saida + ("Nome: " + cliente.getNome(z) + "  "
                + "Idade: " + cliente.getIdade(z) + "  "
                + "Sexo: " + cliente.getSexo(z) + "\n");
            }
            
        }

    }

    @Override
    public void listarExcluidos() {
        saida = "";
        for (int z = 0; z < cliente.getSize(); z++){
            if(cliente.getStatus(z) == 0){
                saida = saida + ("Nome: " + cliente.getNome(z) + "  "
                + "Idade: " + cliente.getIdade(z) + "  "
                + "Sexo: " + cliente.getSexo(z) +"\n");
            }
            
        }
    }
    
    public String getSaida(){
        return saida;
    }
}

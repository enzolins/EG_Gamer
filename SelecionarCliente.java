public class SelecionarCliente {
    private static Cliente cliente = MenuPrincipal.retornarCliente();
    private static int id=0;
    
    public static int retornarIdDoCliente(String nome){
        
        while(!cliente.getNome(id).equals(nome)){
            id += 1;
        }

        return id; 
    }


}

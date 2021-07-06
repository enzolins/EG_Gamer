public class ListarVendedores implements Listar{
    private FuncionarioVendedor funcionarioVendedor = MenuPrincipal.retornarVendedor();
    
    private String saida="";

    @Override
    public void listarTodos() {
        saida = "";
        for (int z = 0; z < funcionarioVendedor.getSize(); z++){

            saida = saida + ("Nome: " + funcionarioVendedor.getNome(z) + "  "
            + "Idade: " + funcionarioVendedor.getIdade(z) + "  "
            + "Sexo: " + funcionarioVendedor.getSexo(z) + "\n");
        }
    }

    @Override
    public void listarDisponiveis() {
        ;
    }

    @Override
    public void listarExcluidos() {
        ;
    }
    
    public String getSaida(){
        return saida;
    }
}
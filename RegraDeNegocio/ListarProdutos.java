package RegraDeNegocio;
import InterfaceGrafica.MenuPrincipal;

public class ListarProdutos implements Listar{

    private Produtos produto =  MenuPrincipal.retornarProduto();
    private int i;
    private String saida = "";

    @Override
    public void listarTodos() {
        i = produto.getSize();
        saida = "";
        for (int z = 0; z<i; z++){
            saida = saida + ("Produto: " + produto.getNome(z) + "   " 
            + "Preco: R$" + produto.getPreco(z) + "   " 
            + "Em estoque: " + produto.getQuantidade(z) + "   " 
            + "Categoria: " + produto.getCategoria(z) + "\n");
        }
    }

    @Override
    public void listarDisponiveis() {
        i = produto.getSize();
        saida = "";
        for (int z = 0; z<i; z++){
            if(produto.getQuantidade(z)>0){
            saida = saida + ("Produto: " + produto.getNome(z) + "   " 
            + "Preco: R$" + produto.getPreco(z) + "   " 
            + "Em estoque: " + produto.getQuantidade(z) + "   " 
            + "Categoria: " + produto.getCategoria(z) + "\n");
            }
        }
    }

    @Override
    public void listarExcluidos(){
        i = produto.getSize();
        saida = "";
        for (int z = 0; z<i; z++){
            if(produto.getQuantidade(z)==0){
            saida = saida + ("Produto: " + produto.getNome(z) + "   " 
            + "Preco: R$" + produto.getPreco(z) + "   " 
            + "Em estoque: " + produto.getQuantidade(z) + "   " 
            + "Categoria: " + produto.getCategoria(z) + "\n");
            }
        }
    }
  
    public void listarPorCategoria(String categoria) {
        i = produto.getSize();
        saida = "";
        for (int z = 0; z<i; z++){
            if(produto.getCategoria(z).equals(categoria)){
            saida = saida + ("Produto: " + produto.getNome(z) + "   " 
            + "Preco: R$" + produto.getPreco(z) + "   " 
            + "Em estoque: " + produto.getQuantidade(z) + "   " 
            + "Categoria: " + produto.getCategoria(z) + "\n");
            }
        }
    }

    public String getSaida(){
        return saida;
    }

    
}

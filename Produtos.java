
import java.util.ArrayList;

public class Produtos{
   private ArrayList<String> produto = new ArrayList<String>();
   private ArrayList<Double> preco = new ArrayList<Double>();
   private ArrayList<Integer> quantidadeEmEstoque = new ArrayList<Integer>();
   private ArrayList<String> categoria = new ArrayList<String>();

    public void cadastrarProduto(String nome, double valor, int quantidade, String tipo){
       produto.add(nome);
       preco.add(valor);
       quantidadeEmEstoque.add(quantidade);
       categoria.add(tipo);
   }

   public String getNome(int i){
       return produto.get(i);
    }
   public Double getPreco(int i){
        return preco.get(i);
    }
    public Integer getQuantidade(int i){
        return quantidadeEmEstoque.get(i);
    }
    public String getCategoria(int i){
        return categoria.get(i);
    }
    public int getSize(){
        return produto.size();
    }

    public void setNome(String nome){
        produto.add(nome);
    }

    public void setPreco(Double valor){
        preco.add(valor);
    }

    public void setQuantidade(int quantidade){
        quantidadeEmEstoque.add(quantidade);
    }

    public void setCategoria(String tipo){
        categoria.add(tipo);
    }

    public void venderProduto(int i){
        quantidadeEmEstoque.set(i,quantidadeEmEstoque.get(i)-1);
    }

    public void adicionarEstoque(int i){
        quantidadeEmEstoque.set(i,quantidadeEmEstoque.get(i)+1);
    }
}
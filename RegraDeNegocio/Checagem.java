package RegraDeNegocio;

public interface Checagem{
    int checarCaracteres(String nome);

    int checarEspacos(String nome);

    int checarIdade(int idade);

    int checarQuantidade(int quantidade);

    int checarPreco(double preco);
}
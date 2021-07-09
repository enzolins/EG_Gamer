package RegraDeNegocio;
import java.util.ArrayList;

public class FuncionarioVendedor extends Funcionario implements Vendas{
    private ArrayList<String> nomeVendedor = new ArrayList<String>();
    private ArrayList<Integer> idadeVendedor = new ArrayList<Integer>();
    private ArrayList<String> sexoVendedor = new ArrayList<String>();
    private ArrayList<String> vendasVendedor = new ArrayList<String>();

    public void cadastrarVendedor(String nome, int idade, String sexo){
        nomeVendedor.add(nome);
        idadeVendedor.add(idade);
        sexoVendedor.add(sexo);
    }

    public void setNome(String nome){
        nomeVendedor.add(nome);
    }

    public void setIdade(int idade){
        idadeVendedor.add(idade);
    }

    public void setSexo(String sexo){
        sexoVendedor.add(sexo);
    }

    public String getNome(int i){
        return nomeVendedor.get(i);
    }

    public int getIdade(int i){
        return idadeVendedor.get(i);
    }

    public String getSexo(int i){
        return sexoVendedor.get(i);
    }

    public int getSize(){
        return nomeVendedor.size();
    }

    public void setVendas(String vendasCarregadas){
        vendasVendedor.add(vendasCarregadas);
    }

    public String getVendas(int i){
        return vendasVendedor.get(i);
    }

    public int getVendasSize(){
        return vendasVendedor.size();
    }

    @Override
    public void registrar(int idDoVendedor, String nomeProduto, String nomeCliente){
        vendasVendedor.add(idDoVendedor + "," + " vendeu " + nomeProduto + " para o cliente " + nomeCliente);
    }


    @Override
    public String obter(int idDoVendedor){
        String linhas = "";
        String [] iD;
        String vendas = "";
        for(int y = 0; y<vendasVendedor.size();y++){
            linhas = vendasVendedor.get(y);
            iD = linhas.split(",");
            if((Integer.parseInt(iD[0]))==idDoVendedor){
                vendas = vendas + nomeVendedor.get(Integer.parseInt(iD[0])) + iD[1] + "\n";
            }
            
        }    
        return vendas;
    }
    

}

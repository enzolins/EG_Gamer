package RegraDeNegocio;
import java.util.ArrayList;

public class Cliente extends Pessoa implements Vendas{
	
	private ArrayList<String> nomeCliente = new ArrayList<String>();
    private ArrayList<Integer> idadeCliente = new ArrayList<Integer>();
    private ArrayList<String> sexoCliente = new ArrayList<String>();
    private ArrayList<Integer> status = new ArrayList<Integer>();
    private ArrayList<String> compras = new ArrayList<String>();

	public void cadastroCliente(String nome, int idade, String sexo) {
        nomeCliente.add(nome);
        idadeCliente.add(idade);
        sexoCliente.add(sexo);
        status.add(1);
    }
	
    public void mudarStatus(int i){
        status.set(i,0);
    }

    public int getStatus(int i){
        return status.get(i);
    }

    public void setStatus(int i){
        status.add(i);
    }

    public void setNome(String nome){
        nomeCliente.add(nome);
    }

    public void setIdade(int idade){
        idadeCliente.add(idade);
    }

    public void setSexo(String sexo){
        sexoCliente.add(sexo);
    }

    public String getNome(int i){
        return nomeCliente.get(i);
    }

    public int getIdade(int i){
        return idadeCliente.get(i);
    }

    public String getSexo(int i){
        return sexoCliente.get(i);
    }

    public int getSize(){
        return nomeCliente.size();
    }

    public void setCompras(String comprasCarregadas){
        compras.add(comprasCarregadas);
    }

    public String getCompras(int i){
        return compras.get(i);
    }

    public int getComprasSize(){
        return compras.size();
    }

    @Override
    public void registrar(int iDdoCliente, String nomeProduto, String nomeDoVendedor) {
        compras.add(iDdoCliente + "," + " comprou " + nomeProduto + " com o vendedor " + nomeDoVendedor);
        
    }

    @Override
    public String obter(int iDdoCliente) {
        String linhas = "";
        String [] iD;
        String comprasCliente = "";
        for(int y = 0; y<compras.size();y++){
            linhas = compras.get(y);
            iD = linhas.split(",");
            if((Integer.parseInt(iD[0]))==iDdoCliente){
                comprasCliente = comprasCliente + nomeCliente.get(Integer.parseInt(iD[0])) + iD[1] + "\n";
            }
            
        }    
        return comprasCliente;
    }
    
}

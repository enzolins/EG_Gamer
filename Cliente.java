import java.util.ArrayList;

public class Cliente extends Pessoa{
	
	private ArrayList<String> nomeCliente = new ArrayList<String>();
    private ArrayList<Integer> idadeCliente = new ArrayList<Integer>();
    private ArrayList<String> sexoCliente = new ArrayList<String>();
    private ArrayList<Integer> status = new ArrayList<Integer>();
	

	//public Cliente(String nome, int idade, String sexo) {
	//	super(nome, idade, sexo);
	//}

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
    
}

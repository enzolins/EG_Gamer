package RegraDeNegocio;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import InterfaceGrafica.MenuPrincipal;

public class ListarClientes implements Listar{

    private Cliente cliente =  MenuPrincipal.retornarCliente();
    
    private String saida="";

    private int disponiveis = 0;

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

    public int getDisponiveis(){
        disponiveis = 0;
        for (int z = 0; z < cliente.getSize(); z++){
            if(cliente.getStatus(z) == 1){
                disponiveis += 1;
            }
        }
        return disponiveis;
    }


    // Foi utilizado JUnit para conferir se as listagem de clientes excluidos e disponíveis estava correta.
    //Como sabido, definimos que quando o cliente tem status 0 ele foi excluido e um cliente normal tem status 1.
    //Portanto, para testar se estamos listando correntamente os excluidos criamos dois clientes com status diferentes,
    // e sabemos que o resultado esperado é listar o cliente com status 0. Por outro lado, para testarmos se estamos listando 
    // os clientes disponiveis corretamente, sabemos que o nosso programa deve listar os clientes com status 1.


    @Test
    public void test1(){
        //Cliente cliente = MenuPrincipal.retornarCliente();
        cliente.setNome("Guilherme");
        cliente.setIdade(22);
        cliente.setSexo("Masculino");
        cliente.setStatus(0);


        cliente.setNome("Enzo");
        cliente.setIdade(22);
        cliente.setSexo("Masculino");
        cliente.setStatus(1);

        String esperado = "Nome: " + "Guilherme" + "  "
        + "Idade: " + 22 + "  "
        + "Sexo: " + "Masculino" +"\n";
        listarExcluidos();

        assertEquals(esperado, getSaida());
    }


    @Test
    public void test2(){
        //Cliente cliente = MenuPrincipal.retornarCliente();
        cliente.setNome("Guilherme");
        cliente.setIdade(22);
        cliente.setSexo("Masculino");
        cliente.setStatus(1);

        cliente.setNome("Enzo");
        cliente.setIdade(22);
        cliente.setSexo("Masculino");
        cliente.setStatus(1);

        cliente.setNome("Maria");
        cliente.setIdade(22);
        cliente.setSexo("Feminino");
        cliente.setStatus(0);

        String esperado = "Nome: " + "Guilherme" + "  "
        + "Idade: " + 22 + "  "
        + "Sexo: " + "Masculino" +"\n" + "Nome: " + "Enzo" + "  "
        + "Idade: " + 22 + "  "
        + "Sexo: " + "Masculino" +"\n";
        listarDisponiveis();

        assertEquals(esperado, getSaida());
    }
}

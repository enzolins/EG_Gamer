package RegraDeNegocio;

import javax.swing.JOptionPane;

public class MostrarMensagens extends Mensagens {

    public static void erroNome(){
        JOptionPane.showMessageDialog(null,"O nome digitado e invalido!"+"\n"+"Por favor, digite novamente","Erro",JOptionPane.ERROR_MESSAGE);
    }

    public static void erroIdade(){
        JOptionPane.showMessageDialog(null,"A idade digitada e invalida!"+"\n"+"Por favor, digite novamente","Erro",JOptionPane.ERROR_MESSAGE);
    }

    public static void erroGeral(){
        JOptionPane.showMessageDialog(null,"ERRO!","Erro",JOptionPane.ERROR_MESSAGE);
    }

    public static void erroPreco(){
        JOptionPane.showMessageDialog(null,"O preco digitado e invalido!"+"\n"+"Por favor, digite novamente","Erro",JOptionPane.ERROR_MESSAGE);
    }

    public static void erroQuantidade(){
        JOptionPane.showMessageDialog(null,"A quantidade digitada e invalida!"+"\n"+"Por favor, digite novamente","Erro",JOptionPane.ERROR_MESSAGE);
    }
}

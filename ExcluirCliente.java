import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
//import javax.swing.ImageIcon;
import javax.swing.JFrame;
//import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ExcluirCliente implements ActionListener{
    private JFrame frame = new JFrame();
    //private JButton button1 = new JButton();
    //private JButton button2 = new JButton();
    private JButton button3 = new JButton();
    private JLabel label1 = new JLabel();
    //private JLabel label2 = new JLabel();
    private JComboBox<String> comboBox;
    private Cliente cliente = MenuPrincipal.retornarCliente();
    private String[] opcoes = new String[cliente.getSize()];
    private ListarClientes listas = new ListarClientes();
    private int i=0;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu ArqMenu = new JMenu("Arquivo");
    private JMenu fileMenu = new JMenu("Programa");
    private JMenuItem exitItem1 = new JMenuItem("Sair para Menu");
    private JMenuItem backItem1 = new JMenuItem("Voltar");
    private JMenuItem loadItem = new JMenuItem("Carregar");
    private JMenuItem saveItem = new JMenuItem("Salvar");


    ExcluirCliente(){

        //MENU
        frame.setJMenuBar(menuBar);

        menuBar.add(ArqMenu);
        menuBar.add(fileMenu);
        
        ArqMenu.add(loadItem);
        ArqMenu.add(saveItem);

        fileMenu.add(backItem1);
        fileMenu.add(exitItem1);
        
        
        backItem1.addActionListener(this);
        exitItem1.addActionListener(this);
        saveItem.addActionListener(this);
      

        exitItem1.setMnemonic(KeyEvent.VK_A);
        backItem1.setMnemonic(KeyEvent.VK_V);

        //BUTTON 1 
        //button1.setBounds(300,60,113,49);
        //button1.setFocusable(false);
        //button1.setFont(new Font(null,Font.BOLD,15));
        //button1.setText("Menu");
        //button1.setHorizontalTextPosition(JButton.RIGHT);
        //button1.addActionListener(this);

        //BUTTON 2
        //button2.setBounds(300,120,113,49);
        //button2.setFocusable(false);
        //button2.setFont(new Font(null,Font.BOLD,15));
        //button2.setText("Cliente");
        //button2.setHorizontalTextPosition(JButton.RIGHT);
        //button2.addActionListener(this);

        //BUTTON 3
        button3.setBounds(500,100,113,49);
        button3.setFocusable(false);
        button3.setFont(new Font(null,Font.BOLD,15));
        button3.setText("Excluir");
        button3.setHorizontalTextPosition(JButton.RIGHT);
        button3.addActionListener(this);

        //COMBO BOX 
        
        int z;
        for (z=0; z<cliente.getSize();z++){
            if(cliente.getStatus(z)==1){
                opcoes[i] = cliente.getNome(z);
                i +=1;
            }
        }
        i=0;
        z=0;
        comboBox = new JComboBox<String>(opcoes);
        comboBox.setBounds(30,100,400,49);
        comboBox.setVisible(true);
        comboBox.setFont(new Font(null,Font.BOLD,15));
        comboBox.addActionListener(this);

        //LABEL 1 
        label1.setText("Escolha o cliente e depois pressione excluir");
        label1.setForeground(Color.black);
        label1.setFont(new Font(null,Font.PLAIN,20));
        label1.setBounds(130,10,500,49);

        //LABEL 2
        //label2.setText("Para adicionar novos Clientes");
        //label2.setForeground(Color.black);
        //label2.setFont(new Font(null,Font.BOLD,15));
        //label2.setBounds(10,120,250,49);

        //FRAME
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Lojas EG - Excluir Clientes");
        frame.setSize(700,400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        //frame.add(button1);
        //frame.add(button2);
        frame.add(button3);
        frame.add(comboBox);
        frame.add(label1);
        //frame.add(label2);
















    }

    @Override
    public void actionPerformed(ActionEvent e){
        //if(e.getSource() == button1){
        //    System.out.println("Botão 1 acionado!");
        //    frame.dispose();
        //    MenuPrincipal.retornarParaMenu();
        //}

        //if(e.getSource() == button2){
        //    System.out.println("Botão 2 acionado!");
        //    frame.dispose();
        //    Clientela.retornarParaCliente();
        //}
        
        if(e.getSource() == button3){
            cliente.mudarStatus(SelecionarCliente.retornarIdDoCliente(comboBox.getSelectedItem().toString()));
            comboBox.removeItem(comboBox.getSelectedItem());
            listas.listarExcluidos();
        }

        if(e.getSource()==exitItem1){
            frame.dispose();
            MenuPrincipal.retornarParaMenu();
        }

        if(e.getSource()==backItem1){
            frame.dispose();
            Clientela.retornarParaCliente();
        }
        
        if(e.getSource()==saveItem){
            try {
                SalvarBytes.salvarStatus();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
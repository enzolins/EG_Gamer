package InterfaceGrafica;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Arquivos.SalvarBytes;
import RegraDeNegocio.Cliente;
import RegraDeNegocio.ListarClientes;
import RegraDeNegocio.SelecionarCliente;

public class ExcluirCliente implements ActionListener{
    private JFrame frame = new JFrame();
    private JButton button = new JButton();
    private JLabel label1 = new JLabel();
    private JComboBox<String> comboBox;
    private Cliente cliente = MenuPrincipal.retornarCliente();
    private ListarClientes listas = new ListarClientes();
    private String[] opcoes = new String[listas.getDisponiveis()];
    private int i=0;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu ArqMenu = new JMenu("Arquivo");
    private JMenu fileMenu = new JMenu("Programa");
    private JMenuItem exitItem1 = new JMenuItem("Sair para Menu");
    private JMenuItem backItem1 = new JMenuItem("Voltar");
    private JMenuItem saveItem = new JMenuItem("Salvar");
    private ArrayList <Integer> listaDeDisponiveis = new ArrayList<>();


    ExcluirCliente(){
        //ICON
        ImageIcon logoIcon = new ImageIcon("Icones" + System.getProperty("file.separator")+"EG Logo Official 2000.png");

        //MENU
        frame.setJMenuBar(menuBar);

        menuBar.add(ArqMenu);
        menuBar.add(fileMenu);
        
        ArqMenu.add(saveItem);

        fileMenu.add(backItem1);
        fileMenu.add(exitItem1);
        
        
        backItem1.addActionListener(this);
        exitItem1.addActionListener(this);
        saveItem.addActionListener(this);
      

        exitItem1.setMnemonic(KeyEvent.VK_S);
        backItem1.setMnemonic(KeyEvent.VK_V);

        //BUTTON 3
        button.setBounds(500,100,113,49);
        button.setFocusable(false);
        button.setFont(new Font(null,Font.BOLD,15));
        button.setText("Excluir");
        button.setHorizontalTextPosition(JButton.RIGHT);
        button.addActionListener(this);

        int z;
        for (z=0; z<cliente.getSize();z++){
            if(cliente.getStatus(z)==1){
                listaDeDisponiveis.add(z);
            }
        }
        for(i = 0; i<listaDeDisponiveis.size();i++){
            opcoes[i] = cliente.getNome(listaDeDisponiveis.get(i));
        }
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


        //FRAME
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Lojas EG - Excluir Clientes");
        frame.setSize(700,400);
        frame.setLayout(null);
        frame.setIconImage(logoIcon.getImage());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(button);
        frame.add(comboBox);
        frame.add(label1);
    }

    @Override
    public void actionPerformed(ActionEvent e){
    
        if(e.getSource() == button){
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

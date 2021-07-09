package InterfaceGrafica;
import java.awt.Font;
import java.awt.event.*;
import java.awt.Color;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import RegraDeNegocio.FuncionarioVendedor;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;


public class ListagemDeVendas implements ActionListener{


    private static JFrame frame  = new JFrame();
    private JComboBox<String> comboBox;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("Programa");
    private JMenuItem backItem = new JMenuItem("Voltar");
    private JMenuItem sair = new JMenuItem("Sair"); 
    private JScrollPane scroll = new JScrollPane();
    private JTextArea textArea = new JTextArea();
    private FuncionarioVendedor funcionarioVendedor = MenuPrincipal.retornarVendedor();
    private String [] opcoes = new String[funcionarioVendedor.getSize()+1];

    ListagemDeVendas(){
        //ICON
        ImageIcon logoIcon = new ImageIcon("Icones" + System.getProperty("file.separator")+"EG Logo Official 2000.png");

        //MENU
        frame.setJMenuBar(menuBar);

        menuBar.add(fileMenu);

        fileMenu.add(backItem);
        fileMenu.add(sair);

        backItem.addActionListener(this);
        sair.addActionListener(this); 

        //COMBO BOX
        opcoes[0] = "Todos";
        for(int z = 1; z<funcionarioVendedor.getSize() + 1; z++){
            opcoes[z] = funcionarioVendedor.getNome(z-1);
        }
        comboBox = new JComboBox<String>(opcoes);
        comboBox.setBounds(300, 49, 230, 57);
        comboBox.setForeground(Color.BLACK);
        comboBox.setFont(new Font("Consolas",Font.BOLD,25));
        comboBox.addActionListener(this);

        //TEXT AREA
        textArea.setForeground(Color.BLACK);
        textArea.setFont(new Font("Consolas",Font.PLAIN,20));

        //SCROLL BAR
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setViewportView(textArea);
        scroll.setBounds(10, 300, 864, 330);

        //FRAME
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Lojas EG - Listagem De Vendas");
        frame.setSize(900,700);
        frame.setIconImage(logoIcon.getImage());
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(comboBox);
        frame.add(scroll);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backItem){
            frame.dispose();
            MenuDeListagem.retornarParaMenuDeListagem();
        }

        if(e.getSource()==sair){
            frame.dispose();
            System.exit(0);
        }
        if(e.getSource()==comboBox){
            int escolha = comboBox.getSelectedIndex();
            if(escolha==0){
                textArea.setText("");
                for(int z = 0; z<funcionarioVendedor.getVendasSize();z++){
                    textArea.append(funcionarioVendedor.obter(z));
                }
            }
            else{
                textArea.setText("");
                textArea.append(funcionarioVendedor.obter(comboBox.getSelectedIndex()-1));
            }
        }
    }


}

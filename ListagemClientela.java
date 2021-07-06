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
import javax.swing.JComboBox;


public class ListagemClientela implements ActionListener{


    private static JFrame frame  = new JFrame();
    private String[] opcoes = new String[]{"Todos","Disponiveis","Excluidos"};
    private JComboBox<String> comboBox = new JComboBox<String>(opcoes);
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("Programa");
    private JMenuItem backItem = new JMenuItem("Voltar");
    private JMenuItem sair = new JMenuItem("Sair"); 
    private JScrollPane scroll = new JScrollPane();
    private JTextArea textArea = new JTextArea();
    private ListarClientes lista = new ListarClientes();

    ListagemClientela(){

        //MENU
        frame.setJMenuBar(menuBar);

        menuBar.add(fileMenu);

        fileMenu.add(backItem);
        fileMenu.add(sair);

        backItem.addActionListener(this);
        sair.addActionListener(this);

        //COMBO BOX
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
        frame.setTitle("Lojas EG - Controle da Clientela");
        frame.setSize(900,700);
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
                lista.listarTodos();
                textArea.append(lista.getSaida());
            }
            if(escolha==1){
                textArea.setText("");
                lista.listarDisponiveis();
                textArea.append(lista.getSaida());
            }
            if(escolha==2){
                textArea.setText("");
                lista.listarExcluidos();
                textArea.append(lista.getSaida());
            }
        }
    }


}

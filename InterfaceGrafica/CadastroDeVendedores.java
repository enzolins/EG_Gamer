package InterfaceGrafica;
import java.awt.Font;
import java.awt.event.*;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Arquivos.Salvar;
import Exceptions.IdadeInvalida;
import Exceptions.NomeInvalido;
import RegraDeNegocio.FuncionarioVendedor;
import RegraDeNegocio.ListarVendedores;
import RegraDeNegocio.MostrarMensagens;

import javax.swing.JComboBox;

public class CadastroDeVendedores implements ActionListener {
    private static JFrame frame  = new JFrame();
    private JButton button = new JButton();
    private JButton button2 = new JButton();
    private JButton button3 = new JButton();
    private JLabel label1 = new JLabel();
    private JLabel label2 = new JLabel();
    private JLabel label3 = new JLabel();
    private JLabel label4 = new JLabel();
    private JTextField text1 = new JTextField();
    private JTextField text2 = new JTextField();
    private JTextField text3 = new JTextField();
    private JTextArea textArea = new JTextArea();
    private JScrollPane scroll = new JScrollPane();
    private JComboBox<String> comboBox;
    private String[] genero = new String[]{"Masculino", "Feminino"};
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("Programa");
    private JMenu ArqMenu = new JMenu("Arquivo");
    private JMenuItem backItem = new JMenuItem("Voltar"); 
    private JMenuItem exitItem = new JMenuItem("Sair para Menu"); 
    private JMenuItem saveItem = new JMenuItem("Salvar");
    private FuncionarioVendedor funcionarioVendedor =  MenuPrincipal.retornarVendedor();
    private ListarVendedores listaDeVendedores = new ListarVendedores();
    

    CadastroDeVendedores(){
        //ICONS
        ImageIcon logoIcon = new ImageIcon("Icones" + System.getProperty("file.separator")+"EG Logo Official 2000.png");
        
        //MENU
        frame.setJMenuBar(menuBar);

        menuBar.add(ArqMenu);
        menuBar.add(fileMenu);

        ArqMenu.add(saveItem);
        
        fileMenu.add(backItem);
        fileMenu.add(exitItem);

        backItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        backItem.setMnemonic(KeyEvent.VK_A);


        //LABEL 1
        label1.setText("Nome");
        label1.setForeground(Color.black);
        label1.setFont(new Font("Consolas",Font.PLAIN,25));
        label1.setBounds(10,80,150,49);
        
        //LABEL 2
        label2.setText("Idade");
        label2.setForeground(Color.black);
        label2.setFont(new Font("Consolas",Font.PLAIN,25));
        label2.setBounds(10,160,150,49);

        //LABEL 3
        label3.setText("Sexo");
        label3.setForeground(Color.black);
        label3.setFont(new Font("Consolas",Font.PLAIN,25));
        label3.setBounds(10,240,150,49);

        //LABEL 4
        label4.setText("CADASTRO DE VENDEDORES");
        label4.setForeground(Color.black);
        label4.setFont(new Font("Consolas",Font.BOLD,35));
        label4.setBounds(250, 11, 450, 49);        

        //TEXT FIELD 1 
        text1.setBounds(150,80,500,49);
        text1.setFont(new Font("Consolas",Font.PLAIN,25));
        text1.setForeground(Color.BLACK);
        text1.setBackground(Color.WHITE);
        text1.setCaretColor(Color.BLACK);

        //TEXT FIELD 2
        text2.setBounds(150,160,50,49);
        text2.setFont(new Font("Consolas",Font.PLAIN,25));
        text2.setForeground(Color.BLACK);
        text2.setBackground(Color.WHITE);
        text2.setCaretColor(Color.BLACK);


        //BUTTON 1
        button.setBounds(180,300,113,49);
        button.setText("Cadastrar");
        button.setFont(new Font("Consolas",Font.PLAIN,15));
        button.addActionListener(this);
        button.setFocusable(false);

        //BUTTON 2
        button2.setBounds(10,360,113,49);
        button2.setText("Listar");
        button2.setFont(new Font("Consolas",Font.PLAIN,15));
        button2.addActionListener(this);
        button2.setFocusable(false);

        //TEXT AREA
        textArea.setForeground(Color.BLACK);
        textArea.setFont(new Font("Consolas",Font.PLAIN,20));
        textArea.setEditable(false);

        //SCROLL PANE
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setViewportView(textArea);
        scroll.setBounds(150,420,730,200);

        //COMBO BOX 1 
        comboBox = new JComboBox<String>(genero);
        comboBox.setBounds(150,240,175,49);
        comboBox.setVisible(true);
        comboBox.setFont(new Font("Consolas",Font.PLAIN,15));
        comboBox.addActionListener(this);

        //FRAME
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Lojas EG - Controle de Vendedores");
        frame.setIconImage(logoIcon.getImage());
        frame.setSize(1000,700);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(button);
        frame.add(button2);
        frame.add(button3);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(text1);
        frame.add(text2);
        frame.add(text3);
        frame.add(scroll);
        frame.add(comboBox);

    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
       

        if (e.getSource() == button){
            String nome = text1.getText();
            int idade = Integer.parseInt(text2.getText());
            String sexo = String.valueOf(comboBox.getSelectedItem());
            try {
                funcionarioVendedor.cadastrarVendedor(nome, idade, sexo);
                text1.setText("");
                text2.setText("");
            } catch (NomeInvalido e1) {
                text1.setText("");
                text2.setText("");
            } catch (IdadeInvalida e1) {
                text1.setText("");
                text2.setText("");
            } catch(Exception w){
                MostrarMensagens.erroGeral();
                text1.setText("");
                text2.setText("");
            }
            
        }

        if (e.getSource() == button2){
            textArea.setText("");
            listaDeVendedores.listarTodos();
            textArea.append(listaDeVendedores.getSaida());
        }

        if(e.getSource()==backItem){
            frame.dispose();
            MenuDeCadastro.retornarParaMenuDeCadastro();
        }

        if(e.getSource() == exitItem){
            frame.dispose();
            MenuPrincipal.retornarParaMenu();
        }

        if(e.getSource()==saveItem){
            try {
                Salvar.salvarFuncionarios();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

}


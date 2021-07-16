package InterfaceGrafica;



import java.awt.Font;
import java.awt.event.*;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Arquivos.Salvar;
import Exceptions.NomeInvalido;
import Exceptions.PrecoInvalido;
import Exceptions.QuantidadeInvalida;
import RegraDeNegocio.ListarProdutos;
import RegraDeNegocio.MostrarMensagens;
import RegraDeNegocio.Produtos;


public class Cadastro implements ActionListener {
    
   private JFrame frame = new JFrame();
   private JButton button = new JButton();
   private JButton button2 = new JButton();
   private JTextField text = new JTextField();
   private JTextField text2 = new JTextField();
   private JTextField text3 = new JTextField();
   private String[] opcoes = new String[]{"Hardware","Software","Periferico"};
   private JComboBox<String> comboBox = new JComboBox<>(opcoes);
   private JLabel label1 = new JLabel();
   private JLabel label2 = new JLabel();
   private JLabel label3 = new JLabel();
   private JLabel label4 = new JLabel();
   private JLabel label5 = new JLabel();
   private JTextArea textArea = new JTextArea();
   private JScrollPane scroll = new JScrollPane();
   private JMenuBar menuBar = new JMenuBar();
   private JMenu fileMenu = new JMenu("Arquivo");
   private JMenu programMenu = new JMenu("Programa");
   private JMenuItem backItem = new JMenuItem("Voltar");
   private JMenuItem exiItem = new JMenuItem("Sair para Menu");
   private JMenuItem saveItem = new JMenuItem("Salvar");
   private Produtos produto = MenuPrincipal.retornarProduto();
   private ListarProdutos lista = new ListarProdutos();

    Cadastro(){

        //ICONS
        ImageIcon logoIcon = new ImageIcon("Icones" + System.getProperty("file.separator")+"EG Logo Official 2000.png");

        //MENU
        
        frame.setJMenuBar(menuBar);

        menuBar.add(fileMenu);
        menuBar.add(programMenu);
        menuBar.setFocusable(false);

        fileMenu.add(saveItem);


        programMenu.add(backItem);
        programMenu.add(exiItem);
        
        saveItem.addActionListener(this);
        backItem.addActionListener(this);
        exiItem.addActionListener(this);

        saveItem.setMnemonic(KeyEvent.VK_S);
        backItem.setMnemonic(KeyEvent.VK_V);
        exiItem.setMnemonic(KeyEvent.VK_S);

        fileMenu.setMnemonic(KeyEvent.VK_A);
        programMenu.setMnemonic(KeyEvent.VK_P);
        

        //BUTTONS
        button.setBounds(195, 300, 113, 49);
        button.setText("Cadastrar");
        button.setFont(new Font(null,Font.BOLD,15));
        button.addActionListener(this);
        button.setFocusable(false);

        button2.setBounds(10, 400, 113, 49);
        button2.setText("Listar");
        button2.setFont(new Font(null,Font.BOLD,15));
        button2.addActionListener(this);
        button2.setFocusable(false);
        
        //TEXT FIELD 1
        text.setBounds(170, 60, 500, 49);
        text.setFont(new Font("Consolas",Font.PLAIN,35));
        text.setForeground(Color.BLACK);
        text.setBackground(Color.WHITE);
        text.setCaretColor(Color.BLACK);

         //TEXT FIELD 2
        text2.setBounds(170, 120, 175, 49);
        text2.setFont(new Font("Consolas",Font.PLAIN,35));
        text2.setForeground(Color.BLACK);
        text2.setBackground(Color.WHITE);
        text2.setCaretColor(Color.BLACK);

        //TEXT FIELD 3
        text3.setBounds(170, 180, 175, 49);
        text3.setFont(new Font("Consolas",Font.PLAIN,35));
        text3.setForeground(Color.BLACK);
        text3.setBackground(Color.WHITE);
        text3.setCaretColor(Color.BLACK);

        //COMBO BOX
        comboBox.setBounds(170, 240, 175, 49);
        comboBox.setFont(new Font("Consolas",Font.PLAIN,25));
        comboBox.setForeground(Color.BLACK);
        comboBox.addActionListener(this);
        
        //LABEL 1
        label1.setText("Produto");
        label1.setForeground(Color.black);
        label1.setFont(new Font("Consolas",Font.PLAIN,25));
        label1.setBounds(10, 60, 150, 49);

        //LABEL 2
        label2.setText("Valor");
        label2.setForeground(Color.black);
        label2.setFont(new Font("Consolas",Font.PLAIN,25));
        label2.setBounds(10, 120, 150, 49);

        //LABEL 3
        label3.setText("Quantidade");
        label3.setForeground(Color.black);
        label3.setFont(new Font("Consolas",Font.PLAIN,25));
        label3.setBounds(10, 180, 150, 49);      

        //LABEL 4
        label4.setText("Categoria");
        label4.setForeground(Color.black);
        label4.setFont(new Font("Consolas",Font.PLAIN,25));
        label4.setBounds(10, 240, 150, 49);     

        //LABEL 5
        label5.setText("CADASTRO DE PRODUTOS");
        label5.setForeground(Color.black);
        label5.setFont(new Font("Consolas",Font.BOLD,35));
        label5.setBounds(300, 11, 400, 49);

        //TEXT AREA
        textArea.setForeground(Color.BLACK);
        textArea.setFont(new Font("Consolas",Font.PLAIN,20));
        textArea.setEditable(false);
       
        
        
        //SCROLL PANE
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setViewportView(textArea);
        scroll.setBounds(148, 400, 726, 200);
        

        //FRAME
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Lojas EG - Cadastrar Produtos");
        frame.setSize(900,700);
        frame.setIconImage(logoIcon.getImage());
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(button);
        frame.add(button2);
        frame.add(text);
        frame.add(text2);
        frame.add(text3);
        frame.add(comboBox);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.add(scroll);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            int repetido = 0;
            String nome = text.getText();
            double valor = Double.parseDouble(text2.getText());
            int quantidade = Integer.parseInt(text3.getText());
            String categoria = comboBox.getSelectedItem().toString();
            try {
                for(int y=0;y<produto.getSize();y++){
                    if(produto.getNome(y).equals(nome)){
                        repetido += 1;
                    }
                }
                if(repetido==0){
                    produto.cadastrarProduto(nome, valor, quantidade, categoria);
                }
                else{
                    MostrarMensagens.erroRepetido();
                }
                text.setText("");
                text2.setText("");
                text3.setText("");
            } catch (PrecoInvalido e1) {
                text.setText("");
                text2.setText("");
                text3.setText("");
            } catch (QuantidadeInvalida e1) {
                text.setText("");
                text2.setText("");
                text3.setText("");
            } catch (NomeInvalido e1){
                text.setText("");
                text2.setText("");
                text3.setText("");
            } catch (Exception w){
                MostrarMensagens.erroGeral();
                text.setText("");
                text2.setText("");
                text3.setText("");
            }

        }
        if(e.getSource()==button2){
            textArea.setText("");
            lista.listarTodos();
            textArea.append(lista.getSaida());
        }
        if(e.getSource()==saveItem){
            try {
                Salvar.salvarProdutos();
                Salvar.salvarPreco();
                Salvar.salvarQuantidade();
                Salvar.salvarCategoria();
            } catch (Exception q) {
                q.printStackTrace();
            }
        }
        if(e.getSource()==backItem){
           frame.dispose();
           MenuDeCadastro.retornarParaMenuDeCadastro();
        }
        if(e.getSource()==exiItem){
            frame.dispose();
            MenuPrincipal.retornarParaMenu();
         }
        
    }
}

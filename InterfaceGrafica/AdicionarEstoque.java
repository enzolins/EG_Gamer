package InterfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import Arquivos.Salvar;
import RegraDeNegocio.Produtos;

public class AdicionarEstoque implements ActionListener{
    private JFrame frame = new JFrame();
    private JButton button = new JButton();
    private JComboBox <String> comboBox;
    private Produtos produtos = MenuPrincipal.retornarProduto();
    private JLabel labelTitle = new JLabel();
    private JLabel labelProduto = new JLabel();
    private JLabel labelQuantidade = new JLabel();
    private JTextField textEstoque = new JTextField();
    private JTextField textAdicionar = new JTextField();
    private String [] opcoes = new String[produtos.getSize()];
    private JMenuBar menuBar = new JMenuBar();
    private JMenu ArqMenu = new JMenu("Arquivo");
    private JMenu fileMenu = new JMenu("Programa");
    private JMenuItem exitItem1 = new JMenuItem("Sair para Menu");
    private JMenuItem backItem1 = new JMenuItem("Voltar");
    private JMenuItem saveItem = new JMenuItem("Salvar");
    private int index = 0;

    AdicionarEstoque(){
        //ICONS 
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

        //LABELS
        labelTitle.setBounds(84,11,375,60);
        labelTitle.setText("ADICIONAR PRODUTO");
        labelTitle.setFont(new Font("Consolas",Font.BOLD,35));
        labelTitle.setForeground(Color.BLACK);

        labelProduto.setBounds(10,98,176,50);
        labelProduto.setText("PRODUTO: ");
        labelProduto.setForeground(Color.BLACK);
        labelProduto.setFont(new Font(null,Font.BOLD,20));

        labelQuantidade.setBounds(10,164,176,50);
        labelQuantidade.setText("QUANTIDADE: ");
        labelQuantidade.setForeground(Color.BLACK);
        labelQuantidade.setFont(new Font(null,Font.BOLD,20));

        //TEXT FIELDS
        textAdicionar.setBounds(224,159,128,55);
        textAdicionar.setCaretColor(Color.BLACK);
        textAdicionar.setEditable(false);
        textAdicionar.setBackground(Color.WHITE);
        textAdicionar.setForeground(Color.BLACK);
        textAdicionar.setFont(new Font("Consolas",Font.PLAIN,35));

        textEstoque.setBounds(113,339,275,82);
        textEstoque.setCaretColor(Color.BLACK);
        textEstoque.setEditable(false);
        textEstoque.setBackground(Color.WHITE);
        textEstoque.setForeground(Color.BLACK);
        textEstoque.setFont(new Font("Consolas",Font.PLAIN,30));


        //BUTTON
        button.setBounds(167,255,160,50);
        button.setFocusable(false);
        button.setFont(new Font(null,Font.BOLD,15));
        button.addActionListener(this);
        button.setText("Adicionar");

        //COMBO BOX
        for(int i = 0; i<produtos.getSize();i++){
            opcoes[i] = produtos.getNome(i);
        }
        comboBox = new JComboBox<>(opcoes);
        comboBox.setBounds(224,98,250,50);
        comboBox.addActionListener(this);
        comboBox.setFont(new Font(null,Font.BOLD,15));

        //FRAME
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Lojas EG - Alterar Estoque");
        frame.setSize(500,500);
        frame.setIconImage(logoIcon.getImage());
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(comboBox);
        frame.add(button);
        frame.add(labelTitle);
        frame.add(labelProduto);
        frame.add(labelQuantidade);
        frame.add(textAdicionar);
        frame.add(textEstoque);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==comboBox){
            textAdicionar.setEditable(true);
            index = comboBox.getSelectedIndex();
            textEstoque.setText("Em Estoque: " + produtos.getQuantidade(index));
        }
        if(e.getSource()==button){
                produtos.adicionarEstoque(index, Integer.parseInt(textAdicionar.getText()));
                textAdicionar.setText("");
                textEstoque.setText("Em Estoque: " + produtos.getQuantidade(index));
        }
        if(e.getSource()==exitItem1){
            frame.dispose();
            MenuPrincipal.retornarParaMenu();
        }

        if(e.getSource()==backItem1){
            frame.dispose();
            MenuDeCadastro.retornarParaMenuDeCadastro();
        }

        if(e.getSource()==saveItem){
            try {
                Salvar.salvarQuantidade();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    
}

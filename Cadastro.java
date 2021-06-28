import java.awt.Font;
import java.awt.event.*;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Cadastro implements ActionListener {
    
   private JFrame frame = new JFrame();
   private JButton button = new JButton();
   private JButton button2 = new JButton();
   private JTextField text = new JTextField();
   private JTextField text2 = new JTextField();
   private JTextField text3 = new JTextField();
   private JTextArea textArea = new JTextArea();
   private JScrollPane scroll = new JScrollPane();
   private JMenuBar menuBar = new JMenuBar();
   private JMenu fileMenu = new JMenu("Arquivo");
   private JMenu editMenu = new JMenu("Editar");
   private JMenu helpMenu = new JMenu("Ajuda");
   private JMenuItem loadItem = new JMenuItem("Carregar");
   private JMenuItem saveItem = new JMenuItem("Salvar");
   private JMenuItem exitItem = new JMenuItem("Sair");
   private Produtos produto = MenuPrincipal.retornarProduto();
   private int i;

    Cadastro(){
        i = produto.getSize();

        //ICONS
        ImageIcon logoIcon = new ImageIcon("EG Logo Official 2000.png");

        //MENU
        
        frame.setJMenuBar(menuBar);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        menuBar.setFocusable(false);

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        loadItem.setMnemonic(KeyEvent.VK_C);
        saveItem.setMnemonic(KeyEvent.VK_S);
        exitItem.setMnemonic(KeyEvent.VK_A);

        fileMenu.setMnemonic(KeyEvent.VK_A);
        editMenu.setMnemonic(KeyEvent.VK_E);
        helpMenu.setMnemonic(KeyEvent.VK_J);
        

        //BUTTONS
        button.setBounds(10, 280, 113, 49);
        button.setText("Cadastrar");
        button.setFont(new Font(null,Font.BOLD,15));
        button.addActionListener(this);
        button.setFocusable(false);

        button2.setBounds(10, 389, 113, 49);
        button2.setText("Listar");
        button2.setFont(new Font(null,Font.BOLD,15));
        button2.addActionListener(this);
        button2.setFocusable(false);
        
        //TEXT FIELD 1
        text.setBounds(133, 280, 175, 49);
        text.setFont(new Font("Consolas",Font.PLAIN,35));
        text.setForeground(Color.BLACK);
        text.setBackground(Color.WHITE);
        text.setCaretColor(Color.BLACK);

         //TEXT FIELD 2
        text2.setBounds(318, 280, 175, 49);
        text2.setFont(new Font("Consolas",Font.PLAIN,35));
        text2.setForeground(Color.BLACK);
        text2.setBackground(Color.WHITE);
        text2.setCaretColor(Color.BLACK);

        //TEXT FIELD 2
        text3.setBounds(503, 280, 175, 49);
        text3.setFont(new Font("Consolas",Font.PLAIN,35));
        text3.setForeground(Color.BLACK);
        text3.setBackground(Color.WHITE);
        text3.setCaretColor(Color.BLACK);

        //TEXT AREA
        //textArea.setBounds(133, 389, 741, 200);
        textArea.setForeground(Color.BLACK);
        textArea.setFont(new Font("Consolas",Font.PLAIN,20));
       // textArea.setVisible(false);
        
        
        //SCROLL PANE
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setViewportView(textArea);
        scroll.setVisible(false);
        scroll.setBounds(148, 389, 726, 200);
        

        //FRAME
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Lojas EG - Controle de Estoque");
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
        frame.add(scroll);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            String nome = text.getText();
            double valor = Double.parseDouble(text2.getText());
            int quantidade = Integer.parseInt(text3.getText());
            produto.cadastrarProduto(nome, valor, quantidade);
            i = produto.getSize();
            text.setText("");
            text2.setText("");
            text3.setText("");
        }
        if(e.getSource()==button2){
            textArea.setText("");
            textArea.setEditable(true);
            scroll.setVisible(true);
            for (int z = 0; z<i; z++){
                textArea.append("Produto: " + produto.getNome(z) + "   " 
                + "Preco: R$" + produto.getPreco(z) + "   " 
                + "Em estoque: " + produto.getQuantidade(z) + "\n");
            }
            textArea.setEditable(false);
        }
        if(e.getSource()==loadItem){
            System.out.println("CARREGANDO!!!");
        }
        if(e.getSource()==saveItem){
            System.out.println("SALVANDO!!!");
        }
        if(e.getSource()==exitItem){
           frame.dispose();
           MenuPrincipal.retornarParaMenu();
        }
        
    }
}

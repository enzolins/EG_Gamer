package InterfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import javax.swing.Timer;

import RegraDeNegocio.Produtos;
import Arquivos.Salvar;


public class Vender implements ActionListener{
    private JFrame frame = new JFrame();
    private JLabel label = new JLabel();
    private JButton button1 =  new JButton();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("Arquivo");
    private JMenu programMenu = new JMenu("Programa");
    private JMenuItem backItem = new JMenuItem("Voltar");
    private JMenuItem exiItem = new JMenuItem("Sair");
    private JMenuItem loadItem = new JMenuItem("Carregar");
    private JMenuItem saveItem = new JMenuItem("Salvar");
    private JComboBox<String> comboBox;
    private JTextPane paneValor = new JTextPane();
    private JTextPane paneQuantidade = new JTextPane();
    private Produtos produto = MenuPrincipal.retornarProduto();
    private int i;
    private String[] itens = new String[produto.getSize()];
    private Timer timer = new Timer(2000,this);

    Vender(){  

        //ICONS
        ImageIcon logoIcon = new ImageIcon("Icones" + System.getProperty("file.separator")+"EG Logo Official 2000.png");

        //MENU
        
        frame.setJMenuBar(menuBar);

        menuBar.add(fileMenu);
        menuBar.add(programMenu);
        menuBar.setFocusable(false);

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);

        programMenu.add(backItem);
        programMenu.add(exiItem);
        
        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        backItem.addActionListener(this);
        exiItem.addActionListener(this);

        loadItem.setMnemonic(KeyEvent.VK_C);
        saveItem.setMnemonic(KeyEvent.VK_S);
        backItem.setMnemonic(KeyEvent.VK_V);
        exiItem.setMnemonic(KeyEvent.VK_S);

        fileMenu.setMnemonic(KeyEvent.VK_A);
        programMenu.setMnemonic(KeyEvent.VK_P);        

        //BUTTONS
        button1.setBounds(165, 301, 152, 42);
        button1.setFocusable(false);
        button1.setFont(new Font(null,Font.BOLD,20));
        button1.setText("Vender");
        button1.addActionListener(this);
        button1.setEnabled(false);

        //COMBO BOX
        for(i=0;i<produto.getSize();i++){
            itens[i] = produto.getNome(i);
        }
        comboBox = new JComboBox<String>(itens);
        comboBox.setBounds(165, 39, 150, 40);
        comboBox.setVisible(true);
        comboBox.setFont(new Font(null,Font.BOLD,15));
        comboBox.addActionListener(this);

        //TEXT PANES
        paneValor.setBounds(10, 170, 200, 60);
        paneValor.setFont(new Font(null,Font.BOLD,25));
        paneValor.setEditable(false);
        paneQuantidade.setBounds(274, 170, 200, 60);
        paneQuantidade.setFont(new Font(null,Font.BOLD,25));
        paneQuantidade.setEditable(false);

        //LABEL
        label.setBounds(10, 375, 464, 60);
        label.setFont(new Font(null,Font.BOLD,35));
        label.setVisible(false);
        //label.setHorizontalTextPosition(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);


        //FRAME
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Lojas EG - Controle de Estoque");
        frame.setSize(500,500);
        frame.setIconImage(logoIcon.getImage());
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);        
        frame.add(button1);
        frame.add(comboBox);
        frame.add(paneQuantidade);
        frame.add(paneValor);
        frame.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==comboBox){
            paneValor.setText("R$ " + produto.getPreco(comboBox.getSelectedIndex()));
            paneQuantidade.setText("Disponível: " + produto.getQuantidade(comboBox.getSelectedIndex()));
            button1.setEnabled(true);
        }
        
        if(e.getSource()==button1){
            if(produto.getQuantidade(comboBox.getSelectedIndex())>0){
                produto.venderProduto(comboBox.getSelectedIndex());
                paneQuantidade.setText("Disponível: " + produto.getQuantidade(comboBox.getSelectedIndex()));
                label.setText("VENDIDO!");
                label.setForeground(Color.GREEN);
                label.setVisible(true);
                timer.start();
            }
            else{
                label.setVisible(true);
                label.setText("PRODUTO INDISPONIVEL!");
                label.setForeground(Color.RED);
                timer.start();
            }
            
            
        }
        if(e.getSource()==timer){
            timer.stop();
            label.setVisible(false);
        }

        if(e.getSource()==loadItem){
            System.out.println("CARREGANDO!!!");
        }
        if(e.getSource()==saveItem){
            System.out.println("SALVANDO!!!");
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
           MenuPrincipal.retornarParaMenu();
        }
        if(e.getSource()==exiItem){
            System.exit(0);
         }        
    }
    
}


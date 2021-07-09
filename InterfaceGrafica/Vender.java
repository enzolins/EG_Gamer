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

import Arquivos.Salvar;
import Arquivos.SalvarBytes;
import RegraDeNegocio.Cliente;
import RegraDeNegocio.FuncionarioVendedor;
import RegraDeNegocio.Produtos;
import RegraDeNegocio.SelecionarCliente;


public class Vender implements ActionListener{
    private JFrame frame = new JFrame();
    private JLabel label = new JLabel();
    private JLabel labelComboboxCliente = new JLabel();
    private JLabel labelComboboxProduto = new JLabel();
    private JLabel labelComboboxVendedor = new JLabel();
    private JLabel labelPreco = new JLabel();
    private JLabel labelQuantidade = new JLabel();
    private JButton button1 =  new JButton();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("Arquivo");
    private JMenu programMenu = new JMenu("Programa");
    private JMenuItem backItem = new JMenuItem("Voltar");
    private JMenuItem exiItem = new JMenuItem("Sair");
    private JMenuItem loadItem = new JMenuItem("Carregar");
    private JMenuItem saveItem = new JMenuItem("Salvar");
    private JComboBox<String> comboBoxProduto;
    private JComboBox<String> comboBoxVendedor;
    private JComboBox<String> comboBoxCliente;
    private JTextPane paneValor = new JTextPane();
    private JTextPane paneQuantidade = new JTextPane();
    private Produtos produto = MenuPrincipal.retornarProduto();
    private Cliente cliente = MenuPrincipal.retornarCliente();
    private FuncionarioVendedor funcionarioVendedor = MenuPrincipal.retornarVendedor();
    private int i;
    private String[] itens = new String[produto.getSize()];
    private String[] clientes = new String[cliente.getSize()];
    private String[] vendedores = new String[funcionarioVendedor.getSize()];
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
        button1.setBounds(166,413,152,42);
        button1.setFocusable(false);
        button1.setFont(new Font(null,Font.BOLD,20));
        button1.setText("Vender");
        button1.addActionListener(this);
        button1.setEnabled(false);

        //COMBO BOX PRODUTO
        for(i=0;i<produto.getSize();i++){
            itens[i] = produto.getNome(i);
        }
        comboBoxProduto = new JComboBox<String>(itens);
        comboBoxProduto.setBounds(166,150,152,42);
        comboBoxProduto.setVisible(true);
        comboBoxProduto.setFont(new Font(null,Font.BOLD,15));
        comboBoxProduto.addActionListener(this);
        comboBoxProduto.setEnabled(false);

        //COMBO BOX CLIENTES
        int z = 0;
        for(i=0;i<cliente.getSize();i++){
            if(cliente.getStatus(i)==1){
                clientes[z] = cliente.getNome(i);
                z += 1;
            }  
        }
        comboBoxCliente = new JComboBox<String>(clientes);
        comboBoxCliente.setBounds(322,150,152,42);
        comboBoxCliente.setVisible(true);
        comboBoxCliente.setFont(new Font(null,Font.BOLD,15));
        comboBoxCliente.addActionListener(this);
        comboBoxCliente.setEnabled(false);

        //COMBO BOX VENDEDORES
        for(i=0;i<funcionarioVendedor.getSize();i++){
            vendedores[i] = funcionarioVendedor.getNome(i);
        }
        comboBoxVendedor = new JComboBox<String>(vendedores);
        comboBoxVendedor.setBounds(10,150,152,42);
        comboBoxVendedor.setVisible(true);
        comboBoxVendedor.setFont(new Font(null,Font.BOLD,15));
        comboBoxVendedor.addActionListener(this);        

        //TEXT PANES
        paneValor.setBounds(10, 297, 200, 60);
        paneValor.setFont(new Font(null,Font.BOLD,25));
        paneValor.setEditable(false);
        paneQuantidade.setBounds(274, 297, 200, 60);
        paneQuantidade.setFont(new Font(null,Font.BOLD,25));
        paneQuantidade.setEditable(false);

        //LABEL
        label.setBounds(10,490,464,60);
        label.setFont(new Font(null,Font.BOLD,35));
        label.setVisible(false);
        label.setHorizontalAlignment(JLabel.CENTER);

        labelComboboxProduto.setText("Produto");
        labelComboboxProduto.setBounds(166,103,152,36);
        labelComboboxProduto.setFont(new Font(null,Font.BOLD,15));
        labelComboboxProduto.setHorizontalAlignment(JLabel.CENTER);
        labelComboboxProduto.setForeground(Color.BLACK);

        labelComboboxCliente.setText("Cliente");
        labelComboboxCliente.setBounds(322,103,152,36);
        labelComboboxCliente.setFont(new Font(null,Font.BOLD,15));
        labelComboboxCliente.setHorizontalAlignment(JLabel.CENTER);
        labelComboboxCliente.setForeground(Color.BLACK);

        labelComboboxVendedor.setText("Vendedor");
        labelComboboxVendedor.setBounds(10,103,152,36);
        labelComboboxVendedor.setFont(new Font(null,Font.BOLD,15));
        labelComboboxVendedor.setHorizontalAlignment(JLabel.CENTER);
        labelComboboxVendedor.setForeground(Color.BLACK);

        labelPreco.setText("Preco");
        labelPreco.setBounds(10,237,200,49);
        labelPreco.setFont(new Font(null,Font.BOLD,15));
        labelPreco.setHorizontalAlignment(JLabel.CENTER);
        labelPreco.setForeground(Color.BLACK);

        labelQuantidade.setText("Quantidade");
        labelQuantidade.setBounds(274,237,200,49);
        labelQuantidade.setFont(new Font(null,Font.BOLD,15));
        labelQuantidade.setHorizontalAlignment(JLabel.CENTER);
        labelQuantidade.setForeground(Color.BLACK);

        

        //FRAME
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Lojas EG - Controle de Estoque");
        frame.setSize(500,600);
        frame.setIconImage(logoIcon.getImage());
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);        
        frame.add(button1);
        frame.add(comboBoxProduto);
        frame.add(comboBoxCliente);
        frame.add(paneQuantidade);
        frame.add(comboBoxVendedor);
        frame.add(paneValor);
        frame.add(label);
        frame.add(labelComboboxCliente);
        frame.add(labelComboboxVendedor);
        frame.add(labelComboboxProduto);
        frame.add(labelPreco);
        frame.add(labelQuantidade);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==comboBoxVendedor){
            comboBoxProduto.setEnabled(true);
        }
        if(e.getSource()==comboBoxProduto){
            paneValor.setText("R$ " + produto.getPreco(comboBoxProduto.getSelectedIndex()));
            paneQuantidade.setText("" + produto.getQuantidade(comboBoxProduto.getSelectedIndex()));
            button1.setEnabled(true);
            comboBoxCliente.setEnabled(true);
        }
        
        if(e.getSource()==button1){
            if(produto.getQuantidade(comboBoxProduto.getSelectedIndex())>0){
                funcionarioVendedor.registrar(comboBoxVendedor.getSelectedIndex(), 
                comboBoxProduto.getSelectedItem().toString(),
                comboBoxCliente.getSelectedItem().toString());

                cliente.registrar(SelecionarCliente.retornarIdDoCliente(comboBoxCliente.getSelectedItem().toString()), 
                comboBoxProduto.getSelectedItem().toString(), comboBoxVendedor.getSelectedItem().toString());

                produto.venderProduto(comboBoxProduto.getSelectedIndex());
                paneQuantidade.setText("" + produto.getQuantidade(comboBoxProduto.getSelectedIndex()));
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
                Salvar.salvarQuantidade();
                SalvarBytes.salvarVendas();
                SalvarBytes.salvarCompras();
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


package InterfaceGrafica;

import java.awt.Font;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuDeListagem implements ActionListener{
    private static JFrame frame = new JFrame();
    private JButton button1 = new JButton();
    private JButton button2 = new JButton();
    private JButton button3 = new JButton();
    private JButton button4 = new JButton();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("Programa");
    private JMenuItem backItem = new JMenuItem("Voltar");
    private JMenuItem exitItem = new JMenuItem("Sair para Menu");

    MenuDeListagem(){
        ImageIcon logoIcon = new ImageIcon("Icones"+ System.getProperty("file.separator")+"EG Logo Official 2000.png");
        ImageIcon listarIcon = new ImageIcon("Icones"+ System.getProperty("file.separator")+"PC.png");
        ImageIcon clienteIcon = new ImageIcon("Icones"+ System.getProperty("file.separator")+"Membros.png");
        ImageIcon vendasIcon = new ImageIcon("Icones"+ System.getProperty("file.separator")+"Money.png");
        ImageIcon comprasIcon = new ImageIcon("Icones"+ System.getProperty("file.separator")+"Bag.png");
        
        //MENU
        frame.setJMenuBar(menuBar);

        menuBar.add(fileMenu);

        fileMenu.add(backItem);
        fileMenu.add(exitItem);

        backItem.addActionListener(this);
        exitItem.addActionListener(this);

        //BUTTONS
        button1.setBounds(10, 119, 200, 65);
        button1.setFocusable(false);
        button1.setFont(new Font(null,Font.BOLD,15));
        button1.setText("Listar Produtos");
        button1.setIcon(listarIcon);
        button1.setIconTextGap(3);
        button1.setHorizontalTextPosition(JButton.RIGHT);
        button1.addActionListener(this);

        button2.setBounds(275, 119, 200, 65);
        button2.setFocusable(false);
        button2.setFont(new Font(null,Font.BOLD,15));
        button2.setText("Listar Clientes");
        button2.addActionListener(this);
        button2.setIcon(clienteIcon);
        button2.setIconTextGap(3);
        button2.setHorizontalTextPosition(JButton.RIGHT);

        button3.setBounds(10, 276, 200, 65);
        button3.setFocusable(false);
        button3.setFont(new Font(null,Font.BOLD,15));
        button3.setText("Listar Vendas");
        button3.addActionListener(this);
        button3.setIcon(vendasIcon);
        button3.setIconTextGap(3);
        button3.setHorizontalTextPosition(JButton.RIGHT);

        button4.setBounds(275, 276, 200, 65);
        button4.setFocusable(false);
        button4.setFont(new Font(null,Font.BOLD,15));
        button4.setText("Listar Compras");
        button4.addActionListener(this);
        button4.setIcon(comprasIcon);
        button4.setIconTextGap(3);
        button4.setHorizontalTextPosition(JButton.RIGHT);

        //FRAME
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Lojas EG - Menu de Listagem");
        frame.setSize(500,500);
        frame.setIconImage(logoIcon.getImage());
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backItem){
            frame.dispose();
            MenuPrincipal.retornarParaMenu();
        }

        if(e.getSource()==exitItem){
            frame.dispose();
            MenuPrincipal.retornarParaMenu();
        }
        if(e.getSource()==button1){
            frame.setVisible(false);
            new ExibirEstoque();
        }
        
        if(e.getSource()==button2){
            frame.setVisible(false);
            new ListagemClientela();
        }

        if(e.getSource()==button3){
            frame.setVisible(false);
            new ListagemDeVendas();
        }

        if(e.getSource()==button4){
            frame.setVisible(false);
            new ListagemDeCompras();
        }
    }

     public static void retornarParaMenuDeListagem(){
         frame.setVisible(true);
     }
    
}

package InterfaceGrafica;

import java.awt.Font;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuDeCadastro implements ActionListener{
    private static JFrame frame = new JFrame();
    private JButton button1 = new JButton();
    private JButton button2 = new JButton();
    private JButton button3 = new JButton();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("Programa");
    private JMenuItem backItem = new JMenuItem("Voltar");

    MenuDeCadastro(){
        //ICONS
        ImageIcon logoIcon = new ImageIcon("Icones" + System.getProperty("file.separator")+"EG Logo Official 2000.png");
        ImageIcon produtosIcon = new ImageIcon("Icones" + System.getProperty("file.separator")+"PC.png");
        ImageIcon vendedoresIcon = new ImageIcon("Icones" + System.getProperty("file.separator")+"Vendedor.png");
        ImageIcon adicionarIcon = new ImageIcon("Icones" + System.getProperty("file.separator")+"Plus.png");

        //MENU
        frame.setJMenuBar(menuBar);

        menuBar.add(fileMenu);

        fileMenu.add(backItem);

        backItem.addActionListener(this);

        //BUTTONS
        button1.setBounds(102,72,279,65);
        button1.setFocusable(false);
        button1.setFont(new Font(null,Font.BOLD,15));
        button1.setText("Cadastrar Produtos");
        button1.setIcon(produtosIcon);
        button1.setIconTextGap(3);
        button1.setHorizontalTextPosition(JButton.RIGHT);
        button1.addActionListener(this);

        button2.setBounds(102,204,279,65);
        button2.setFocusable(false);
        button2.setFont(new Font(null,Font.BOLD,15));
        button2.setText("Cadastrar Funcionario");
        button2.addActionListener(this);
        button2.setIcon(vendedoresIcon);
        button2.setIconTextGap(3);
        button2.setHorizontalTextPosition(JButton.RIGHT);

        button3.setBounds(102,331,279,65);
        button3.setFocusable(false);
        button3.setFont(new Font(null,Font.BOLD,15));
        button3.setText("Aumentar Estoque");
        button3.addActionListener(this);
        button3.setIcon(adicionarIcon);
        button3.setIconTextGap(3);
        button3.setHorizontalTextPosition(JButton.RIGHT);


        //FRAME
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Lojas EG - Menu De Cadastro");
        frame.setSize(500,500);
        frame.setIconImage(logoIcon.getImage());
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backItem){
            frame.dispose();
            MenuPrincipal.retornarParaMenu();
        }
        
        if(e.getSource()==button1){
            frame.setVisible(false);
            new Cadastro();
        }
        
        if(e.getSource()==button2){
            frame.setVisible(false);
            new CadastroDeVendedores();
        }

        if(e.getSource()==button3){
            frame.setVisible(false);
            new AdicionarEstoque();
        }
    }


     public static void retornarParaMenuDeCadastro(){
         frame.setVisible(true);
     }
    
}
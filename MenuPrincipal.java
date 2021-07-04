import java.awt.Font;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuPrincipal implements ActionListener{
    private static JFrame frame = new JFrame();
    private JButton button1 = new JButton();
    private JButton button2 = new JButton();
    private JButton button3 = new JButton();
    private JButton button4 = new JButton();
    private static Produtos produto = new Produtos();
    private static Cliente cliente = new Cliente();

    public static Produtos retornarProduto(){
       return produto;
   }
   public static Cliente retornarCliente(){
    return cliente;
   }


    MenuPrincipal(){
        //FIRST LOAD
        try {
            Carregar.carregarPreco();
            Carregar.carregarQuantidade();
            Carregar.carregarProdutos();
            Carregar.carregarCategoria();
            CarregarBytes.carregarClientes();
        } catch (Exception w) {
            w.printStackTrace();
        }        

        ImageIcon logoIcon = new ImageIcon("EG Logo Official 2000.png");
        ImageIcon cadastroIcon = new ImageIcon("Register.png");
        ImageIcon venderIcon = new ImageIcon("Sell.png");
        ImageIcon listarIcon = new ImageIcon("List.png");
        ImageIcon clienteIcon = new ImageIcon("Customer.png");

        //BUTTONS
        button1.setBounds(10, 119, 190, 65);
        button1.setFocusable(false);
        button1.setFont(new Font(null,Font.BOLD,15));
        button1.setText("Cadastro");
        button1.setIcon(cadastroIcon);
        button1.setHorizontalTextPosition(JButton.RIGHT);
        button1.addActionListener(this);

        button2.setBounds(284, 119, 190, 65);
        button2.setFocusable(false);
        button2.setFont(new Font(null,Font.BOLD,15));
        button2.setText("Vender");
        button2.setIcon(venderIcon);
        button2.addActionListener(this);
        button2.setHorizontalTextPosition(JButton.RIGHT);

        button3.setBounds(10, 276, 190, 65);
        button3.setFocusable(false);
        button3.setFont(new Font(null,Font.BOLD,15));
        button3.setText("Cliente");
        button3.addActionListener(this);
        button3.setIcon(clienteIcon);
        button3.setIconTextGap(3);
        button3.setHorizontalTextPosition(JButton.RIGHT);

        button4.setBounds(284, 276, 190, 65);
        button4.setFocusable(false);
        button4.setFont(new Font(null,Font.BOLD,15));
        button4.setText("Listagem");
        button4.addActionListener(this);
        button4.setIcon(listarIcon);
        button4.setIconTextGap(3);
        button4.setHorizontalTextPosition(JButton.RIGHT);

        



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
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            frame.setVisible(false);
            new Cadastro();
        }
        
        if(e.getSource()==button2){
            frame.setVisible(false);
            new Vender();
        }

        if(e.getSource()==button3){
            frame.setVisible(false);
            new Clientela();
        }
        
        if(e.getSource()==button4){
            frame.setVisible(false);
            new MenuDeListagem();
        }
    }

     public static void retornarParaMenu(){
         frame.setVisible(true);
     }
    
}
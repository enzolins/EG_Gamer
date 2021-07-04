
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
    private JMenuItem sair = new JMenuItem("Sair");

    MenuDeListagem(){
        ImageIcon logoIcon = new ImageIcon("EG Logo Official 2000.png");
        ImageIcon listarIcon = new ImageIcon("PC.png");
        
        //MENU
        frame.setJMenuBar(menuBar);

        menuBar.add(fileMenu);

        fileMenu.add(backItem);
        fileMenu.add(sair);

        backItem.addActionListener(this);
        sair.addActionListener(this);

        //BUTTONS
        button1.setBounds(10, 119, 200, 65);
        button1.setFocusable(false);
        button1.setFont(new Font(null,Font.BOLD,15));
        button1.setText("Listar Produtos");
        button1.setIcon(listarIcon);
        button1.setIconTextGap(3);
        button1.setHorizontalTextPosition(JButton.RIGHT);
        button1.addActionListener(this);

        button2.setBounds(284, 119, 200, 65);
        button2.setFocusable(false);
        button2.setFont(new Font(null,Font.BOLD,15));
        button2.setText("A ser Implementado");

        button3.setBounds(10, 276, 200, 65);
        button3.setFocusable(false);
        button3.setFont(new Font(null,Font.BOLD,15));
        button3.setText("A ser Implementado");

        button4.setBounds(284, 276, 200, 65);
        button4.setFocusable(false);
        button4.setFont(new Font(null,Font.BOLD,15));
        button4.setText("A ser Implementado");

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
        if(e.getSource()==backItem){
            frame.dispose();
            MenuPrincipal.retornarParaMenu();
        }

        if(e.getSource()==sair){
            frame.dispose();
            System.exit(0);
        }
        if(e.getSource()==button1){
            frame.setVisible(false);
            new ExibirEstoque();
        }
        
        if(e.getSource()==button2){
        }

        if(e.getSource()==button3){
        }

        if(e.getSource()==button4){
        }
    }

     public static void retornarParaMenuDeListagem(){
         frame.setVisible(true);
     }
    
}

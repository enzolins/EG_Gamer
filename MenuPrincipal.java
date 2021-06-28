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

    public static Produtos retornarProduto(){
       return produto;
   }


    MenuPrincipal(){

        ImageIcon logoIcon = new ImageIcon("EG Logo Official 2000.png");

        //BUTTONS
        button1.setBounds(10, 119, 190, 65);
        button1.setFocusable(false);
        button1.setFont(new Font(null,Font.BOLD,15));
        button1.setText("A ser Implementado");
        button1.setHorizontalTextPosition(JButton.RIGHT);
        button1.addActionListener(this);

        button2.setBounds(284, 119, 190, 65);
        button2.setFocusable(false);
        button2.setFont(new Font(null,Font.BOLD,15));
        button2.setText("A ser implementado");
        button2.addActionListener(this);
        button2.setHorizontalTextPosition(JButton.RIGHT);

        button3.setBounds(10, 276, 190, 65);
        button3.setFocusable(false);
        button3.setFont(new Font(null,Font.BOLD,15));
        button3.setText("A ser Implementado");

        button4.setBounds(284, 276, 190, 65);
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
        if(e.getSource()==button1){
            frame.setVisible(false);
            new Cadastro();
        }
        
        if(e.getSource()==button2){
        }
    }

     public static void retornarParaMenu(){
         frame.setVisible(true);
     }
    
}
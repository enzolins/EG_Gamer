package InterfaceGrafica;

import java.awt.Font;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;

public class BoasVindas implements ActionListener {
    private JLabel label = new JLabel();
    private JFrame frame = new JFrame();
    private JButton button = new JButton();
    public BoasVindas(){
        //Icons
        ImageIcon logoIcon = new ImageIcon("Icones" + System.getProperty("file.separator")+"EG Logo Official 2000.png");
        ImageIcon labelImage = new ImageIcon("Icones" + System.getProperty("file.separator")+"EG Logo Official 1000.png");
        //LABEL
        label.setText("Seja Bem Vindo");
        label.setFont(new Font("BankGothic Md BT",Font.BOLD,60));
        label.setVerticalTextPosition(JLabel.TOP);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setIcon(labelImage);
        label.setForeground(Color.WHITE);
        label.setIconTextGap(-80);
        label.setVisible(true);
        label.setBounds(0,0,700,700);
        label.add(button);

        //BUTTON
        button.setBounds(200,580,300,50);
        button.setText("Aperte aqui para iniciar!");
        button.setFocusable(false);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setFont(new Font(null,Font.BOLD,25));
        button.setBorder(BorderFactory.createEtchedBorder());
        button.addActionListener(this);



        //FRAME
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Lojas EG - Controle de Estoque");
        frame.setSize(700,700);
        frame.setIconImage(logoIcon.getImage());
        frame.setLayout(null);
        frame.add(label);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            frame.dispose();
            new MenuPrincipal();
        }
        
    }
}
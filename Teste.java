
import java.awt.Font;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;

public class Teste implements ActionListener {
    private JLabel label = new JLabel();
    private JFrame frame = new JFrame();
    private JButton button = new JButton();
    Teste(){
        //Icons
        ImageIcon logoIcon = new ImageIcon("EG Logo Official 2000.png");
        ImageIcon labelImage = new ImageIcon("EG Logo Official 1000.png");
        //LABEL
        label.setText("Seja Bem Vindo");
        label.setFont(new Font("BankGothic Md BT",Font.BOLD,80));
        label.setVerticalTextPosition(JLabel.TOP);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        label.setIcon(labelImage);
        label.setForeground(Color.white);
        label.setIconTextGap(-105);
        label.setVisible(true);
        label.setBounds(0,0,1000,1000);
        label.add(button);

        //BUTTON
        button.setBounds(350,900,300,50);
        button.setText("Aperte aqui para iniciar!");
        button.setFocusable(false);
        //button.setHorizontalAlignment(JButton.CENTER);
        //button.setVerticalAlignment(JButton.BOTTOM);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setFont(new Font(null,Font.BOLD,25));
        button.setBorder(BorderFactory.createEtchedBorder());
        button.addActionListener(this);



        //FRAME
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Lojas EG - Controle de Estoque");
        frame.setSize(1000,1000);
        frame.setIconImage(logoIcon.getImage());
        frame.setLayout(null);
        frame.add(label);
        //frame.add(button);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            frame.dispose();
        }
        
    }
}

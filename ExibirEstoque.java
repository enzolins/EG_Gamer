import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class ExibirEstoque implements ActionListener{
    private static JFrame frame = new JFrame();
    private JTextArea textArea = new JTextArea();
    private JScrollPane scroll = new JScrollPane();
    private String[] opcoes = new String[]{"Todos","Disponiveis","Sem Estoque","Hardware","Software","Periferico"};
    private JComboBox<String> comboBox = new JComboBox<String>(opcoes);
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("Arquivo");
    private JMenu programMenu = new JMenu("Programa");
    private JMenuItem backItem = new JMenuItem("Voltar");
    private JMenuItem exiItem = new JMenuItem("Sair");
    private JMenuItem loadItem = new JMenuItem("Carregar");
    private JMenuItem saveItem = new JMenuItem("Salvar");
    private ListarProdutos lista = new ListarProdutos();

    ExibirEstoque(){
        //ICONS
        ImageIcon logoIcon = new ImageIcon("EG Logo Official 2000.png");

        //TEXT AREA
        textArea.setForeground(Color.BLACK);
        textArea.setFont(new Font("Consolas",Font.PLAIN,20));

        //SCROLL BAR

        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setViewportView(textArea);
        scroll.setBounds(10, 300, 864, 330);   

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


        //COMBO BOX
        comboBox.setBounds(300, 49, 230, 57);
        comboBox.setForeground(Color.BLACK);
        comboBox.setFont(new Font("Consolas",Font.BOLD,25));
        comboBox.addActionListener(this);

        //FRAME
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Lojas EG - Controle de Estoque");
        frame.setSize(900,700);
        frame.setIconImage(logoIcon.getImage());
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(scroll);
        frame.add(comboBox);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
           MenuDeListagem.retornarParaMenuDeListagem();
        }
        if(e.getSource()==exiItem){
            System.exit(0);
         }

        if(e.getSource()==comboBox){
            int escolha = comboBox.getSelectedIndex();
            if(escolha==0){
                textArea.setText("");
                lista.listarTodos();
                textArea.append(lista.getSaida());
            }
            if(escolha==1){
                textArea.setText("");
                lista.listarDisponiveis();
                textArea.append(lista.getSaida());
            }
            if(escolha==2){
                textArea.setText("");
                lista.listarExcluidos();
                textArea.append(lista.getSaida());
            }
            if(escolha==3 || escolha==4 || escolha==5){
                textArea.setText("");
                lista.listarPorCategoria(comboBox.getSelectedItem().toString());
                textArea.append(lista.getSaida());
            }
        }
    }


}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caluladora;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author User
 */
public class CalcCod1 extends JFrame {

    private String n0, n1, n2, n3, n4, n5, n6, n7, n8, n9, memoria = "", tela = "";
    private int resultado, verifica = -1, verficaOperation = 0, verifica2 = 1, soma1, multi;

    private JPanel jpCalc,sobre;
    private JLabel lblOperation, lblCalculadora;
    private List<JButton> btns, btnsOperation;
    private JButton igual, delet, soma, multiplicacao;
    private ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/Calc.png"));
    private ImageIcon imag = new ImageIcon(getClass().getResource("/imagens/fundo.jpg"));

    public CalcCod1() {

        configurarJanela();
        configurarPanel();
        configurarElementos();

    }

    private void configurarJanela() {
        this.setSize(230, 245);
        this.setTitle("CALCULADORA TESTE");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(this);
        this.setResizable(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.setUndecorated(true); // retira a barra superior da janela 
        
        KeyboardFocusManager
    .getCurrentKeyboardFocusManager()
    .addKeyEventDispatcher(this:: saida);
        
    }
    
    private  boolean saida(KeyEvent e){
        if(e.getID() == e.KEY_RELEASED 
                        && e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    dispose();
                    return true;
                }
                return false;
    }

    private void configurarElementos() {
        lblOperation = new JLabel("KKKKKKKKKKKKK");
        btns = new ArrayList<>();
        btnsOperation = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            this.btns.add(new JButton());
            this.btns.get(i).setForeground(Color.RED);
            this.btns.get(i).setBackground(Color.BLACK);
//            this.btns.get(i).setOpaque(false);
        }

        for (int i = 0; i <= 7; i++) {
            this.btnsOperation.add(new JButton());
            this.btnsOperation.get(i).setForeground(Color.black);
            this.btnsOperation.get(i).setBackground(Color.black);
//             this.btnsOperation.get(i).setOpaque(false);

        }

        btns.get(0).setBounds(104, 206, 37, 22);
        btns.get(1).setBounds(51, 172, 38, 22);
        btns.get(2).setBounds(104, 172, 37, 22);
        btns.get(3).setBounds(157, 172, 39, 23);
        btns.get(4).setBounds(51, 138, 38, 22);
        btns.get(5).setBounds(104, 138, 37, 22);
        btns.get(6).setBounds(157, 137, 39, 23);
        btns.get(7).setBounds(51, 102, 38, 24);
        btns.get(8).setBounds(104, 102, 37, 24);
        btns.get(9).setBounds(157, 102, 39, 24);

        this.btnsOperation.get(0).setBounds(157, 205, 39, 23); //igual
        this.btnsOperation.get(1).setBounds(452, 110, 39, 25); //delet
        this.btnsOperation.get(2).setBounds(210, 134, 39, 18); // soma
        this.btnsOperation.get(3).setBounds(210, 210, 39, 17); //multiplication
        this.btnsOperation.get(4).setBounds(210, 160, 39, 18);  // subtração
        this.btnsOperation.get(5).setBounds(210, 184, 39, 18);// divisão
        this.btnsOperation.get(6).setBounds(210, 102, 39, 24); //ac
        this.btnsOperation.get(7).setBounds(51, 206, 39, 23); // ponto

        this.lblCalculadora.setBounds(10, 0, 280, 245);

        this.lblOperation.setPreferredSize(new Dimension(1000,40)); //multiplication
        this.lblOperation.setForeground(new Color(0, 0, 0));
        this.lblOperation.setFont(new Font("Arial Black", Font.BOLD, 18));
        this.lblOperation.setText(("<html>&#128522;<hmtl>"));

    }

    private void configurarPanel() {
        jpCalc = new JPanel();
        sobre = new JPanel();
        lblCalculadora = new JLabel(icon);


        this.jpCalc.setLayout((null));
        this.jpCalc.setPreferredSize(new Dimension(300, 400));
        this.jpCalc.setBackground(Color.red);
        this.jpCalc.setOpaque(false);
        
        this.sobre.setLayout((new FlowLayout(FlowLayout.LEFT,0,0)));
        this.sobre.setBounds(55, 30, 190, 45);
        this.sobre.setBackground(Color.red);
        this.sobre.setOpaque(false);
        
        configurarElementos();
        this.add(this.jpCalc);
        this.jpCalc.add(this.sobre);
        this.jpCalc.add(this.lblCalculadora);
                this.sobre.add(this.lblOperation);

        this.btns.stream().forEach(jpCalc::add);
        this.btnsOperation.stream().forEach(jpCalc::add);

        this.btns.stream().forEach(e -> e.addActionListener(this::numbers));
        

    }

    private void numbers(ActionEvent e) {

    }

    

    protected class Pane extends JPanel {

        protected ImageIcon icon;

        public Pane(ImageIcon icon) {
            this.icon = icon;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Image img = icon.getImage();
            g.drawImage(img, 0, 0, this);
        }
    }

}

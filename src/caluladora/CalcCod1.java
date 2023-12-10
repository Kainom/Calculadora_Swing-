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
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
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

    private JPanel jpCalc;
    private JLabel lblOperation, lblCalculadora;
    private Pane painel;
    private List<JButton> btns, btnsOperation;
    private JButton igual, delet, soma, multiplicacao;
    private ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/Calc.png"));
    private ImageIcon imag = new ImageIcon(getClass().getResource("/imagens/fundo.jpg"));

    public CalcCod1() {

        configurarJanela();
        configurarPanel();
        this.lblCalculadora.setBounds(10, 0, 280, 245);

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
        painel = new Pane(imag);
        this.add(painel);
    }

    private void configurarElementos() {
        lblOperation = new JLabel("(:");
        btns = new ArrayList<>();
        btnsOperation = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            this.btns.add(new JButton());
            this.btns.get(i).setForeground(Color.RED);
            this.btns.get(i).setBackground(Color.BLACK);
//            this.btns.get(i).setOpaque(false);
        }

        for (int i = 0; i < 4; i++) {
            this.btnsOperation.add(new JButton());
            this.btnsOperation.get(i).setForeground(Color.black);
            this.btnsOperation.get(i).setBackground(Color.black);
//             this.btnsOperation.get(i).setOpaque(false);

        }
        
        
        btns.get(0).setBounds(102, 205, 39, 23);
        btns.get(1).setBounds(50, 172, 39, 23);
        btns.get(2).setBounds(104, 172, 37, 23);
        btns.get(3).setBounds(157, 172, 39, 23);
        btns.get(4).setBounds(50, 137, 39, 23);
        btns.get(5).setBounds(102, 137, 39, 23);
        btns.get(6).setBounds(157, 137, 39, 23);
        btns.get(7).setBounds(50, 102, 39, 25);
        btns.get(8).setBounds(102, 102, 39, 25);
        btns.get(9).setBounds(157, 102, 39, 24);

        this.btnsOperation.get(0).setBounds(157, 205, 39, 23); //igual
        this.btnsOperation.get(1).setBounds(452, 110, 39, 25); //delet
        this.btnsOperation.get(2).setBounds(210, 133, 39, 21); // soma
        this.btnsOperation.get(3).setBounds(210, 210, 39, 21); //multiplication

        this.lblOperation.setBounds(100, 80, 30, 20);
        this.lblOperation.setForeground(new Color(0, 0, 0));
        this.lblOperation.setFont(new Font("Arial Black", Font.BOLD, 18));

    }

    private void configurarPanel() {
        jpCalc = new JPanel();
        lblCalculadora = new JLabel(icon);

        this.painel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        this.jpCalc.setLayout((null));
        this.jpCalc.setPreferredSize(new Dimension(300, 400));
        this.jpCalc.setBackground(Color.red);
        this.jpCalc.setOpaque(false);

        configurarElementos();
        this.painel.add(this.jpCalc);
        this.jpCalc.add(this.lblCalculadora);
        this.btns.stream().forEach(jpCalc::add);
        this.btnsOperation.stream().forEach(jpCalc::add);
        this.jpCalc.add(this.lblOperation);
        

    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == this.bnt0 && verifica2 != 3) {
//            this.setN0("0"); // valor correspondente ao botão //
//            this.setMemoria(this.getMemoria() + this.getN0()); // Memória volátil que armazena os valores de todos os bnts //  
//            this.setTela(this.getTela() + this.getN0()); // Tela que expressa a operação para o usuária(possui caracteres especiais que não sao convertidos para a operação )//      
//            this.setVerifica(0); // valor que verifica o botão apertado // 
//            lbl2.setText(this.getTela()); // expressa o valor na tela em tempo real // 
//
//        } else if (e.getSource() == this.bnt && verifica2 != 3) {
//            this.setN1("1");
//            this.setMemoria(this.getMemoria() + this.getN1());   // Armazena o calculo //
//            this.setTela(this.getTela() + this.getN1());         // Armazena o conteudo do lbl //
//            this.setVerifica(1);
//            lbl2.setText(this.getTela());
//
//        } else if (e.getSource() == this.bnt1 && verifica2 != 3) {
//            this.setN2("2");
//            this.setMemoria(this.getMemoria() + this.getN2());
//            this.setTela(this.getTela() + this.getN2());
//            this.setVerifica(2);
//            lbl2.setText(this.getTela());
//
//        } else if (e.getSource() == this.bnt2 && verifica2 != 3) {
//            this.setN3("3");
//            this.setMemoria(this.getMemoria() + this.getN3());
//            this.setTela(this.getTela() + this.getN3());
//            this.setVerifica(3);
//            lbl2.setText(this.getTela());
//
//        } else if (e.getSource() == this.bnt3 && verifica2 != 3) {
//            this.setN4("4");
//            this.setMemoria(this.getMemoria() + this.getN4());
//            this.setTela(this.getTela() + this.getN4());
//            this.setVerifica(4);
//            lbl2.setText(this.getTela());
//
//        } else if (e.getSource() == this.bnt4 && verifica2 != 3) {
//            this.setN5("5");
//            this.setMemoria(this.getMemoria() + this.getN5());
//            this.setTela(this.getTela() + this.getN5());
//            this.setVerifica(5);
//            lbl2.setText(this.getTela());
//
//        } else if (e.getSource() == this.bnt5 && verifica2 != 3) {
//            this.setN6("6");
//            this.setMemoria(this.getMemoria() + this.getN6());
//            this.setTela(this.getTela() + this.getN6());
//            this.setVerifica(6);
//            lbl2.setText(this.getTela());
//
//        } else if (e.getSource() == this.bnt6 && verifica2 != 3) {
//            this.setN7("7");
//            this.setMemoria(this.getMemoria() + this.getN7());
//            this.setTela(this.getTela() + this.getN7());
//            this.setVerifica(7);
//            lbl2.setText(this.getTela());
//
//        } else if (e.getSource() == this.bnt7 && verifica2 != 3) {
//            this.setN8("8");
//            this.setMemoria(this.getMemoria() + this.getN8());
//            this.setTela(this.getTela() + this.getN8());
//            this.setVerifica(8);
//            lbl2.setText(this.getTela());
//
//        } else if (e.getSource() == this.bnt8 && verifica2 != 3) {
//            this.setN9("9");
//            this.setMemoria(this.getMemoria() + this.getN9());
//            this.setTela(this.getTela() + this.getN9());
//            this.setVerifica(9);
//            lbl2.setText(this.getTela());
//
//        } else if (e.getSource() == this.soma && this.getVerifica() != -1) {
//            if (this.multi >= 1 && this.soma1 == 0) {
//                this.setResultado(this.getResultado() * Integer.parseInt(this.getMemoria()));
//            } else {
//                this.setResultado(this.getResultado() + Integer.parseInt(this.getMemoria()));
//            }
//            if (this.verifica2 == 3 || this.verifica2 == 1) {
//                this.setResultado(this.getResultado() - 1);
//            }
//            this.setMemoria("");
//            this.setTela(this.getTela() + "+");
//            lbl2.setText(this.getTela());
//            this.setVerifica(-1);
//            this.verficaOperation = 1;
//            this.verifica2 = 0;
//            this.soma1++;
//
//        } else if (e.getSource() == this.multiplicacao && this.getVerifica() != -1) {
//            multi++;
//            if (soma1 >= 1 && multi >= 1) {
//                this.setResultado(this.getResultado() + Integer.parseInt(this.getMemoria()));
//                this.soma1 = 0;
//                this.multi = 0;
//            } else {
//                this.setResultado(this.getResultado() * Integer.parseInt(this.getMemoria()));
//            }
//
//            this.setMemoria("");
//            this.setTela(this.getTela() + "*");
//            lbl2.setText(this.getTela());
//            this.setVerifica(-1);       // impossibilita duplicata de simbolos // 
//            this.verficaOperation = 2;  // atribui o valor 2 que possui significado de multiplicação;
//            this.verifica2 = 0;         // Possibilita colocar demais numeros //
//
//        } else if (e.getSource() == this.igual && this.getVerifica() != -1) {
//            if (this.verficaOperation >= 1) { // verifica se houve operação // 
//                if (this.verficaOperation == 1) { // analísa o caráter da operação // 
//
//                    this.setResultado(this.getResultado() + Integer.parseInt(this.getMemoria()));
//                    this.setMemoria("1");// novamente Limpa a memória volátil // 
//                } else if (this.verficaOperation == 2) {
//
//                }
//                this.setResultado(this.getResultado() * Integer.parseInt(this.getMemoria()));
//                this.setMemoria("1");
//                this.setTela(Integer.toString(this.getResultado()));
//                lbl2.setText(this.getTela());
//                this.verficaOperation = 0;   // zera as operações // 
//                this.verifica2 = 3;     // impossibilita modificar o numero do resultado //            
//            }
//            this.soma1 = 0;
//            this.multi = 0;
//        } else {
//            lbl2.setText("ERROR"); // Concede erro se houver duplicata de simbolos,se houver // 
//        }                          // simbolos inicialmente antes de numeros, //
//        //se clicar no botão de igual sem completar a operação //
//        if (e.getSource() == this.delet) {
//            this.setResultado(1);           // seta 0 resultado inicial em 1 para não zerar na multiplicação // 
//            this.setMemoria(""); // Limpa a memória volátil // 
//            this.setTela(this.getMemoria()); // Limpar a tela
//            lbl2.setText("(:");
//            this.setVerifica(-1);  // impossibilita a discagem de símbolos antes de números //
//            this.verifica2 = 1;
//            this.soma1 = 0;
//            this.multi = 0;
//        }
//
//    }
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caluladora;

import com.towel.math.Expression;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author User
 */
public class CalcCod1 extends JFrame {

//    private String n0, n1, n2, n3, n4, n5, n6, n7, n8, n9, memoria = "", tela = "";
//    private int resultado, verifica = -1, verficaOperation = 0, verifica2 = 1, soma1, multi;
    private double resultado = 0, ac = 0;
    private JPanel jpCalc, sobre;
    private JLabel lblCalculadora;
    private JLabel lblOperation = new JLabel();
    private List<JButton> btnsFuncionalidades = Arrays.asList(new JButton(), new JButton());
    private List<JButton> btnsOperation = new ArrayList<>();
    private List<JButton> btns = new ArrayList<>();
    private char operatio[] = {'+', '*', '-', '/', '.'};

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
                .addKeyEventDispatcher(this::saida);

    }

    private boolean saida(KeyEvent e) {
        if (e.getID() == e.KEY_RELEASED
                && e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            dispose();
            return true;
        }
        return false;
    }

    private boolean numberBoard(KeyEvent e) {
        char cod = e.getKeyChar();

        if (e.getID() == e.KEY_RELEASED && cod >= 48 && cod <= 57) {
            this.lblOperation.setText(this.lblOperation.getText() + cod);
            return true;
        } else if(e.getID() == e.KEY_RELEASED){
            for (char operand : this.operatio) {
                if (operand == cod) {
                    this.lblOperation.setText(this.lblOperation.getText() + cod);
                }
            }
            if(cod == '(' || cod == ')'){
                System.out.println(cod);
                this.lblOperation.setText(this.lblOperation.getText() + cod);
            }

        }
        return false;
    }

    private void configurarElementos() {
        for (int i = 0; i < 10; i++) {
            this.btns.add(new JButton());
            this.btns.get(i).setForeground(Color.RED);
            this.btns.get(i).setBackground(Color.BLACK);
            this.btns.get(i).setText(i + "");
//            this.btns.get(i).setOpaque(false);
        }

        for (int i = 0; i <= 4; i++) {
            this.btnsOperation.add(new JButton());
            this.btnsOperation.get(i).setForeground(Color.black);
            this.btnsOperation.get(i).setBackground(Color.black);
            this.btnsOperation.get(i).setText("" + this.operatio[i]);
//             this.btnsOperation.get(i).setOpaque(false);

        }

        for (JButton btn : this.btnsFuncionalidades) {
            btn.setBackground(new Color(0, 0, 0));
            btn.setForeground(new Color(0, 0, 0));
//            btn.setOpaque(false);
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

        this.btnsOperation.get(0).setBounds(210, 134, 39, 18); // soma
        this.btnsOperation.get(1).setBounds(210, 210, 39, 17); //multiplication
        this.btnsOperation.get(2).setBounds(210, 160, 39, 18);  // subtração
        this.btnsOperation.get(3).setBounds(210, 184, 39, 18);// divisão
        this.btnsOperation.get(4).setBounds(51, 206, 39, 23); // ponto

        this.btnsFuncionalidades.get(0).setBounds(157, 205, 39, 23);  //igual
        this.btnsFuncionalidades.get(1).setBounds(210, 102, 39, 24); //AC

        this.lblCalculadora.setBounds(10, 0, 280, 245);

        this.lblOperation.setPreferredSize(new Dimension(1000, 40));
        this.lblOperation.setForeground(new Color(0, 0, 0));
        this.lblOperation.setFont(new Font("Arial Black", Font.BOLD, 18));
//        this.lblOperation.setText(("<html>&#128522;<hmtl>"));

    }

    private void configurarPanel() {
        jpCalc = new JPanel();
        sobre = new JPanel();
        lblCalculadora = new JLabel(icon);

        this.jpCalc.setLayout((null));
        this.jpCalc.setPreferredSize(new Dimension(300, 400));
        this.jpCalc.setBackground(Color.red);
        this.jpCalc.setOpaque(false);

        this.sobre.setLayout((new FlowLayout(FlowLayout.LEFT, 0, 0)));
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
        this.btnsFuncionalidades.stream().forEach(jpCalc::add);

        this.btnsFuncionalidades.stream().forEach(e -> e.addActionListener(this::funcionalidades));
        this.btnsOperation.stream().forEach(e -> e.addActionListener(this::operar));
        this.btns.stream().forEach(e -> e.addActionListener(this::numbers));
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this::numberBoard);
        try{KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(funcionalidade -> this.funcionalidadesKeyBoard(funcionalidade));}catch(NullPointerException ee){}

    }

    private boolean funcionalidadesKeyBoard(KeyEvent funcionalidade) {
        char funci = funcionalidade.getKeyChar();
        int condi = 0;
        Expression exp = new Expression(this.lblOperation.getText());

        if (funcionalidade.getID() == funcionalidade.KEY_RELEASED) {
            if (funci == '=') {
                try{
                resultado = exp.resolve();}catch(NullPointerException ee){
                    this.lblOperation.setText("ERRO");
                    return false;
                }
                System.out.println(resultado + "ok");
                this.lblOperation.setText(Double.toString(resultado));
                ac = resultado;
                resultado = 0;
            } else if(funcionalidade.getID() == funcionalidade.KEY_RELEASED && funci == 119){
                if (!(ac == 0)) { //funcionalidade A
                    int i = 0;
                    for (char c : this.operatio) {
                        if (-1 == this.lblOperation.getText().indexOf(c) && c != '.') {
                            i++;
                        }
                    }
                    if (i == 4) { // não há operador
                        condi = 1;
                        resultado = Double.parseDouble(this.lblOperation.getText()) * ac;
                        ac = resultado;
                        this.lblOperation.setText(("" + resultado));
                        

                    } else{
                        condi = 2;
                        this.lblOperation.setText(this.lblOperation.getText() + ac);
                    }
                }
            }

            if (funcionalidade.getID() == funcionalidade.KEY_RELEASED && funci == 127) { /// DEL
                this.lblOperation.setText("");
                this.ac = 0;
            } else if (funcionalidade.getID() == funcionalidade.KEY_RELEASED && funci == 8 && !(this.lblOperation.getText().equals(""))) {

                List<String> remove = new ArrayList<>(this.returnList());
                remove.remove(remove.size() - 1);
                String removido = remove.stream().collect(Collectors.joining(""));

                this.lblOperation.setText(removido);
            }

            return true;
        }
        return false;
    }

    public List<String> returnList() {
        List<String> Lista = new ArrayList<>();
        char array[] = this.lblOperation.getText().toCharArray();
        for (char d : array) {
            Lista.add("" + d);
        }
        return Lista;
    }

    private void funcionalidades(ActionEvent funcionalidade) {
        if(this.teste()==0){
        Expression exp = new Expression(this.lblOperation.getText());

        if (funcionalidade.getSource().equals(this.btnsFuncionalidades.get(0))) { // funcionalidade =

            resultado = exp.resolve();
            this.lblOperation.setText(Double.toString(resultado));
            ac = resultado;
            resultado = 0;

        } else if (!(ac == 0)) { //funcionalidade Ac
            int i = 0;
            for (char c : this.operatio) { // funcionalidade que multiplica automaticamente o  ac,caso o usuário nao informe operando,apenando colocando o ac ao lado do número
                if (-1 == this.lblOperation.getText().indexOf(c) && c != '.') {
                    System.out.println("d");
                    i++;
                }
            }
            if (i == 4) {
                this.lblOperation.setText(("" + Double.parseDouble(this.lblOperation.getText()) * ac));
                ac = 0;

            }
        }
        } else{
//            System.out.println("ERRO");
        }
    }

    private void operar(ActionEvent e) {

        this.btnsOperation.stream().forEach((btn) -> {
            String operador = btn.getText();
            if (e.getSource().equals(btn)) {
                System.out.println(operador);
                this.lblOperation.setText((this.lblOperation.getText() + operador));
            }
        });
    }

    private void numbers(ActionEvent e) {

        this.btns.stream().forEach((btn) -> {
            String numbers = btn.getText();
            if (e.getSource().equals(btn)) {
                this.lblOperation.setText(this.lblOperation.getText() + numbers);
            }
        });

    }

    private int teste() {
        char list[] = this.lblOperation.getText().toCharArray();
        int erro = 0;
        for(int i = 0; i< list.length-1;i++){
            if((list[i]>= 42 && list[i]<=47 ) && (list[i+1] >=42 && list[i+1] <=47)){
                erro ++;
            }
        }
        return (erro > 0)? 1:0;
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

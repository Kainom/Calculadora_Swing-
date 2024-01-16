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
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
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
    
    private double resultado = 0, ac = 0;
    private String expression = "";
    private JPanel jpCalc, jpSobre, jpBarTop;
    private JLabel lblCalculadora;
    private JLabel lblOperation = new JLabel();
    private JButton saida, miniz;
    private List<JButton> btnsBarMenu = Arrays.asList(new JButton(), new JButton());
    private List<JButton> btnsFuncionalidades = Arrays.asList(new JButton(), new JButton());
    private List<JButton> btnsOperation = new ArrayList<>();
    private List<JButton> btns = new ArrayList<>();
    private char operatio[] = {'+', '*', '-', '/', '.'};
    private Timer time;
    private Function<List<String>, String> recebeString = list -> list.stream().collect(Collectors.joining(""));
    private ActionListener tempo = (var event) -> {
        this.lblOperation.setText(" ");
        this.resultado = 0;
        this.ac = 0;
        time.stop();
    };
    
    private ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/Calc.png"));
    private ImageIcon imag = new ImageIcon(getClass().getResource("/imagens/fundo.jpg"));
    
    public CalcCod1() {
        
        configurarJanela();
        configurarPanel();
        configurarElementos();
        
    }
    
    private void configurarJanela() {
//        this.setSize(230, 245);
        this.setSize(230, 270);
        this.setTitle("CALCULADORA TESTE");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(this);
        this.setResizable(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.setUndecorated(true); // retira a barra superior da janela 

        KeyboardFocusManager
                .getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher(this::saida);
        
        this.time = new Timer(500, tempo);
        time.setRepeats(false);
        Move.add(this);
        
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
            this.transformAndTest();
            return true;
        } else if (e.getID() == e.KEY_RELEASED) {
            for (char operand : this.operatio) {
                if (operand == cod) {
                    this.lblOperation.setText(this.lblOperation.getText() + cod);
                    this.transformAndTest();
                }
            }
            if (cod == '(' || cod == ')') {
                this.lblOperation.setText(this.lblOperation.getText() + cod);
                this.transformAndTest();
                
            }
            
        }
        return false;
    }
    
    private void configurarElementos() {
        saida = new JButton("X");
        miniz = new JButton();
        
        for (int i = 0; i < 10; i++) {
            this.btns.add(new JButton());
            this.btns.get(i).setForeground(Color.white);
            this.btns.get(i).setBackground(Color.BLACK);
            this.btns.get(i).setText(i + "");
            this.btns.get(i).setBorder(null);
            this.btns.get(i).setContentAreaFilled(false);
            
        }
        
        for (int i = 0; i <= 4; i++) {
            this.btnsOperation.add(new JButton());
            this.btnsOperation.get(i).setForeground(Color.black);
            this.btnsOperation.get(i).setBackground(Color.black);
            this.btnsOperation.get(i).setText("" + this.operatio[i]);
            this.btnsOperation.get(i).setBorder(null);
            this.btnsOperation.get(i).setContentAreaFilled(false);
            
//             this.btnsOperation.get(i).setOpaque(false);

        }
        
        this.btnsFuncionalidades.forEach((btn) -> {
            btn.setBackground(new Color(0, 0, 0));
            btn.setForeground(new Color(0, 0, 0));
            btn.setBorder(null);
            btn.setContentAreaFilled(false);
//            btn.setOpaque(false);
        });
        
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
        
        this.btnsBarMenu.forEach((btn) -> {
            btn.setPreferredSize(new Dimension(30, 30));
            btn.setBackground(Color.black);
            btn.setForeground(Color.red);
            btn.setFont(new Font("Arial Black", Font.BOLD, 16));
            btn.setBorder(null);
            btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        });
        
        this.btnsBarMenu.get(0).setText(("<html>&#10060;<hmtl>"));
        this.btnsBarMenu.get(1).setText(("<html>&#8213;<hmtl>"));
        
    }
    
    private void configurarPanel() {
        jpCalc = new JPanel();
        jpSobre = new JPanel();
        jpBarTop = new JPanel();
        
        lblCalculadora = new JLabel(icon);
        
        this.jpCalc.setLayout((null));
        this.jpCalc.setPreferredSize(new Dimension(300, 400));
        this.jpCalc.setBackground(Color.red);
        this.jpCalc.setOpaque(false);
        
        this.jpSobre.setLayout((new FlowLayout(FlowLayout.LEFT, 0, 0)));
        this.jpSobre.setBounds(55, 30, 190, 45);
        this.jpSobre.setBackground(Color.red);
        this.jpSobre.setOpaque(false);
        
        this.jpBarTop.setLayout(new FlowLayout(FlowLayout.RIGHT, 3, 0));
        this.jpBarTop.setPreferredSize(new Dimension(230, 30));
        this.jpBarTop.setBackground(Color.black);
        
        configurarElementos();
        this.add(this.jpBarTop);
        this.add(this.jpCalc);
        this.btnsBarMenu.forEach(jpBarTop::add);
        this.jpCalc.add(this.jpSobre);
        this.jpCalc.add(this.lblCalculadora);
        this.jpSobre.add(this.lblOperation);
        
        this.btnsBarMenu.stream().forEach(e -> e.addActionListener(this::BarMenu));
        this.btns.stream().forEach(jpCalc::add);
        this.btnsOperation.stream().forEach(jpCalc::add);
        this.btnsFuncionalidades.stream().forEach(jpCalc::add);
        
        this.btnsFuncionalidades.stream().forEach(e -> e.addActionListener(this::funcionalidadesMouse));
        this.btnsOperation.stream().forEach(e -> e.addActionListener(this::operar));
        this.btns.stream().forEach(e -> e.addActionListener(this::numbers));
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this::numberBoard);
        try {
            KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(funcionalidade -> this.funcionalidadesKeyBoard(funcionalidade));
        } catch (NullPointerException ee) {
        }
        
    }
    
    private void BarMenu(ActionEvent event) {
        if (event.getSource().equals(this.btnsBarMenu.get(0))) {
            System.exit(0);
            
        } else if (event.getSource().equals(this.btnsBarMenu.get(1))) {
            this.setExtendedState(ICONIFIED);
        }
    }
    
    private boolean verficaQuantidade() {
        this.transformAndTest();
        int i = 0;
        
        System.out.println(expression + "Tomato");
        for (char c : operatio) {
            if (!(-1 == expression.indexOf(c + "")) || expression.charAt(i) == '(') {
                return true;
            }
            i++;
        }
        
        return false;
    }
    
    private boolean funcionalidadesKeyBoard(KeyEvent funcionalidade) {
        char funci = funcionalidade.getKeyChar();
        var cod = funcionalidade.getKeyCode();
        if (funcionalidade.getID() == funcionalidade.KEY_RELEASED) {
            if ((funci == '=' || cod == 10 || cod == 32)) {
                
                var cond = this.verficaQuantidade();
                if (cond) {
                    
                    if (this.calculo()) {
                        this.configurandoResultado();
                    } else {
                        this.houveErro();;
                    }
                }
                
            } else if (funcionalidade.getID() == funcionalidade.KEY_RELEASED && funci == 119) {
                if (!(ac == 0)) { //funcionalidade AC
                    this.lblOperation.setText(this.lblOperation.getText() + "Ans");
                    this.transformAndTest();
                }
            }
            
            if (funcionalidade.getID() == funcionalidade.KEY_RELEASED && funci == 127) { /// DEL
                this.del();
            } else if (funcionalidade.getID() == funcionalidade.KEY_RELEASED && funci == 8 && !(this.lblOperation.getText().equals(""))) { //BackSpace

                this.backSpace();
                
            }
            
            return true;
        }
        return false;
    }
    
    private void del() {
        this.lblOperation.setText("");
        this.ac = 0;
    }
    
    private void backSpace() {
        List<String> retira = new ArrayList<>(this.returnList());
        
        if (retira.get(retira.size() - 1).equals("s")) {
            retira.remove(retira.size() - 1);
            retira.remove(retira.size() - 1);
            
        }
        retira.remove(retira.size() - 1);
        String removido = retira.stream().collect(Collectors.joining(""));
        
        this.lblOperation.setText(removido);
        this.transformAndTest();
    }
    
    private List<String> returnList() {
        List<String> Lista = new ArrayList<>();
        char array[] = this.lblOperation.getText().toCharArray();
        for (char d : array) {
            Lista.add("" + d);
        }
        
        return Lista;
    }
    
    private void funcionalidadesMouse(ActionEvent funcionalidade) {
        
        if (this.verficaQuantidade() && (funcionalidade.getSource().equals(this.btnsFuncionalidades.get(0)))) { // funcionalidade =
            if (this.teste() && this.calculo()) {
                this.configurandoResultado();
            } else {
                this.houveErro();;
            }
            
        } else if (!(ac == 0)) { //funcionalidade Ac
            this.lblOperation.setText(this.lblOperation.getText() + "Ans");
            this.transformAndTest();
            
        }
        
    }
    
    private void houveErro() {
        this.lblOperation.setText("Syntax  ERROR");
        this.time.start();
    }
    
    private void configurandoResultado() {
        
        this.lblOperation.setText(Double.toString(resultado));
        ac = resultado;
        resultado = 0;
    }
    
    private boolean testaChar(String teste) {
        for (char c : this.operatio) {
            if (teste.equals(c + "")) {
                return true;
            }
        }
        return false;
    }
    
    private void transformAndTest() {
        List<String> listAc = new ArrayList<>(this.returnList());
        int checaAc = 0;
        
        for (int i = 0; i < listAc.size() - 1; i++) {
            if (listAc.get(i).equals("A") && i >= 1) {
                
                if (this.testaChar(listAc.get(i - 1))) {
                    listAc.add(i, ("" + this.ac));
                    this.removeAns(listAc, i);
                    checaAc++;
                    break;
                }
                if (checaAc == 0) {
                    listAc.add(i, ("*" + this.ac));
                    this.removeAns(listAc, i);
                    checaAc = 0;
                    
                }
                
                checaAc = 0;
            } else if (i == 0 && listAc.get(i).equals("A")) {
                listAc.add(i, ("" + this.ac));
                this.removeAns(listAc, i);
                
            }
            
        }
        
        this.expression = this.recebeString.apply(listAc);
        
        char tesd[] = this.expression.toCharArray();
        
        UnaryOperator<String> menosEmais = (sinal) -> {
            if (sinal.charAt(0) == 43 && sinal.charAt(1) == 45 || sinal.charAt(1) == 43 && sinal.charAt(0) == 45) {
                return "-";
            } else if (sinal.charAt(0) == 45 && sinal.charAt(1) == 45) {
                return "-";
            } else {
                return "+";
            }
        };
        
        UnaryOperator<String> times = sinal -> "*";
        this.expression = this.recebeString.apply(listAc);
        
        for (int i = 01; i < tesd.length - 1; i++) { // corrigindo o erro do usuário ao colocar ++ || -+ || -- || -+
            if ((tesd[i] == 43 || tesd[i] == 45) && (tesd[i + 1] == 43 || tesd[i + 1] == 45)) {
                String pega = listAc.get(i) + listAc.get(i + 1);
                
                listAc.remove(i);
                listAc.remove(i);
                
                listAc.add(i, menosEmais.apply(pega));
                this.lblOperation.setText(this.recebeString.apply(listAc));
                
            }
            if ((tesd[i] == 42 && tesd[i + 1] == 42)) {
                String pega = listAc.get(i) + listAc.get(i + 1);
                listAc.remove(i);
                listAc.remove(i);
                listAc.add(i, times.apply(pega));
                this.lblOperation.setText(this.recebeString.apply(listAc));
            }
            
        }
        
        this.expression = this.recebeString.apply(listAc);
        
        char tesdf[] = this.expression.toCharArray();
        
        for (int i = 1; i < tesdf.length - 1; i++) { // possiblitar essa expressão -> numero(numero)  -> transforma em : numero * (numero); // adiciona o * depois dos  parentesses 

            if (tesdf[i] == 42 && this.testaChar(tesdf[i - 1] + "")) {
                listAc.remove(i - 1);
            } else if (tesdf[i] == 42 && this.testaChar(tesdf[i + 1] + "")) {
                listAc.remove(i + 1);
            }
            if ((tesdf[i] == 40 && !this.testaChar(tesdf[i] + "")) && (!this.testaChar(tesdf[i - 1] + ""))) {
                listAc.add(i, "*");
            }
        }
        
        this.expression = this.recebeString.apply(listAc);
//        System.out.println(this.expression + " Transformada");
        System.out.println(listAc.toString() + " MOD");
        
    }
    
    private void removeAns(List removeAc, int num) {
        removeAc.remove(num + 1);
        removeAc.remove(num + 1);
        removeAc.remove(num + 1);
    }
    
    private boolean calculo() {
        System.out.println(this.expression + "Finaly");
        Expression exp = new Expression(this.expression);
        try {
            resultado = exp.resolve();
        } catch (Exception err) {
            return false;
        }
        return true;
    }
    
    private void operar(ActionEvent e) {
        
        this.btnsOperation.stream().forEach((btn) -> {
            String operador = btn.getText();
            if (e.getSource().equals(btn)) {
                System.out.println(operador);
                this.lblOperation.setText((this.lblOperation.getText() + operador));
                this.transformAndTest();
            }
        });
    }
    
    private void numbers(ActionEvent e) { // numeros selecionados pelos botões 

        this.btns.stream().forEach((btn) -> {
            String numbers = btn.getText();
            if (e.getSource().equals(btn)) {
                this.lblOperation.setText(this.lblOperation.getText() + numbers);
                this.transformAndTest();
            }
        });
        
    }
    
    private boolean teste() { //testa se há sequencia de operando ex:++
        this.transformAndTest();
//        char charVet[] = this.expression.toCharArray();
//        List list = this.returnList();
        int erro = 0;
////        for (int i = 0; i < charVet.length - 1; i++) {
////            if ((charVet[i] >= 42 && charVet[i] <= 47) && (charVet[i + 1] >= 42 && charVet[i + 1] <= 47)) {
////                 list.add(i,"(");
////                 list.add(i+2,")");
////            }
////        }
//        String agora ="";
//        for(Object t: list){
//            agora+= list.get(erro);
//            erro++;
//        }
//        System.out.println(agora +  "Agora");
//        this.expression = agora;
//        this.transforma();
//        erro = 0;

        return (erro == 0);
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

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
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.plaf.ColorUIResource;

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
    private List<JButton> btnsFuncionalidades = new ArrayList<>(Configura.listBtns(2, Color.black, Color.black, null, new ArrayList()));
    private List<JButton> btnsOperation = new ArrayList<>(Configura.listBtns(5, Color.black, Color.black, null, new ArrayList()));
    private List<JButton> btns = new ArrayList<>(Configura.listBtns(10, Color.black, Color.black, null, new ArrayList()));
    private List<String> operadores = Arrays.asList("*", "+", "-", "/");
    private List<Integer> bounds;
    private char sinals[] = {'+', '*', '-', '/', '.'};
    private Timer time;
    private BiPredicate<String, Integer> verificaTamanho = (verificado, tamanho) -> verificado.length() < tamanho;
    private Predicate<String> verificaChar = (k) -> this.operadores.parallelStream().anyMatch(te -> k.contains(te));

    private Function<List<String>, String> recebeListaDeString = list -> list.stream().collect(Collectors.joining(""));
    private ActionListener tempo = (var event) -> {
        this.lblOperation.setText("");
        this.resultado = 0;
        this.ac = 0;
        this.expression = "";
        time.stop();
    };

    private final BiConsumer<List<JButton>, String> consumidor = (e, texto) -> {
        int i = 0;
        for (JButton recebe : e) {
            if (texto.length() > 0) {
                recebe.setText(this.sinals[i] + "");
            } else {
                recebe.setText(i + "");
            }
            i++;
        }
    };

    Function<Double, String> zeros = (resultado) -> {
        String txt = Double.toString(resultado);
        List<String> lista = new ArrayList<>(this.returnListString(txt.toCharArray()));
        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i) == '.' && txt.charAt(i + 1) == '0') {
                lista.remove(i);
                lista.remove(i);
            }
        }
        return this.recebeListaDeString.apply(lista);
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

    private Consumer<String> zeroInicial = (cod) -> {
        if (this.lblOperation.getText().equals("0")) {
            this.lblOperation.setText(cod);
        } else {
            this.lblOperation.setText(this.lblOperation.getText() + cod);
        }
    };

    private boolean numberBoard(KeyEvent e) {
        char cod = e.getKeyChar();
        System.out.println(cod == '~');
        if (e.getID() == e.KEY_RELEASED && cod >= 48 && cod <= 57) {
            zeroInicial.accept(cod + "");
            this.transformAndTest();
            return true;
        } else if (e.getID() == e.KEY_RELEASED) {
            for (char operand : this.sinals) {
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

    private final BiConsumer<List<JButton>, List<Integer>> consum = (btn, bounds) -> {
        int i = 0;
        for (JButton t : btn) {
            t.setBounds(bounds.get(i), bounds.get(i + 1), bounds.get(i + 2), bounds.get(i + 3));
            i += 4;
        };
    };

    private void configurarElementos() {

        this.consumidor.accept(this.btns, "");
        this.consumidor.accept(this.btnsOperation, "2");

        Arrays.asList(104, 206, 37, 22, 51, 172, 38, 22, 104, 172, 37, 22, 157, 172, 39, 23, 51, 138, 38, 22, 104, 138, 37, 22, 157, 137, 39, 23, 51, 102, 38, 24, 104, 102, 37, 24, 157, 102, 39, 24);
        consum.accept(this.btns, Arrays.asList(104, 206, 37, 22, 51, 172, 38, 22, 104, 172, 37, 22, 157, 172, 39, 23, 51, 138, 38, 22, 104, 138, 37, 22, 157, 137, 39, 23, 51, 102, 38, 24, 104, 102, 37, 24, 157, 102, 39, 24));
        consum.accept(this.btnsOperation, Arrays.asList(210, 134, 39, 18, 210, 210, 39, 17, 210, 160, 39, 18, 210, 184, 39, 18, 51, 206, 39, 23));
        consum.accept(this.btnsFuncionalidades, Arrays.asList(157, 205, 39, 23, 210, 102, 39, 24));

        this.lblCalculadora.setBounds(
                10, 0, 280, 245);

        this.lblOperation.setPreferredSize(
                new Dimension(1000, 40));

        this.lblOperation.setForeground(
                new Color(0, 0, 0));

        this.lblOperation.setFont(
                new Font("Arial Black", Font.BOLD, 18));
    }

    private void configurarPanel() {
        jpCalc = new JPanel();
        jpSobre = new JPanel();
        jpBarTop = BarMenuSimple.bar(230, 30, new ColorUIResource(0, 0, 0), new FlowLayout(FlowLayout.RIGHT, 0, 0), 2, this);
        lblCalculadora = new JLabel(icon);
        Painels.configuraPainel(this.jpCalc, null, false, Color.red, new Dimension(300, 400));
        Painels.configuraPainel(this.jpSobre, new FlowLayout(FlowLayout.LEFT, 0, 0), false, Color.red, 55, 30, 190, 45);

        this.configurarElementos();
        this.add(this.jpBarTop);
        this.add(this.jpCalc);
        this.jpCalc.add(this.jpSobre);
        this.jpCalc.add(this.lblCalculadora);
        this.jpSobre.add(this.lblOperation);

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

    private boolean verficaQuantidade() {
//        if (this.lblOperation.getText().length() < 3) {
//            return false;
//        }

        if (this.verificaTamanho.test(this.lblOperation.getText(), 3)) {
            return false;
        }

        this.transformAndTest();
        int i = 0;

        for (char c : sinals) {
            if (c != '.') {
                if (!(-1 == expression.indexOf(c + "")) || expression.charAt(i) == '(') {
                    return true;
                }
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
        List<String> retira = new ArrayList<>(this.returnListString(this.lblOperation.getText().toCharArray()));

        if (retira.get(retira.size() - 1).equals("s")) {
            retira.remove(retira.size() - 1);
            retira.remove(retira.size() - 1);

        }
        retira.remove(retira.size() - 1);
        String removido = retira.stream().collect(Collectors.joining(""));

        this.lblOperation.setText(removido);
        this.transformAndTest();
    }

    private List<String> returnListString(char array[]) {
        List<String> lista = new ArrayList<>();
        for (char d : array) {
            lista.add(("" + d));
        }

        return lista;
    }

    private void funcionalidadesMouse(ActionEvent funcionalidade) {

        if (this.verficaQuantidade() && (funcionalidade.getSource().equals(this.btnsFuncionalidades.get(0)))) { // funcionalidade =
            if (this.calculo()) {
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

//        this.lblOperation.setText(Double.toString(resultado));
        this.lblOperation.setText(this.zeros.apply(this.resultado));
        ac = resultado;
        resultado = 0;
    }

    private void transformAndTest() {
        List<String> listAc = new ArrayList<>(this.returnListString(this.lblOperation.getText().toCharArray()));

        if (this.expression.contains("Infinity") && this.verificaChar.test(this.expression)) {
            this.houveErro();
            return;
        }

        for (int i = 0; i < listAc.size() - 1; i++) {
            if (listAc.get(i).equals("A") && i >= 1) {

                if (this.verificaChar.test(listAc.get(i - 1))) {
                    listAc.add(i, ("" + this.ac));
                    this.removeAns(listAc, i);

                } else { // nao tem operador,logo concluimos que é mutplicação (nAns -> n * Ans) 
                    System.out.println(listAc);
                    listAc.add(i, ("*" + this.ac));
                    this.removeAns(listAc, i);

                }

            } else if (i == 0 && listAc.get(i).equals("A")) {
                listAc.add(i, ("" + this.ac));
                this.removeAns(listAc, i);

            }

        }

        this.expression = this.recebeListaDeString.apply(listAc);

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
        this.expression = this.recebeListaDeString.apply(listAc);

        for (int i = 01; i < tesd.length - 1; i++) { // corrigindo o erro do usuário ao colocar ++ || -+ || -- || -+
            if ((tesd[i] == 43 || tesd[i] == 45) && (tesd[i + 1] == 43 || tesd[i + 1] == 45)) {
                String pega = listAc.get(i) + listAc.get(i + 1);

                listAc.remove(i);
                listAc.remove(i);

                listAc.add(i, menosEmais.apply(pega));
                this.lblOperation.setText(this.recebeListaDeString.apply(listAc));

            }
            if ((tesd[i] == 42 && tesd[i + 1] == 42)) {
                String pega = listAc.get(i) + listAc.get(i + 1);
                listAc.remove(i);
                listAc.remove(i);
                listAc.add(i, times.apply(pega));
                this.lblOperation.setText(this.recebeListaDeString.apply(listAc));
            }

        }

        this.expression = this.recebeListaDeString.apply(listAc);
        listAc.removeAll(listAc);
        for (int i = 0; i < this.expression.length(); i++) {
            listAc.add(this.expression.charAt(i) + "");
        }
        char tesdf[] = this.expression.toCharArray();

        BiFunction<List<String>, Integer, Integer> opera = (lista, index) -> {
            for (int i = index; i != 0; i--) {                    //  index =6           12+-222*222
                if (verificaChar.test(lista.get(i))) {
                    System.out.println(verificaChar.test(lista.get(i)));
                    return i;
                }
            }
            return 0;
        };

        for (int i = 1; i < tesdf.length - 1; i++) { // possiblitar essa expressão -> numero(numero)  -> transforma em : numero * (numero); // adiciona o * depois dos  parentesses 

            if ((tesdf[i] == 40 && !this.verificaChar.test(tesdf[i] + "")) && (!this.verificaChar.test(tesdf[i - 1] + ""))) {
                listAc.add(i, "*");
            }
        }

        this.expression = this.recebeListaDeString.apply(listAc);
        System.out.println(listAc.toString() + " MOD");

    }

    private void removeAns(List removeAc, int num) {
        removeAc.remove(num + 1);
        removeAc.remove(num + 1);
        removeAc.remove(num + 1);
    }

    private boolean calculo() {

        try {
            Expression exp = new Expression(this.expression);
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
                this.zeroInicial.accept(numbers);
                this.transformAndTest();
            }
        });

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

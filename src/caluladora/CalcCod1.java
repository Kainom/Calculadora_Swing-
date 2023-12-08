/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caluladora;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author User
 */
public class CalcCod1 extends JFrame implements ActionListener {

    private String n0, n1, n2, n3, n4, n5, n6, n7, n8, n9, memoria = "", tela = "";
    private int resultado, verifica = -1, verficaOperation = 0, verifica2 = 1, soma1, multi;

    public JLabel lbl2 = new JLabel("(:");
    public JButton bnt0;
    public JButton bnt;
    public JButton bnt1;
    public JButton bnt2;
    public JButton bnt3;
    public JButton bnt4;
    public JButton bnt5;
    public JButton bnt6;
    public JButton bnt7;
    public JButton bnt8;
    public JButton igual;
    public JButton delet;
    public JButton soma;
    public JButton multiplicacao;
    ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/Calc.png"));
    ImageIcon imag = new ImageIcon(getClass().getResource("/imagens/fundo.jpg"));

    public void setVerifica(int verifica) {
        this.verifica = verifica;
    }

    public int getVerifica() {
        return verifica;
    }

    public String getTela() {
        return tela;
    }

    public void setTela(String tela) {
        this.tela = tela;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public int getResultado() {
        return resultado;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setN0(String n0) {
        this.n0 = n0;
    }

    public void setN1(String n1) {
        this.n1 = n1;
    }

    public void setN2(String n2) {
        this.n2 = n2;
    }

    public void setN3(String n3) {
        this.n3 = n3;
    }

    public void setN4(String n4) {
        this.n4 = n4;
    }

    public void setN5(String n5) {
        this.n5 = n5;
    }

    public void setN6(String n6) {
        this.n6 = n6;
    }

    public void setN7(String n7) {
        this.n7 = n7;
    }

    public void setN8(String n8) {
        this.n8 = n8;
    }

    public void setN9(String n9) {
        this.n9 = n9;
    }

    public String getN0() {
        return n0;
    }

    public String getN5() {
        return n5;
    }

    public String getN6() {
        return n6;
    }

    public String getN7() {
        return n7;
    }

    public String getN8() {
        return n8;
    }

    public String getN9() {
        return n9;
    }

    public String getN1() {
        return n1;
    }

    public String getN2() {
        return n2;
    }

    public String getN3() {
        return n3;
    }

    public String getN4() {
        return n4;
    }

    public CalcCod1() {

        JLabel lbl = new JLabel(icon);
        this.setResultado(1);
        bnt0 = new JButton();
        bnt0.setBounds(346, 314, 37, 23);
        bnt0.setForeground(Color.RED);
        bnt0.setBackground(Color.BLACK);
        bnt0.setOpaque(false);
        bnt0.addActionListener(this);

        bnt = new JButton();   // 1
        bnt.setFont(new Font("Arial Black", Font.BOLD, 12));
        bnt.setBounds(292, 280, 39, 23);
        bnt.setForeground(Color.RED);
        bnt.setBackground(Color.BLACK);
        bnt.setOpaque(false);
        bnt.addActionListener(this);

        bnt1 = new JButton(); // 2
        bnt1.setFont(new Font("Arial Black", Font.BOLD, 20));
        bnt1.setBounds(346, 280, 37, 23);
        bnt1.setForeground(Color.RED);
        bnt1.setBackground(Color.BLACK);
        bnt1.setOpaque(false);
        bnt1.addActionListener(this);

        bnt2 = new JButton();  // 3
        bnt2.setFont(new Font("Arial Black", Font.BOLD, 20));
        bnt2.setBounds(398, 280, 39, 23);
        bnt2.setForeground(Color.RED);
        bnt2.setBackground(Color.BLACK);
        bnt2.setOpaque(false);
        bnt2.addActionListener(this);

        bnt3 = new JButton(); // 4
        bnt3.setBounds(292, 245, 39, 23);
        bnt3.setBackground(Color.BLACK);
        bnt3.setOpaque(false);
        bnt3.addActionListener(this);

        bnt4 = new JButton();  // 5
        bnt4.setBounds(346, 245, 37, 23);
        bnt4.setBackground(Color.BLACK);
        bnt4.setOpaque(false);
        bnt4.addActionListener(this);

        bnt5 = new JButton(); // 6
        bnt5.setBounds(398, 245, 39, 23);

        bnt5.setBackground(Color.BLACK);
        bnt5.setOpaque(false);
        bnt5.addActionListener(this);

        bnt6 = new JButton(); // 7
        bnt6.setBounds(292, 210, 39, 25);
        bnt6.setBackground(new Color(0, 0, 0));
        bnt6.setOpaque(false);
        bnt6.addActionListener(this);

        bnt7 = new JButton(); // 8
        bnt7.setBounds(346, 210, 37, 25);
        bnt7.setBackground(new Color(0, 0, 0));
        bnt7.setOpaque(false);
        bnt7.addActionListener(this);

        bnt8 = new JButton(); // 9
        bnt8.setBounds(398, 210, 39, 25);
        bnt8.setBackground(new Color(0, 0, 0));
        bnt8.setOpaque(false);
        bnt8.addActionListener(this);

        igual = new JButton();
        igual.setBounds(398, 314, 39, 23);
        igual.setBackground(Color.white);
        igual.setForeground(Color.white);
        igual.setOpaque(false);
        igual.addActionListener(this);

        delet = new JButton();
        delet.setBounds(452, 210, 39, 25);
        delet.setForeground(Color.red);
        delet.setBackground(Color.black);
        delet.setOpaque(false);
        delet.addActionListener(this);

        soma = new JButton();
        soma.setBounds(452, 242, 39, 18);
        soma.setForeground(Color.red);
        soma.setBackground(new Color(0, 0, 0));
        soma.setFont(new Font("Arial Black", Font.BOLD, 18));
        soma.setOpaque(false);
        soma.addActionListener(this);

        multiplicacao = new JButton();
        multiplicacao.setBounds(452, 317, 39, 17);
        multiplicacao.setForeground(Color.red);
        multiplicacao.setBackground(new Color(0, 0, 0));
        multiplicacao.setFont(new Font("Arial Black", Font.BOLD, 18));
        multiplicacao.addActionListener(this);
        multiplicacao.setOpaque(false);

        lbl2.setBounds(300, 130, 250, 70);
        lbl2.setForeground(new Color(0, 0, 0));
        lbl2.setFont(new Font("Arial Black", Font.BOLD, 18));

        this.add(bnt0);
        this.add(bnt);
        this.add(bnt1);
        this.add(bnt2);
        this.add(bnt3);
        this.add(bnt4);
        this.add(bnt5);
        this.add(bnt6);
        this.add(bnt7);
        this.add(bnt8);
        this.add(igual);
        this.add(delet);
        this.add(soma);
        this.add(multiplicacao);
        this.add(lbl2);
        this.add(lbl);

        this.setSize(800, 500);
        this.setTitle("CALCULADORA TESTE");
        Pane painel = new Pane(imag);
        this.add(painel);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(this);
        this.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.bnt0 && verifica2 != 3) {
            this.setN0("0"); // valor correspondente ao botão //
            this.setMemoria(this.getMemoria() + this.getN0()); // Memória volátil que armazena os valores de todos os bnts //  
            this.setTela(this.getTela() + this.getN0()); // Tela que expressa a operação para o usuária(possui caracteres especiais que não sao convertidos para a operação )//      
            this.setVerifica(0); // valor que verifica o botão apertado // 
            lbl2.setText(this.getTela()); // expressa o valor na tela em tempo real // 

        } else if (e.getSource() == this.bnt && verifica2 != 3) {
            this.setN1("1");
            this.setMemoria(this.getMemoria() + this.getN1());   // Armazena o calculo //
            this.setTela(this.getTela() + this.getN1());         // Armazena o conteudo do lbl //
            this.setVerifica(1);
            lbl2.setText(this.getTela());

        } else if (e.getSource() == this.bnt1 && verifica2 != 3) {
            this.setN2("2");
            this.setMemoria(this.getMemoria() + this.getN2());
            this.setTela(this.getTela() + this.getN2());
            this.setVerifica(2);
            lbl2.setText(this.getTela());

        } else if (e.getSource() == this.bnt2 && verifica2 != 3) {
            this.setN3("3");
            this.setMemoria(this.getMemoria() + this.getN3());
            this.setTela(this.getTela() + this.getN3());
            this.setVerifica(3);
            lbl2.setText(this.getTela());

        } else if (e.getSource() == this.bnt3 && verifica2 != 3) {
            this.setN4("4");
            this.setMemoria(this.getMemoria() + this.getN4());
            this.setTela(this.getTela() + this.getN4());
            this.setVerifica(4);
            lbl2.setText(this.getTela());

        } else if (e.getSource() == this.bnt4 && verifica2 != 3) {
            this.setN5("5");
            this.setMemoria(this.getMemoria() + this.getN5());
            this.setTela(this.getTela() + this.getN5());
            this.setVerifica(5);
            lbl2.setText(this.getTela());

        } else if (e.getSource() == this.bnt5 && verifica2 != 3) {
            this.setN6("6");
            this.setMemoria(this.getMemoria() + this.getN6());
            this.setTela(this.getTela() + this.getN6());
            this.setVerifica(6);
            lbl2.setText(this.getTela());

        } else if (e.getSource() == this.bnt6 && verifica2 != 3) {
            this.setN7("7");
            this.setMemoria(this.getMemoria() + this.getN7());
            this.setTela(this.getTela() + this.getN7());
            this.setVerifica(7);
            lbl2.setText(this.getTela());

        } else if (e.getSource() == this.bnt7 && verifica2 != 3) {
            this.setN8("8");
            this.setMemoria(this.getMemoria() + this.getN8());
            this.setTela(this.getTela() + this.getN8());
            this.setVerifica(8);
            lbl2.setText(this.getTela());

        } else if (e.getSource() == this.bnt8 && verifica2 != 3) {
            this.setN9("9");
            this.setMemoria(this.getMemoria() + this.getN9());
            this.setTela(this.getTela() + this.getN9());
            this.setVerifica(9);
            lbl2.setText(this.getTela());

        } else if (e.getSource() == this.soma && this.getVerifica() != -1) {
            if (this.multi >= 1 && this.soma1 == 0) {
                this.setResultado(this.getResultado() * Integer.parseInt(this.getMemoria()));
            } else {
                this.setResultado(this.getResultado() + Integer.parseInt(this.getMemoria()));
            }
            if (this.verifica2 == 3 || this.verifica2 == 1) {
                this.setResultado(this.getResultado() - 1);
            }
            this.setMemoria("");
            this.setTela(this.getTela() + "+");
            lbl2.setText(this.getTela());
            this.setVerifica(-1);
            this.verficaOperation = 1;
            this.verifica2 = 0;
            this.soma1++;

        } else if (e.getSource() == this.multiplicacao && this.getVerifica() != -1) {
            multi++;
            if (soma1 >= 1 && multi >= 1) {
                this.setResultado(this.getResultado() + Integer.parseInt(this.getMemoria()));
                this.soma1 = 0;
                this.multi = 0;
            } else {
                this.setResultado(this.getResultado() * Integer.parseInt(this.getMemoria()));
            }

            this.setMemoria("");
            this.setTela(this.getTela() + "*");
            lbl2.setText(this.getTela());
            this.setVerifica(-1);       // impossibilita duplicata de simbolos // 
            this.verficaOperation = 2;  // atribui o valor 2 que possui significado de multiplicação;
            this.verifica2 = 0;         // Possibilita colocar demais numeros //

        } else if (e.getSource() == this.igual && this.getVerifica() != -1) {
            if (this.verficaOperation >= 1) { // verifica se houve operação // 
                if (this.verficaOperation == 1) { // analísa o caráter da operação // 

                    this.setResultado(this.getResultado() + Integer.parseInt(this.getMemoria()));
                    this.setMemoria("1");// novamente Limpa a memória volátil // 
                } else if (this.verficaOperation == 2) {
                    
                }
                    this.setResultado(this.getResultado() * Integer.parseInt(this.getMemoria()));
                    this.setMemoria("1");
                    this.setTela(Integer.toString(this.getResultado()));
                    lbl2.setText(this.getTela());
                    this.verficaOperation = 0;   // zera as operações // 
                    this.verifica2 = 3;     // impossibilita modificar o numero do resultado //            
                }
                this.soma1 = 0;
                this.multi = 0;
            } else {
                lbl2.setText("ERROR"); // Concede erro se houver duplicata de simbolos,se houver // 
            }                          // simbolos inicialmente antes de numeros, //
            //se clicar no botão de igual sem completar a operação //
            if (e.getSource() == this.delet) {
                this.setResultado(1);           // seta 0 resultado inicial em 1 para não zerar na multiplicação // 
                this.setMemoria(""); // Limpa a memória volátil // 
                this.setTela(this.getMemoria()); // Limpar a tela
                lbl2.setText("(:");
                this.setVerifica(-1);  // impossibilita a discagem de símbolos antes de números //
                this.verifica2 = 1;
                this.soma1 = 0;
                this.multi = 0;
            }

        }

    }

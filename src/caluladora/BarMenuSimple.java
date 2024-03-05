/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caluladora;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author samuraiblack
 */
public final class BarMenuSimple {  //  this is class create a bar menu, able to close and minimize your window  it is very generic,however could are used in most of  cases

    private static JPanel jpBarTop = new JPanel();
//    private final static List<JButton> btnsBarMenu = Arrays.asList(new JButton(), new JButton())
    private static final Map<String, JButton> btnsBarMenu;
    private static JFrame cls;

    static {
        btnsBarMenu = Configura.mapBtns(2, Color.BLACK, Color.RED, 30, 30, new HashMap(), "close", "minimize");
    }

    private BarMenuSimple() {

    }

    public static void setBtnBackground(Color bg, String key) {
        btnsBarMenu.get(key).setBackground(bg);

    }

    public static void setBtnForeground(Color bg, String key) {
        btnsBarMenu.get(key).setForeground(bg);
    }

    public static void setBtnSize(Integer width, Integer heigth, String key) {
        btnsBarMenu.get(key).setPreferredSize(new Dimension(width, heigth));
    }

    public static void setFont(Font font, String key) {
        btnsBarMenu.get(key).setFont(font);
    }

    public static void setBtnText(String conteudo, String key) {
        btnsBarMenu.get(key).setText(conteudo);
    }

    public static void setBtnIcon(ImageIcon conteudo, String key) {
        btnsBarMenu.get(key).setIcon(conteudo);
    }

    public static JPanel bar(Integer width, Integer height, Color color, FlowLayout layout, Integer qtsBtns, JFrame classe) {
        cls = classe;

        if (width.equals(null) || height.equals(null) || color.equals(null) || layout.equals(null) || qtsBtns.equals(null)) {
            throw new NullPointerException("Null");
        }
        if (qtsBtns.equals(0) || width.equals(0) || height.equals(0)) {
            throw new IllegalArgumentException("0");
        }

        btnsBar(qtsBtns); // configuraçao dos bnts 

        jpBarTop.setLayout(layout);
        jpBarTop.setPreferredSize(new Dimension(width, height));
        jpBarTop.setBackground(color);
        btnsBarMenu.forEach(jpBarTop::add);

        btnsBarMenu.forEach((key, e) -> e.addActionListener((ActionEvent e1) -> {
            btnasActionMenu(e1);
        }));

        return jpBarTop;
    }

    private static void btnasActionMenu(ActionEvent event) {
        if (event.getSource().equals(btnsBarMenu.get("close"))) {
            System.exit(0);

        } else if (event.getSource().equals(btnsBarMenu.get("minimize"))) {
            cls.setExtendedState(ICONIFIED);
        }
    }

    public static void setBtnColor(String btnName, Color bg, Color fg) {
        btnsBarMenu.get(btnName).setBackground(bg);
        btnsBarMenu.get(btnName).setBackground(bg);

    }

    private static void btnsBar(Integer amount) {

        btnsBarMenu.forEach((key, btn) -> {
            btn.setPreferredSize(new Dimension(30, 30));
            btn.setBackground(Color.black);
            btn.setForeground(Color.red);
            btn.setFont(new Font("Arial Black", Font.BOLD, 16));
            btn.setBorder(null);
            btn.setFocusPainted(false);
            btn.setContentAreaFilled(false);
        });

        btnsBarMenu.get("close").setText(("<html>&#10060;<hmtl>"));
        btnsBarMenu.get("minimize").setText(("<html>&#8213;<hmtl>"));

        MouseAdapter ads = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource().equals(btnsBarMenu.get("close"))) {
                    btnsBarMenu.get("close").setFont(new Font("Arial Black", Font.BOLD, 32));

                }

                if (e.getSource().equals(btnsBarMenu.get("minimize"))) {
                    btnsBarMenu.get("minimize").setFont(new Font("Arial Black", Font.BOLD, 32));
                }

            }

            public void mouseExited(MouseEvent e) {
                if (e.getSource().equals(btnsBarMenu.get("close"))) {
                    btnsBarMenu.get("close").setFont(new Font("Arial Black", Font.BOLD, 16));

                }
                if (e.getSource().equals(btnsBarMenu.get("minimize"))) {
                    btnsBarMenu.get("minimize").setFont(new Font("Arial Black", Font.BOLD, 16));
                }

            }
        };
        btnsBarMenu.get("close").addMouseListener(ads);
        btnsBarMenu.get("minimize").addMouseListener(ads);
      
    }

}

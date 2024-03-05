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
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author samuraiblack
 */
public final class BarMenuSimple {  //  this is class create a bar menu, able to close and minimize your window  it is very generic,however could are used in most of  cases

    private static JPanel jpBarTop = new JPanel();
    private static final Map<String, JButton> btnsBarMenu;
    private static JFrame cls;

    static {
        btnsBarMenu = Configura.mapBtns(2, Color.BLACK, Color.RED,new Font("Arial Black", Font.BOLD, 16), 30, 30, new HashMap(), "close", "minimize");
    }

    private BarMenuSimple() {

    }

    
    public static JPanel bar(Integer width, Integer height, Color color, FlowLayout layout, Integer qtsBtns, JFrame classe) {
        cls = classe;

        if (width.equals(null) || height.equals(null) || layout.equals(null) || qtsBtns.equals(null)) {
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


    private static void btnsBar(Integer amount) {

       Configura.mapBtns(2, null,  Color.lightGray,new Font("Arial Black", Font.BOLD, 16), 30, 30, btnsBarMenu, "close","minimize");

        btnsBarMenu.get("close").setText(("<html>&#10060;<hmtl>"));
        btnsBarMenu.get("minimize").setText(("<html>&#8213;<hmtl>"));

       HoverEffect<String> hov = new HoverEffect();
        hov.hover(btnsBarMenu, "close","minimize");
    }

}

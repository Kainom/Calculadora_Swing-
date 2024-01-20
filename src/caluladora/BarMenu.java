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
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author samuraiblack
 */
public final class BarMenu {  //  this is class create a bar menu, able to close and minimize your window  it is very generic,however could are used in most of  cases

    private static JPanel jpBarTop = new JPanel();
    private static List<JButton> btnsBarMenu = Arrays.asList(new JButton(), new JButton());
    private static JFrame cls;

    private BarMenu() {
        
    }

    public static JPanel bar(Integer width, Integer height, Color color, FlowLayout layout,JFrame classe) {
        cls = classe;
        if (width == null || height == null || color == null || layout == null) {
            throw new NullPointerException("Null");
        }
        if (!(width instanceof Integer) || !(height instanceof Integer)) {
            throw new IllegalArgumentException("Not  is  Integer");
        }

        if (!(layout instanceof FlowLayout)) {
            throw new IllegalArgumentException("Not is  FlowLayout");
        }

        if (!(color instanceof Color)) {
            throw new IllegalArgumentException("Not is  Color");
        }
        btnsBar();
        
        jpBarTop.setLayout(layout);
        jpBarTop.setPreferredSize(new Dimension(width,height));
        jpBarTop.setBackground(color);
        btnsBarMenu.parallelStream().forEach(jpBarTop::add);
        
        btnsBarMenu.parallelStream().forEach(e -> e.addActionListener((ActionEvent e1) -> {  tarMenu(e1);
        }));

        
        return jpBarTop;
    }
    
    private static  void tarMenu(ActionEvent event) {
        if (event.getSource().equals(btnsBarMenu.get(0))) {
            System.exit(0);
            
        } else if (event.getSource().equals(btnsBarMenu.get(1))) {
            cls.setExtendedState(ICONIFIED);
        }
    }

    private static void btnsBar() {

           btnsBarMenu.forEach((btn) -> {
            btn.setPreferredSize(new Dimension(30, 30));
            btn.setBackground(Color.black);
            btn.setForeground(Color.red);
            btn.setFont(new Font("Arial Black", Font.BOLD, 16));
            btn.setBorder(null);
            btn.setFocusPainted(false);
            btn.setContentAreaFilled(false);
        });

        btnsBarMenu.get(0).setText(("<html>&#10060;<hmtl>"));
        btnsBarMenu.get(1).setText(("<html>&#8213;<hmtl>"));
        
    }
}

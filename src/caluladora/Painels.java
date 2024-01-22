/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caluladora;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 *
 * @author samuraiblack
 */
public abstract class Painels {

    private Painels() {

    }

    public static void configuraPainel(JPanel jp, LayoutManager layout, Boolean opaco, Color background, Dimension dimension) {
        jp.setLayout(layout);
        jp.setPreferredSize(dimension);
        jp.setBackground(background);
        jp.setOpaque(opaco);
    }

    public static void configuraPainel(JPanel jp, LayoutManager layout, Boolean opaco, Color background, Integer w, Integer h, Integer x, Integer y) {
        configuraPainel(jp, layout, opaco, background, null);
        jp.setBounds(w, h, x, y);

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caluladora;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author samuraiblack
 */
public final class Configura {

    private static List<JButton> btns;

    private Configura() {

    }

    public static List<JButton> btns(int quantidade, Color background, Color foreground) {
        btns = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            btns.add(new JButton());
            btns.get(i).setForeground(Color.white);
            btns.get(i).setBackground(Color.BLACK);
//            btns.get(i).setBorder(null);
//            btns.get(i).setContentAreaFilled(false);
            //btns.get(i).setOpaque(false);

        }
        return btns;
    }

}

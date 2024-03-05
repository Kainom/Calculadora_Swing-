/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caluladora;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;

/**
 *
 * @author samuraiblack
 */
public final class Configura {

    private static List<JButton> btnsList;
    private static Map<String, JButton> btnsMap;

    private Configura() {

    }

    public static <T extends List> List<JButton> listBtns(int quantidade, Color bgColor, Color fgColor,Font font,T tipo) {
        btnsList = tipo;
        for (int i = 0; i < quantidade; i++) {
            btnsList.add(new JButton());
            btnsList.get(i).setForeground(fgColor);
            btnsList.get(i).setBackground(bgColor);
//              btnsList.get(i).setBorder(null);
//              btnsList.get(i).setContentAreaFilled(false);
//              btnsList.get(i).setFocusPainted(false);

        }
        return btnsList;
    }

    public static <T extends Map> Map<String, JButton> mapBtns(int quantidade, Color bgColor, Color fgColor, Font font,int weight, int height, T tipo,String... btnsName) {
        if (btnsName.length != quantidade) {
            throw new IllegalArgumentException();
        }
        btnsMap = tipo;
        for (int i = 0; i < quantidade; i++) {
            btnsMap.put(btnsName[i], new JButton());
            btnsMap.get(btnsName[i]).setForeground(fgColor);
            btnsMap.get(btnsName[i]).setBackground(bgColor);
            btnsMap.get(btnsName[i]).setBorder(null);
            btnsMap.get(btnsName[i]).setContentAreaFilled(false);
            btnsMap.get(btnsName[i]).setFocusPainted(false);
            btnsMap.get(btnsName[i]).setPreferredSize(new Dimension(weight = (weight <= 10) ? 30 : weight, height = (height <= 5) ? 30 : height));
            btnsMap.get(btnsName[i]).setFont(font);

        }
        return btnsMap;
    }

}

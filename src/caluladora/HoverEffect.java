/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caluladora;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;

/**
 *
 * @author kainom
 */
public class HoverEffect<T> {

    private TriFunction<List<JButton>, MouseEvent, Integer> aplica = (btn, e, f) -> {
        for (int i = 0; i < btn.size(); i++) {
            if (e.getSource().equals(btn.get(i))) {
                btn.get(i).setFont(new Font("Arial Black", Font.BOLD, f));

            }

            if (e.getSource().equals(btn.get(i))) {
                btn.get(i).setFont(new Font("Arial Black", Font.BOLD, f));
            }
        }
    };

    private SixFunction<Map<T, JButton>, MouseEvent, Integer, Color,Color,T> aplicas = (btn, e, f,fgColor,bgColor, chaves) -> {
        for (int i = 0; i < btn.size(); i++) {
            if (e.getSource().equals(btn.get(chaves[i]))) {
                btn.get(chaves[i]).setFont(new Font("Arial Black", Font.BOLD, f));
                btn.get(chaves[i]).setForeground(fgColor);
                btn.get(chaves[i]).setBackground(bgColor);

            }
        }
    };

    public HoverEffect() {

    }

    private MouseAdapter configura(List<JButton> algo) {
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                aplica.apply(algo, e, 32);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                aplica.apply(algo, e, 16);
            }
        };
        return adapter;
    }

    private  MouseAdapter configura(Map<T, JButton> algo, T ...chaves) {
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                aplicas.apply(algo, e, 32,Color.red,null,chaves);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                aplicas.apply(algo, e, 16,Color.lightGray,null,chaves);
            }
        };
        return adapter;
    }

    public void hover(List<JButton> bnts) {
        Integer itera = 0;
        while (itera < bnts.size()) {
            bnts.get(itera).addMouseListener(configura(bnts));
            itera++;
        }
    }

    public  void hover(Map<T, JButton> bnts, T...chaves) {
        Integer itera = 0;
        while (itera < bnts.size()) {
            bnts.get(chaves[itera]).addMouseListener(configura(bnts, chaves));
            itera++;
        }
    }
}

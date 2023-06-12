package Changing_the_text_font;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
public class ChangingTheTextFont {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Тут текст");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFrame frame2 = new JFrame("Увеличивает текст");
        frame2.setSize(300, 200);
        frame2.setLocation(400, 5);

        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Метка");
        panel.add(label, BorderLayout.CENTER);

        JSlider slider = new JSlider(0, 100, 0);
        slider.setMajorTickSpacing(25);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        JPanel panel2 = new JPanel();
        panel2.add(slider);
        slider.addChangeListener(new ChangeListener() {
                    public void stateChanged(ChangeEvent e) {
                        int fontSize = slider.getValue();
                        label.setFont(new Font("Serif", Font.BOLD, fontSize));
                        label.setPreferredSize(new Dimension(200, fontSize + 10));
                    }
        });
        frame2.add(panel2);
        frame2.setVisible(true);

        frame.add(panel);
        frame.setVisible(true);
    }
}
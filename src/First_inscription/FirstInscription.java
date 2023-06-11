package First_inscription;

import javax.swing.*;
import java.awt.*;

public class FirstInscription {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Моя первая надпись!");
        label.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(label);
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
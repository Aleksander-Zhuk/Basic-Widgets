package MyJRadioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJRadioButton {
    public static void main(String[] args) {
        Myframe myframe = new Myframe();
        myframe.setVisible(true);
    }
}
class Myframe extends JFrame {

    public Myframe () {
        setSize(400,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Mypanel mypanel = new Mypanel();

        add(mypanel);
    }
}
class Mypanel extends JPanel {
    public Font font = new Font("Serif", Font.BOLD, 20);
    public Mypanel() {
        JRadioButton rb1 = new JRadioButton();
        rb1.setFont(font);
        rb1.setText("Зима");
        JRadioButton rb2 = new JRadioButton();
        rb2.setFont(font);
        rb2.setText("Весна");
        JRadioButton rb3 = new JRadioButton();
        rb3.setFont(font);
        rb3.setText("Лето");
        JRadioButton rb4 = new JRadioButton();
        rb4.setFont(font);
        rb4.setText("Осень");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, -10, 5, 0);

        ButtonGroup group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);
        group.add(rb3);
        group.add(rb4);

        add(rb1,gbc);
        gbc.gridy = 1;
        gbc.insets = new Insets(8, 0, 0, 0);
        add(rb2,gbc);
        gbc.gridy = 2;
        gbc.insets = new Insets(10, -10, 0, 0);
        add(rb3,gbc);
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 0, 0, 0);
        add(rb4,gbc);

        gbc.gridy = 4;
        gbc.insets = new Insets(20, 0, 0, 0);
        Mybuton mybuton = new Mybuton();
        add(mybuton,gbc);

        gbc.gridy = 5;
        gbc.insets = new Insets(20, 0, 0, 0);
        JLabel label = new JLabel();
        label.setFont(new Font("Serif", Font.BOLD, 20));
        label.setText("Ответ: ");
        add(label,gbc);
        mybuton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rb1.isSelected()){
                    String name = rb1.getText();
                    label.setFont(new Font("Serif", Font.BOLD, 20));
                    label.setText("Ответ: " + name);
                    add(label, gbc);
                    revalidate();
                }
                else {
                    if (rb2.isSelected()){
                        String name = rb2.getText();
                        label.setFont(new Font("Serif", Font.BOLD, 20));
                        label.setText("Ответ: " + name);
                        add(label, gbc);
                        revalidate();
                    }
                    else {
                        if (rb3.isSelected()){
                            String name = rb3.getText();
                            label.setFont(new Font("Serif", Font.BOLD, 20));
                            label.setText("Ответ: " + name);
                            add(label, gbc);
                            revalidate();
                        }
                        else {
                            if (rb4.isSelected()){
                                String name = rb4.getText();
                                label.setFont(new Font("Serif", Font.BOLD, 20));
                                label.setText("Ответ: " + name);
                                add(label, gbc);
                                revalidate();
                            }
                        }
                    }
                }
            }
        });
    }
}
class Mybuton extends JButton {
    public Mybuton() {
        setFont(new Font("Serif", Font.BOLD, 20));
        setText("Ответ");
        setPreferredSize(new Dimension(150,40));
    }
}

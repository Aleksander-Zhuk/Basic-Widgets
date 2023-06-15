package JSpinner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jspinnerr {
    public static void main(String[] args) {

        Myframe myframe = new Myframe();
        Mypanel mypanel = new Mypanel();
        myframe.add(mypanel);
        myframe.setVisible(true);

    }
}
class Myframe extends JFrame {
    Myframe () {
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class Mypanel extends JPanel {
    Mypanel () {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 20, 0);
        Myspinner myspinner = new Myspinner();
        add(myspinner, gbc);
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 0, 0);
        Mybutton mybutton = new Mybutton();
        add(mybutton, gbc);
        gbc.gridy = 2;
        gbc.insets = new Insets(40, 0, 0, 0);
        JLabel label = new JLabel("Ответ:");
        label.setFont(new Font("Serif", Font.BOLD, 20));
        add(label, gbc);
        mybutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = myspinner.getStringValue();
                label.setFont(new Font("Serif", Font.BOLD, 20));
                label.setText("Ответ: "+value);
                add(label,gbc);
                revalidate();
            }
        });
        setPreferredSize(new Dimension(400, 400));
    }
}
class Myspinner extends JSpinner {
    public String getStringValue() {
        return getValue().toString();
    }
    Myspinner () {
        setPreferredSize(new Dimension(50, 30));
        setValue(0);
    }
}
class Mybutton extends JButton {
    Mybutton () {
        setFont(new Font("Serif", Font.BOLD, 20));
        setText("Ответить");
        setPreferredSize(new Dimension(150,40));
    }
}
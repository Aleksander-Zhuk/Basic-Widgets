package MyComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyComboBox {
    public static void main(String[] args) {

        Myframe myframe = new Myframe();
        Mypanel mypanel = new Mypanel();
        myframe.add(mypanel);

        JLabel label = new JLabel("Ответ:");
        label.setFont(new Font("Serif", Font.BOLD, 20));

        myframe.setVisible(true);
    }
}
class Myframe extends JFrame {
    public Myframe () {
        setSize(400,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class Mypanel extends JPanel {
    public Mypanel () {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 20, 0);
        Mycombox mycombox = new Mycombox();
        add(mycombox,gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 0, 0);
        JCheckBox checkBox = new JCheckBox("Свой вариант");
        checkBox.setFont(new Font("Serif", Font.BOLD, 20));
        add(checkBox,gbc);

        gbc.gridy = 2;
        gbc.insets = new Insets(40, 0, 0, 0);
        JTextField textField =new JTextField(20);
        add(textField,gbc);

        gbc.gridy = 3;
        gbc.insets = new Insets(40, 0, 0, 0);
        Mybuton mybuton = new Mybuton();
        add(mybuton,gbc);

        gbc.gridy = 4;
        gbc.insets = new Insets(30, 0, 0, 0);
        JLabel label = new JLabel("Ответ: ");
        label.setFont(new Font("Serif", Font.BOLD, 20));

        checkBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()) {
                    textField.setEnabled(true);
                } else {
                    textField.setEnabled(false);
                    label.setText("");
                }
            }
        });
        mybuton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()) {
                    String response = textField.getText();
                    label.setFont(new Font("Serif", Font.BOLD, 20));
                    label.setText("Ответ: " + response);
                    add(label, gbc);
                    revalidate();
                } else {
                    String response = mycombox.getStringValue();
                    label.setFont(new Font("Serif", Font.BOLD, 20));
                    label.setText("Ответ: " + response);
                    add(label, gbc);
                    revalidate();
                }
            }
        });
        textField.setEnabled(false);

        setPreferredSize(new Dimension(400, 400));
    }
}
class Mycombox extends JComboBox<String> {
    public String getStringValue() {
        return getSelectedItem().toString();
    }
    public Mycombox() {
        String[] items = {"Синий", "Красный", "Жёлтый", "Черный", "Белый"};
        setModel(new DefaultComboBoxModel(items));
    }
}
class Mybuton extends JButton {
    public Mybuton() {
        setFont(new Font("Serif", Font.BOLD, 20));
        setText("Ответ");
        setPreferredSize(new Dimension(150,40));
    }
}
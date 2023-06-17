package MyJTextArea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJTextArea {
    public static void main(String[] args) {

        Myframe myframe = new Myframe();
        Mypanel mypanel = new Mypanel();
        myframe.add(mypanel);

        myframe.setVisible(true);
    }
}
class Myframe extends JFrame {
    public Myframe () {
        setSize(400,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}class Mypanel extends JPanel {
    public Mypanel () {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 20, 0);

        JTextField textField =new JTextField(20);
        add(textField,gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 0, 0);

        Mybuton mybuton = new Mybuton();
        add(mybuton,gbc);

        gbc.gridy = 2;
        gbc.insets = new Insets(40, 0, 0, 0);
        JTextArea myTextArea = new JTextArea();
        JScrollPane scroupPanel =new JScrollPane(myTextArea);
        scroupPanel.setPreferredSize(new Dimension(200, 100));
        scroupPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroupPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scroupPanel,gbc);
        mybuton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                myTextArea.append(text + "\n");
                revalidate();
                textField.setText("");
            }
        });
        setPreferredSize(new Dimension(400, 450));
    }
}
class Mybuton extends JButton {
    public Mybuton() {
        setFont(new Font("Serif", Font.BOLD, 20));
        setText("Запись");
        setPreferredSize(new Dimension(150,40));
    }
}
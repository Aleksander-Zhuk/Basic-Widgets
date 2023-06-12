package Clicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clicker {
    public static void main(String[] args) {
        Myframe myframe = new Myframe();
        Mypanel mypanel = new Mypanel();
        myframe.add(mypanel);
        myframe.setVisible(true);
    }
}
class Myframe extends JFrame {
    Myframe () {
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class Mypanel extends JPanel {
    Mypanel () {
        add(new Mybutton());
    }
}
class Mybutton extends JButton {
    private int number=0;
    Mybutton () {
        setSize(50, 10);
        setText("Вы нажали "+number+" раз");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number++;
                setText("Вы нажали "+number+" раз");
            }
        });
    }
}
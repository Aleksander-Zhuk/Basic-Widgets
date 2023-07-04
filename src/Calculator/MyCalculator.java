package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MyCalculator {
    public static void main(String[] args) {
        new Myframe();
    }
}
class Myframe extends JFrame implements ActionListener {
    private final JPanel panel;
    private final JTextField textField;
    private final JButton[] buttons;
    private final String[] buttonLabels = { "1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "C", "0", "=", "/" };
    private int num1 = 0;
    private int num2 = 0;
    int result;
    private boolean register = false;
    private boolean flag = false;
    private char operator = '.';
    private char operator2 = '.';
    public Myframe() throws HeadlessException {
        setTitle("Calculator");
        setSize(400,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Font font = new Font("Impact",Font.BOLD,60);

        panel = new JPanel();

        panel.setBackground(new Color(72,214,24));
        panel.setLayout(new GridLayout(4, 4,5,5));

        textField = new JTextField();
        textField.setFont(font);
        textField.setText("");
        textField.setBackground(new Color(107, 247, 254));
        textField.setForeground(new Color(117, 2, 202));
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);

        buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].addActionListener(this);
            buttons[i].setForeground(new Color(236,0,6));
            buttons[i].setFont(font);
            panel.add(buttons[i]);
        }
        add(textField, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand();

        if (textField.getText().equals("ERROR")) {
            register = false;
            textField.setText("");}

        if (buttonText.matches("[0-9]")){
            if (textField.getText().equals("")) {
                if (buttonText.matches("0")) return;
                textField.setText("");
                textField.setText(textField.getText() + buttonText);
                num1 = Integer.parseInt(textField.getText());
            }
            else {
                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    num2 = num1;
                    textField.setText("");
                    textField.setText(textField.getText() + buttonText);
                    num1 = Integer.parseInt(textField.getText());
                    operator2 = operator;
                    operator = '.';
                    flag = true;
                }
                else {
                    if (register) {
                        textField.setText("");
                        register = false;
                    }
                    textField.setText(textField.getText() + buttonText);
                    num1 = Integer.parseInt(textField.getText());
                    }
                }
            }
        else {
            if (buttonText.equals("+")){
                if (textField.getText().equals("")) return;
                char plus = textField.getText().charAt(textField.getText().length() - 1);
                if (plus == '+') return;
                if (plus == '-' || plus == '*' || plus == '/'){
                    operator = '+';
                    textField.setText(textField.getText().replace(plus, operator));
                }
                else {
                    if (flag) {
                        switch (operator2) {
                            case '+' -> {
                                result = num2 + num1;
                                num1 = result;
                            }
                            case '-' -> {
                                result = num2 - num1;
                                num1 = result;
                            }
                            case '*' -> {
                                result = num2 * num1;
                                num1 = result;
                            }
                            case '/' -> {
                                if (num1 == 0) {
                                    textField.setText("ERROR");
                                    flag = false;
                                    operator2 = '.';
                                    operator = '.';
                                    return;
                                }
                                else {
                                    result = num2 / num1;
                                    num1 = result;
                                }
                            }
                        }
                        textField.setText(result + buttonText);
                        operator = '+';
                        flag = false;
                    }
                    else {
                        if (register) num1 = Integer.parseInt(textField.getText());
                        textField.setText(textField.getText() + buttonText);
                        operator = '+';
                        register = false;
                    }
                }
            }
            else {
                if (buttonText.equals("-")){
                    if (textField.getText().equals("")) return;
                    char plus = textField.getText().charAt(textField.getText().length() - 1);
                    if (plus == '-') return;
                    if (plus == '+' || plus == '*' || plus == '/'){
                        operator = '-';
                        textField.setText(textField.getText().replace(plus, operator));
                    }
                    else {
                        if (flag) {
                            switch (operator2) {
                                case '+' -> {
                                    result = num2 + num1;
                                    num1 = result;
                                }
                                case '-' -> {
                                    result = num2 - num1;
                                    num1 = result;
                                }
                                case '*' -> {
                                    result = num2 * num1;
                                    num1 = result;
                                }
                                case '/' -> {
                                    if (num1 == 0) {
                                        textField.setText("ERROR");
                                        flag = false;
                                        operator2 = '.';
                                        operator = '.';
                                        return;
                                    }
                                    else {
                                        result = num2 / num1;
                                        num1 = result;
                                    }
                                }
                            }
                            textField.setText(result + buttonText);
                            operator = '-';
                            flag = false;
                        }
                        else {
                            if (register) num1 = Integer.parseInt(textField.getText());
                            textField.setText(textField.getText() + buttonText);
                            operator = '-';
                            register = false;
                        }
                    }
                }
                else {
                    if (buttonText.equals("*")){
                        if (textField.getText().equals("")) return;
                        char plus = textField.getText().charAt(textField.getText().length() - 1);
                        if (plus == '*') return;
                        if (plus == '-' || plus == '+' || plus == '/'){
                            operator = '*';
                            textField.setText(textField.getText().replace(plus, operator));
                        }
                        else {
                            if (flag) {
                                switch (operator2) {
                                    case '+' -> {
                                        result = num2 + num1;
                                        num1 = result;
                                    }
                                    case '-' -> {
                                        result = num2 - num1;
                                        num1 = result;
                                    }
                                    case '*' -> {
                                        result = num2 * num1;
                                        num1 = result;
                                    }
                                    case '/' -> {
                                        if (num1 == 0) {
                                            textField.setText("ERROR");
                                            flag = false;
                                            operator2 = '.';
                                            operator = '.';
                                            return;
                                        }
                                        else {
                                            result = num2 / num1;
                                            num1 = result;
                                        }
                                    }
                                }
                                textField.setText(result + buttonText);
                                operator = '*';
                                flag = false;
                            }
                            else {
                                if (register) num1 = Integer.parseInt(textField.getText());
                                textField.setText(textField.getText() + buttonText);
                                operator = '*';
                                register = false;
                            }
                        }
                    }
                    else {
                        if (buttonText.equals("/")){
                            if (textField.getText().equals("")) return;
                            char plus = textField.getText().charAt(textField.getText().length() - 1);
                            if (plus == '/') return;
                            if (plus == '-' || plus == '*' || plus == '+'){
                                operator = '/';
                                textField.setText(textField.getText().replace(plus, operator));
                            }
                            else {
                                if (flag) {
                                    switch (operator2) {
                                        case '+' -> {
                                            result = num2 + num1;
                                            num1 = result;
                                        }
                                        case '-' -> {
                                            result = num2 - num1;
                                            num1 = result;
                                        }
                                        case '*' -> {
                                            result = num2 * num1;
                                            num1 = result;
                                        }
                                        case '/' -> {
                                            if (num1 == 0) {
                                                textField.setText("ERROR");
                                                flag = false;
                                                operator2 = '.';
                                                operator = '.';
                                                return;
                                            }
                                            else {
                                                result = num2 / num1;
                                                num1 = result;
                                            }
                                        }
                                    }
                                        textField.setText(result + buttonText);
                                        operator = '/';
                                        flag = false;
                                    }
                                else {
                                    if (register) num1 = Integer.parseInt(textField.getText());
                                    textField.setText(textField.getText() + buttonText);
                                    operator = '/';
                                    register = false;
                                }
                            }
                        }
                        else {
                            if (buttonText.equals("=")){
                                if (operator == '.' & operator2 == '.') return;

                                char plus = textField.getText().charAt(textField.getText().length() - 1);
                                if (plus == '+' || plus == '-' || plus == '*' || plus == '/'){
                                    num2 = num1;
                                    switch (operator) {
                                        case '+' -> result = num2 + num1;
                                        case '-' -> result = 0;
                                        case '*' -> result = num2 * num1;
                                        case '/' -> {
                                            if (num1 == 0) {
                                                textField.setText("ERROR");
                                                operator = '.';
                                                operator2 = '.';
                                                flag = false;
                                                register = true;
                                                return;
                                            }
                                            else {
                                                result = num2 / num1;
                                            }
                                        }
                                    }
                                    textField.setText(String.valueOf(result));
                                    operator = '.';
                                    operator2 = '.';
                                    flag = false;
                                    register = true;
                                }
                                else {
                                    switch (operator2) {
                                    case '+' -> result = num2 + num1;
                                    case '-' -> result = num2 - num1;
                                    case '*' -> result = num2 * num1;
                                    case '/' -> {
                                        if (num1 == 0) {
                                            textField.setText("ERROR");
                                            operator = '.';
                                            operator2 = '.';
                                            flag = false;
                                            register = true;
                                            return;
                                        }
                                        else {
                                            result = num2 / num1;
                                        }
                                    }
                                }
                                textField.setText(String.valueOf(result));
                                operator = '.';
                                operator2 = '.';
                                flag = false;
                                register = true;
                                }
                            }
                            else {
                                if (buttonText.equals("C")){
                                    textField.setText("");
                                    operator = '.';
                                    operator2 = '.';
                                    num1 = 0;
                                    num2 = 0;
                                    result = 0;
                                    register = false;
                                    flag = false;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
package Quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Quiz {
    public static void main(String[] args) {
        new Myframe();
    }
}
class Myframe extends JFrame {
    private Font font = new Font("Impact",Font.BOLD,20);
    Myframe () {
        setTitle("Викторина");
        setSize(800,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        Mypanel1 mypanel1 = new Mypanel1();
        add(mypanel1);
        setVisible(true);
    }
}
class Mypanel1 extends JPanel implements ActionListener {
    private Font font = new Font("verdana",Font.BOLD,20);
    JLabel label = new JLabel();
    JLabel counter = new JLabel();
    JButton button_start = new JButton("Начать.");
    JButton button1 = new JButton();
    JButton button2 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();
    String[] questions = {
            "Викторина на тему  « планеты Солнечной системы » ",
            "Сколько спутников у Марса?",
            "<html><font face=’verdana’ size = 6>"+
                    "Самый большой вулкан Солнечной системы<br>"+
                    " называется «Гора Олимп».<br>"+
                    " Где он находится?</html>",
            "Какая планета ближе всех расположена к Солнцу?",
            "Большое красное пятно на Юпитере, что это?",
            "Из чего в основном состоит Солнце?",
            "Из чего в основном состоят кометы?",
            "К какой планете принадлежат спутники Оберон и Титания?",
            "<html><font face=’verdana’ size = 6>"+
                    "Какой из вариантов лучше всего<br>"+
                    "описывает атмосферу, окружающую Венеру?</html>",
            "Где находится пояс астероидов?",
            "Какая из этих планет самая маленькая?"};
    String[] answers1 = {
            "",
            "13",
            "Юпитер",
            "Земля",
            "Вулкан",
            "Жидкая лава",
            "Ядовитая жидкость",
            "Юпитер",
            "Яркая и солнечная",
            "<html><font face=’verdana’ size = 6>"+
                    "       Между<br>"+
                    "Юпитером и Сатурном</html>",
            "Юпитнр"};
    String[] answers2 = {
            "",
            "2",
            "Земля",
            "Венера",
            "Озеро",
            "Расплавленный метал",
            "Лед и пыль",
            "Уран",
            "Холодная и снежная",
            "<html><font face=’verdana’ size = 6>"+
                    "     Между<br>"+
                    "Землёй и Венерой</html>",
            "Сатурн"};
    String[] answers3 = {
            "",
            "20",
            "Марс",
            "Меркурий",
            "Буря",
            "Газ",
            "Ржавый метал",
            "Венера",
            "Холодная и влажная",
            "<html><font face=’verdana’ size = 6>"+
                    "      Между<br>"+
                    "Марсом и Юпитером</html>",
            "Земля"};
    String[] answers4 = {
            "",
            "1",
            "Венера",
            "Нептун",
            "Кратер",
            "Камунь",
            "Расплавленный камень",
            "Земля",
            "Горячая и ядовитая",
            "<html><font face=’verdana’ size = 6>"+
                    "     Между<br>"+
                    "Землёй и Марсом</html>",
            "Меркурий"};
    int[] correct_answers = {2,3,3,3,3,2,2,4,3,4};
    int [] responses_received = new int[10];
    int i = 0;
    Mypanel1 () {
        setSize(800,650);
        setLayout(null);

        counter.setFont(font);
        counter.setSize(175,20);
        counter.setLocation(575,2);

        label.setFont(font);
        label.setSize(700,150);
        label.setLocation(50,25);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        label.setText(questions[i]);
        label.setVisible(true);
        add(label);

        button_start.setFont(font);
        button_start.setSize(300,50);
        button_start.setLocation(250,300);
        button_start.addActionListener(this);
        add(button_start);

        button1.setFont(font);
        button1.setText(answers1[i]);
        button1.setSize(325,175);
        button1.setLocation(50,200);
        button1.addActionListener(this);

        button2.setFont(font);
        button2.setText(answers2[i]);
        button2.setSize(325,175);
        button2.setLocation(425,200);
        button2.addActionListener(this);

        button3.setFont(font);
        button3.setText(answers3[i]);
        button3.setSize(325,175);
        button3.setLocation(50,400);
        button3.addActionListener(this);

        button4.setFont(font);
        button4.setText(answers4[i]);
        button4.setSize(325,175);
        button4.setLocation(425,400);
        button4.addActionListener(this);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawRect(50,25,700,150);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        int b = 0;

        if (i >= 1){
            if (e.getSource() == button1) b=1;
            if (e.getSource() == button2) b=2;
            if (e.getSource() == button3) b=3;
            if (e.getSource() == button4) b=4;
            System.out.println(b);
            responses_received [i-1] = b;
        }
        if (i == 10){
            int a = 0;
            for (int c = 0; c < correct_answers.length; c++){
                if (correct_answers[c] == responses_received[c]) a++;
            }
            removeAll();
            label.setText("Вы ответили правильно на: "+a+" из 10.");
            add(label);
            revalidate();
            repaint();
            return;
        }
        i++;
        removeAll();

        counter.setText("Вопрос "+i+"/10");
        label.setText(questions[i]);
        button1.setText(answers1[i]);
        button2.setText(answers2[i]);
        button3.setText(answers3[i]);
        button4.setText(answers4[i]);

        add(counter);
        add(label);
        add(button1);
        add(button2);
        add(button3);
        add(button4);

        revalidate();
        repaint();
    }
}

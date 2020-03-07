package ru.spbu.apmath.prog;

import javax.swing.*;
import java.awt.*;

public class Score extends Component {
    int myscore = 10;
    int x = 0;
    int y = 0;
    JLabel label= new JLabel("Ваш счет: ");

    public void create(){
        JFrame f = new JFrame("Cчётчик очков");
        f.setLayout(new FlowLayout());
        f.setSize(100, 100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(label);
        f.setVisible(true);
    }


    public void update() {
        myscore++;
    }
    public void render(){
        label.setText("Ваш счет: " + (String.valueOf(myscore)));
    }

    public void recreate() {
        myscore = 0;
    }


}

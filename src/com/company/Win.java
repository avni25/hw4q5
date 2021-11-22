package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.company.MovingDot;


public class Win extends JFrame implements ActionListener {

    JButton mybuton = new JButton("Move dot");
    JButton mybuton2 = new JButton("Calculator");

    /**
     * COnstructor:
     * 2 butonlu bir pencere olusturur.
     * */
    public Win(){
        setLayout(new FlowLayout());
        setTitle("my Window");
        setLocationRelativeTo(this);
        setSize(250,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(mybuton);
        add(mybuton2);
        mybuton.addActionListener(this);
        mybuton2.addActionListener(this);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==mybuton){
            System.out.println("move win");
            MovingDot m = new MovingDot();      //Moving dot penceresini acar


        }else if(e.getSource() == mybuton2){
            System.out.println("calculator");
            Calculator cal = new Calculator();  // hesap makinesini acar
        }
    }
}

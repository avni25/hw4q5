package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovingDot extends JFrame implements KeyListener {

    JPanel p = new JPanel();
    JLabel label = new JLabel("use arrow keys to move the dot.");
    /**
     * x, ve y degiskenleri global tanimlanmistir.
     * bu degiskenler noktanin x, ve y koordinatlarini belirler. diger fonksiyonlarda da kullanilabilmesi
     * icin global tanimlanmistir
     * */
    private static int x = 150, y = 150;

    /**
     * Object ilk olusturuldugunda asagidaki kodlara gore pencere olusur
     * title, size, componentler eklenmis ve ayarlanmistir.
     * */
    public MovingDot(){
        setLayout(new FlowLayout());
        setTitle("my Window");
        setSize(300, 300);
        setLocationRelativeTo(this);
        p.setSize(10,10);
        p.setBackground(Color.BLUE);
        p.setVisible(true);
        addKeyListener(this);
        add(label);
        add(p);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * hangi tusa basildiginda ne yapilacagini gosterir
     * 4 yon tusuyla mavi nokta 4 yone hareket eder.
     * yukarı ok tusu ile yukari dogru 10 birim ilerler
     * diger yonler icinde ayni harelketi yapar
     * aciklama olarak label eklenmistir
     * */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_RIGHT){            // sag tusa basildiysa
            System.out.println("right: "+p.getX()+" - "+p.getY());
            this.x+=10;                                 // x i 10 artirir ve
            p.setLocation(this.x,this.y);               //panelin(noktanin) pozisyonunu gunceller
        }else if(e.getKeyCode()== KeyEvent.VK_LEFT){
            System.out.println("left: "+p.getX()+" - "+p.getY());
            x-=10;
            p.setLocation(x,y);
        }else if(e.getKeyCode()== KeyEvent.VK_UP){
            System.out.println("up: "+p.getX()+" - "+p.getY());
            y-=10;
            p.setLocation(x,y);
        }else if(e.getKeyCode()== KeyEvent.VK_DOWN){
            System.out.println("down: "+p.getX()+" - "+p.getY());
            y+=10;
            p.setLocation(x,y);
        }else{
            System.out.println("invalid key!!!");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

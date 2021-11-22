package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;


public class Calculator extends JFrame implements ActionListener {

    public String script ="", op="", res ="0";  //script degiskeni textfielda girilen karakterleri tutmada kullanilacak
    Double val1=0.0, val2=0.0, result=0.0;
    int toggle = 0;         // toogle degiskeni girilen degerin val1 e mi yoksa val2 yemi atanacagini belirlemede kullnilacak
    public JButton[] buttons;
    public JTextField tf = new JTextField();
    public JLabel string_res = new JLabel(res);     //label da sonuc gosterilecek
    public String[] button_texts ={"CLS", "BCK", "±", "CLOSE",      //tuslarin textleri
                                    "7",   "8",  "9", "/",
                                    "4",   "5",  "6", "*",
                                    "1",   "2",  "3", "-",
                                    "0",   ",",  "=", "+"};
    /**
     * Constructor:
     * 3 tane panel bulunmaktadir.
     * en ustte sonucu gosteren label
     * ortada textfield
     * alt panelde tuslar bulunmaktadir
     *
     *
     * */
    public Calculator(){
        setLayout(new BorderLayout());
        setTitle("my Calculator");
        setLocationRelativeTo(this);
        setSize(350,300);
        JPanel resp = new JPanel(new GridLayout(1,1,5,5));
        JPanel upp = new JPanel(new GridLayout(1,1,10,10));
        JPanel downp = new JPanel(new GridLayout(5,5,10,10));
        tf.setFont(new java.awt.Font("Times New Roman", 0,20));
        string_res.setFont(new java.awt.Font("Times New Roman", 0,28));
        resp.add(string_res);
        upp.add(tf);
        buttons = new JButton[button_texts.length];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(button_texts[i]);
            buttons[i].addActionListener(this);
            downp.add(buttons[i],i);
        }
        add(resp, BorderLayout.NORTH);
        add(upp, BorderLayout.CENTER);
        add(downp, BorderLayout.SOUTH);

        setVisible(true);
    }

    /**
     * burada her tusun ne islem yaptigi tanımlanmistir
     *
     * */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttons[0]){            //CLS  button
            tf.setText("");                         //textfield sifirlanir
            string_res.setText("");                 // label text sifirlanir
            val1 =0.0;                              // val1- val2 ve result degerleri sifirlanir
            val2=0.0;
            result = 0.0;
            script="";                              // script degeri sifirlanir
        }
        else if(e.getSource() == buttons[4]) script +=7;
        else if(e.getSource() == buttons[5]) script +=8;
        else if(e.getSource() == buttons[6]) script +=9;
        else if(e.getSource() == buttons[7]){               //division

            if(toggle==0){                                  // toggle degiskeni sifirsa
                this.val1 = Double.parseDouble(script);     //girilen degeri val1 e ata
                toggle=1;                                   //sonraki atama icin toggle ayarlar
            }else{
                this.val2 = Double.parseDouble(script);     // toggle ==1 ise val2 ye atar
                toggle=0;
            }
            System.out.println(val1+"-"+val2);
            string_res.setText(script+"/");                 //sounc labelina ilk girilen sayiyi yazar
            op="/";                                         //operation degiskenine yapilacak iselmi atar
            script ="";                                     //script degiskeni bir sonraki deger icin sifirlanir

        }
        else if(e.getSource() == buttons[8]) script +=4;
        else if(e.getSource() == buttons[9]) script +=5;
        else if(e.getSource() == buttons[10]) script +=6;
        else if(e.getSource() == buttons[11]){              //multiplication

            if(toggle==0){
                this.val1 = Double.parseDouble(script);
                toggle=1;
            }else{
                this.val2 = Double.parseDouble(script);
                toggle=0;
            }
            System.out.println(val1+"-"+val2);
            string_res.setText(script+"*");
            op="*";
            script ="";

        }
        else if(e.getSource() == buttons[12]) script +=1;
        else if(e.getSource() == buttons[13]) script +=2;
        else if(e.getSource() == buttons[14]) script +=3;
        else if(e.getSource() == buttons[15]){              // subtraction

            if(toggle==0){
                this.val1 = Double.parseDouble(script);
                toggle=1;
            }else{
                this.val2 = Double.parseDouble(script);
                toggle=0;
            }
            System.out.println(val1+"-"+val2);
            string_res.setText(script+"-");
            op="-";
            script ="";

        }
        else if(e.getSource() == buttons[16]) script +=0;
        else if(e.getSource() == buttons[17]) script +=".";
        else if(e.getSource() == buttons[18]){              //equals button
            if(toggle==0){
                this.val1 = Double.parseDouble(script);
                toggle=1;
            }else{
                this.val2 = Double.parseDouble(script);
                toggle=0;
            }
            if(op =="+") result = val1+val2;
            else if(op =="-") result = val1-val2;
            else if(op =="*") result = val1*val2;
            else if(op =="/") result = val1/val2;
            string_res.setText(result+"");              //islem sonrasi sifiirlama islemleir
            val1=0.0;
            val2=0.0;
            tf.setText("");
            script="";
        }
        else if(e.getSource() == buttons[19]){              // sum button

            if(toggle==0){
                this.val1 = Double.parseDouble(script);
                toggle=1;
            }else{
                this.val2 = Double.parseDouble(script);
                toggle=0;
            }
            System.out.println(val1+"-"+val2);
            string_res.setText(script+"+");
            op="+";
            script ="";

        }

        tf.setText(script);         // tuslara basma sonrasi textfielda goruntulenir
    }
}

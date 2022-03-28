package company;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    public void menu_window(){

        JFrame frame=new JFrame("Formula1 League Championship");
        ImageIcon backgroungimg=new ImageIcon("src\\shutterstock_762930772.jpg");
        JLabel blabel=new JLabel(backgroungimg);


        JLabel heading=new JLabel("Formula1 Championship Menu");
        JButton b1=new JButton("Show Table");
        JButton b2=new JButton("Add a Race");
        JButton b3=new JButton("statrting position");

        JButton b6=new JButton("Search...");
        JButton b7=new JButton("Race details");

        heading.setForeground(Color.WHITE);
        heading.setFont(heading.getFont().deriveFont(30f));

        Font  font  = new Font(Font.DIALOG_INPUT,  Font.BOLD, 15);
        Border whiteline = BorderFactory.createLineBorder(Color.white);
        Border compound;

        b1.setBounds(550,150,220,60);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setFont(font);
        b1.setBorder(whiteline);

        b2.setBounds(550,250,220,60);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setFont(font);
        b2.setBorder(whiteline);

        b3.setBounds(550,350,220,60);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setFont(font);
        b3.setBorder(whiteline);

        b6.setBounds(550,450,220,60);
        b6.setBackground(Color.black);
        b6.setForeground(Color.white);
        b6.setFont(font);
        b6.setBorder(whiteline);

        b7.setBounds(550,550,220,60);
        b7.setBackground(Color.black);
        b7.setForeground(Color.white);
        b7.setFont(font);
        b7.setBorder(whiteline);


        heading.setBounds(450,25,750,75);


        frame.add(b1);
        frame.add(b2);
        frame.add(b3);

        frame.add(b6);
        frame.add(b7);
        frame.add(heading);

        frame.setSize(1200, 675);


        frame.add(blabel);

        blabel.setBounds(0,0,1000,1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        /*show table button method*/
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TableGUI( );
                frame.setVisible(false);
            }
        });
        /*add random driver button method*/
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PosGUI( );
                frame.setVisible(false);
            }
        });
        /*search button method*/
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUIsearch( );
                frame.setVisible(false);
            }
        });
        /*date button method*/
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new sortDate( );
                frame.setVisible(false);
            }
        });
        /*probability button method */
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GUIStartpos( );

                frame.setVisible(false);
            }
        });

    }
}
//references----------->https://www.tutorialspoint.com/how-to-create-defaulttablemodel-which-is-an-implementation-of-tablemodel
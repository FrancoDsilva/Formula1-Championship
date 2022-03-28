package company;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static company.Formula1ChampionshipManager.drivernames;

public class PosGUI {

    Formula1ChampionshipManager formula1ChampionshipManager=new Formula1ChampionshipManager();

     PosGUI() {
         ImageIcon backgroungimg1=new ImageIcon("src\\493129.jpg");
         JLabel blabel1=new JLabel(backgroungimg1);


         JButton btn=new JButton("Add Race");
         JLabel label=new JLabel("Genarate a random race");

         btn.setBounds(750,400,175,75);
         Font  font  = new Font(Font.DIALOG_INPUT,  Font.BOLD, 15);
         Border whiteline = BorderFactory.createLineBorder(Color.white);
         Border compound;
         btn.setBackground(Color.black);
         btn.setForeground(Color.white);
         btn.setFont(font);
         btn.setBorder(whiteline);

         label.setBounds(650,250,450,75);



         JFrame frame=new JFrame("Driver Position");
         JFrame f = new JFrame();
         label.setForeground(Color.BLACK);
         label.setFont(label.getFont().deriveFont(35f));
         f.setSize(1200, 800);
       //  f.setLayout(null);
         f.setVisible(true);
         f.add(btn);
         f.add(label);
         f.add(blabel1);

         /*calling adding random races method by a button*/
         btn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 formula1ChampionshipManager.GUIaddrace();

             }
         });
     }
}








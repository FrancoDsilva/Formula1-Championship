package company;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import static company.Formula1ChampionshipManager.drivernames;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class TableGUI {
    GUIcomparator gui=new GUIcomparator();
    TableGUI() {

        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        table.setBounds(100,200,30,40);
        JButton ascending=new JButton("Ascending");
        JButton descending=new JButton("Descending");



        tableModel.addColumn("Names");
        tableModel.addColumn("Team");
        tableModel.addColumn("Location");
        tableModel.addColumn("Points");
        tableModel.addColumn("Race count");
        tableModel.addColumn("1st Position");
        tableModel.addColumn("2nd Position");
        tableModel.addColumn("3rd Position");




        drivernames.sort(new GUIcomparator());
        for (Formula1driver formula1driver : drivernames) {

                tableModel.insertRow(0, new Object[]{formula1driver.getName(), formula1driver.getDriverteam(), formula1driver.getLocation(), formula1driver.getPoints(),
                        formula1driver.getRacecount(), formula1driver.getNo_of_first_pos(), formula1driver.getNo_of_second_pos(), formula1driver.getNo_of_third_pos()});


        }
            Dimension dim = new Dimension(20,1);
            table.setIntercellSpacing(new Dimension(dim));


           // Border padding = BorderFactory.createEmptyBorder(0, 10, 0, 10);\


            ascending.setBounds(450,280,100,50);
            Font  font  = new Font(Font.DIALOG_INPUT,  Font.BOLD, 15);
            Border whiteline = BorderFactory.createLineBorder(Color.white);
            Border compound;
            ascending.setBackground(Color.black);
            ascending.setForeground(Color.white);
            ascending.setFont(font);
            ascending.setBorder(whiteline);

            descending.setBounds(600,280,150,50);
            descending.setBackground(Color.black);
            descending.setForeground(Color.white);
            descending.setFont(font);
            descending.setBorder(whiteline);

            JFrame f = new JFrame();

            table.getTableHeader().setBackground(Color.GRAY);
            table.setBackground(Color.cyan);
            table.setAutoCreateRowSorter(true);
            f.add(ascending);
            f.add(descending);
            f.setSize(1200, 800);
            f.add(new JScrollPane(table));
            f.setVisible(true);
        /*sort according to points' ascennding order*/
             ascending.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new GUIAscending( );
                    f.setVisible(false);
                }
            });







    }
}
//references----------------------->https://www.tutorialspoint.com/how-to-create-defaulttablemodel-which-is-an-implementation-of-tablemodel
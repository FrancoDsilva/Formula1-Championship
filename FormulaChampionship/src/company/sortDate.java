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

/*sort date*/
public class sortDate {

    GUIcomparator gui=new GUIcomparator();
    sortDate() {

        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        table.setBounds(100,200,30,40);




        tableModel.addColumn("Date");
        tableModel.addColumn("Name");
        tableModel.addColumn("Team Name");
        tableModel.addColumn("Position");
        tableModel.addColumn("Points");


        /*Calling sort method to sort dates*/
        DatesComparator datesorter=new DatesComparator();
        datesorter.sortGUI();
        for (Formula1driver formula1driver : drivernames) {
            tableModel.insertRow(0, new Object[]{formula1driver.getDatestore(),formula1driver.getName(),
                    formula1driver.getDriverteam(),formula1driver.getPosition(),formula1driver.getPoints() });
        }

        Dimension dim = new Dimension(20,1);
        table.setIntercellSpacing(new Dimension(dim));

        table.getTableHeader().setBackground(Color.GRAY);

        JFrame f = new JFrame();
        table.setBackground(Color.yellow);
        table.setAutoCreateRowSorter(true);

        f.setSize(1200, 800);
        f.add(new JScrollPane(table));
        f.setVisible(true);







    }
}

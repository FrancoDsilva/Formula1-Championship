package company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import static company.Formula1ChampionshipManager.drivernames;

public class GUIsearch {
    GUIsearch() {
        JFrame frame = new JFrame("Search JTable");

        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);




      /*Adding Coloumns*/
        tableModel.addColumn("Names");
        tableModel.addColumn("Team");
        tableModel.addColumn("Location");
        tableModel.addColumn("Points");
        tableModel.addColumn("Race count");
        tableModel.addColumn("1st Position");
        tableModel.addColumn("2nd Position");
        tableModel.addColumn("3rd Position");
        tableModel.addColumn("Date");



        /*Adding Rows and details*/
        for (Formula1driver formula1driver : drivernames) {

            tableModel.insertRow(0, new Object[]{formula1driver.getName(), formula1driver.getDriverteam(), formula1driver.getLocation(), formula1driver.getPoints(),
                    formula1driver.getRacecount(), formula1driver.getNo_of_first_pos(), formula1driver.getNo_of_second_pos(), formula1driver.getNo_of_third_pos(),formula1driver.getDatestore()});


        }



            final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
            table.setRowSorter(sorter);
            JScrollPane pane = new JScrollPane(table);
            frame.add(pane, BorderLayout.CENTER);

            JPanel panel = new JPanel(new BorderLayout());
            JLabel label = new JLabel("Search");
            panel.add(label, BorderLayout.WEST);
            final JTextField filterText = new JTextField("...");
            panel.add(filterText, BorderLayout.CENTER);
            frame.add(panel, BorderLayout.NORTH);
            table.getTableHeader().setBackground(Color.GRAY);
            JButton button = new JButton("Search..");
            Font  font  = new Font(Font.DIALOG_INPUT,  Font.BOLD, 15);
            Border whiteline = BorderFactory.createLineBorder(Color.white);
            Border compound;
            button.setBackground(Color.black);
            button.setForeground(Color.white);
            button.setFont(font);
            button.setBorder(whiteline);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String text = filterText.getText();
                    if (text.length() == 0) {
                        sorter.setRowFilter(null);
                    } else {
                        sorter.setRowFilter(RowFilter.regexFilter(text));
                    }
                }
            });
            frame.add(button, BorderLayout.SOUTH);

            frame.setSize(1200, 800);
            frame.setVisible(true);

    }

}
//references-------------------->https://stackoverflow.com/questions/22066387/how-to-search-an-element-in-a-jtable-java

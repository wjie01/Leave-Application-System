import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewLeave implements ActionListener {

    class Leave {

        private String name;
        private String[] number;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNumber(int index) {
            String value = null;
            if (index >= 0 && index < number.length) {
                value = number[index];
            }
            return value;
        }

        public void setNumbers(String... number) {
            this.number = number;
        }
    }

    class DatabaseTableModel extends AbstractTableModel {

        private List<Leave> list = new ArrayList<Leave>();
        private String[] columnNames = { "Emp ID", "Leave Reason", "Start Date", "End Date", "Status" };

        public void setList(List<Leave> list) {
            this.list = list;
            fireTableDataChanged();
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        public int getRowCount() {
            return list.size();
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return list.get(rowIndex).getName();

                case 1:
                case 2:
                case 3:
                case 4:
                    return list.get(rowIndex).getNumber(columnIndex - 1);

                default:
                    return null;
            }
        }
    }

    // JFrame frame = new JFrame("View Leave Page");
    JFrame frame = new JFrame("Employee Applied Leave");
    JButton back = new JButton("Go Back");
    JTextField id = new JTextField();
    JLabel leave = new JLabel();

    viewLeave(String empid) {

        JTextField id = new JTextField();
        id = new JTextField(empid);
        final String employeeid = id.getText();

        // JPanel p = new JPanel(new GridLayout(2, 1));

        // back.setBounds(50, 200, 100, 50);
        back.setPreferredSize(new Dimension(50, 50)); // 17/1
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                EmployeePage employeePage = new EmployeePage(employeeid);
            }
        });

        try {
            // JFrame frame = new JFrame();
            frame.setLayout(new BorderLayout());

            JTable table = new JTable();

            String readLine = null;

            FileReader reader = new FileReader("leave.txt");
            BufferedReader bufReader = new BufferedReader(reader);

            List<Leave> employeeList = new ArrayList<Leave>();

            while ((readLine = bufReader.readLine()) != null) {
                String[] splitData = readLine.split(";");
                // check if the first value of the record is the one you want to read
                if (splitData[0].equals(employeeid)) {
                    Leave leave = new Leave();
                    leave.setName(splitData[0]);
                    leave.setNumbers(Arrays.copyOfRange(splitData, 1, splitData.length));
                    employeeList.add(leave);
                }
            }

            DatabaseTableModel tableModel = new DatabaseTableModel();
            tableModel.setList(employeeList);
            table.setModel(tableModel);
            table.setPreferredSize(new Dimension(1000, 100));
            table.getTableHeader().setReorderingAllowed(false);

            String Columns[] = { "ID", "Leave Reason", "Start Date", "End Date", "Status" };

            // p.add(table);
            // p.add(back);

            frame.add(table); // 17/1
            frame.add(back, BorderLayout.PAGE_END); // 17/1
            frame.add(new JScrollPane(table)); // 17/1

            // frame.setTitle("Employee Applied Leave");
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            
            frame.setLocation(600, 100);

        } catch (IOException ex) {
        }
    }

    public void actionPerformed(ActionEvent e) {

    }
}
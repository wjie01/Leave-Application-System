import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class LeaveApplication extends JFrame implements ActionListener {

    String[] leaveReason = { "Sick", "Travel", "Emergency" };
    String leavestartdate;
    String leaveenddate;

    // title of the window
    JFrame frame = new JFrame("Apply Leave");

    // text in the window
    JLabel label = new JLabel("Leave Application Page");
    JLabel label1 = new JLabel("Employee ID: ");

    // fetch employee ID from login
    JTextField id = new JTextField();

    // text in window
    JLabel label2 = new JLabel("Reason of applying leave: ");

    final JComboBox reason = new JComboBox(leaveReason);

    JLabel startLbl = new JLabel("Start Date:");

    JLabel endLbl = new JLabel("End Date:");

    final JTextField startDate = new JTextField();
    final JTextField endDate = new JTextField();

    // start date button
    JButton startBtn = new JButton("...");

    // end date button
    JButton endBtn = new JButton("...");

    JButton confirmation = new JButton("Confirm");

    JButton cancel = new JButton("Go back");

    LeaveApplication(String empid) {

        id = new JTextField(empid);

        label.setFont(new Font("Times Roman", Font.BOLD, 25));
        label.setBounds(70, 0, 300, 100);

        label1.setFont(new Font("Sans Serif", Font.PLAIN, 14));
        label1.setBounds(10, 50, 200, 100);

        id.setEditable(false);
        id.setBounds(200, 88, 150, 30);

        label2.setFont(new Font("Sans Serif", Font.PLAIN, 14));
        label2.setBounds(10, 115, 200, 100);

        reason.setBounds(200, 150, 100, 30);

        startDate.setEditable(false);
        endDate.setEditable(false);

        startLbl.setFont(new Font("Sans Serif", Font.PLAIN, 14));
        endLbl.setFont(new Font("Sans Serif", Font.PLAIN, 14));

        startLbl.setBounds(10, 210, 100, 30);
        startDate.setBounds(200, 210, 100, 30);
        startBtn.setBounds(300, 210, 20, 30);

        endLbl.setBounds(10, 270, 100, 30);
        endDate.setBounds(200, 270, 100, 30);
        endBtn.setBounds(300, 270, 20, 30);

        confirmation.setBounds(50, 350, 100, 50);
        confirmation.addActionListener(this);

        cancel.setBounds(200, 350, 100, 50);
        cancel.addActionListener(this);

        frame.add(label);
        frame.add(label1);
        frame.add(id);
        frame.add(label2);
        frame.add(reason);
        frame.add(startLbl);
        frame.add(startBtn);
        frame.add(startDate);
        frame.add(endBtn);
        frame.add(endLbl);
        frame.add(endDate);
        frame.add(confirmation);
        frame.add(cancel);

        // start date button
        startBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                startDate.setText(new DatePicker(frame).displayDatePicked());
                leavestartdate = startDate.getText();
            }
        });

        // end date button
        endBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                endDate.setText(new DatePicker(frame).displayDatePicked());
                leaveenddate = endDate.getText();
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 800);
        frame.setLayout(null);
        frame.setVisible(true);

        Color backgroundSystem = new Color(255, 255, 204);
		frame.getContentPane().setBackground(backgroundSystem);
        frame.setLocation(600, 100);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmation) {

            String leavereason = (String) reason.getSelectedItem();

            try {
                FileWriter Writer = new FileWriter("leave.txt", true);

                Writer.write(id.getText() + ";" + leavereason + ";" + leavestartdate + ";" + leaveenddate + ";" + "PENDING"); // newly added

                Writer.write(System.getProperty("line.separator"));

                Writer.close();
                
                JOptionPane.showMessageDialog(this, "Request has been sent to admin");
                setVisible(false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Oops. Something went wrong");
            }
        }

        else if (e.getSource() == cancel) {
            final String employeeid = id.getText();

            frame.dispose();
            EmployeePage employeePage = new EmployeePage(employeeid);
        }
    }
}
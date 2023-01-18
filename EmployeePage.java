import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeePage implements ActionListener{

    JFrame frame = new JFrame("Employee Page");
    JLabel label = new JLabel("Employee Page");
    JTextField id = new JTextField();
    JButton leaveButton = new JButton("Apply Leave");
    JButton viewButton = new JButton("View Applied Leave");
    JButton back = new JButton("Back");


    EmployeePage(String empid){

        id = new JTextField(empid);

        // Employee Page
        label.setBounds(180,0,300,100);
        label.setFont(new Font("Times Roman",Font.BOLD,30));

        // Apply Leave
        leaveButton.setBounds(150,150,300,100);
        leaveButton.setFocusable(false);
        leaveButton.addActionListener(this);

        viewButton.setBounds(150,300,300,100);
        viewButton.setFocusable(false);
        viewButton.addActionListener(this);

        back.setBounds(250,500,100,30);
        back.setFocusable(false);
        back.addActionListener(this);

        frame.add(label);
        frame.add(leaveButton);
        frame.add(viewButton);
        frame.add(back);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(600,800);
        frame.setLayout(null);
        frame.setVisible(true);

        Color backgroundSystem = new Color(255, 255, 204);
		frame.getContentPane().setBackground(backgroundSystem);
        frame.setLocation(600, 100);
    }

    public void actionPerformed(ActionEvent e){
        
        String employeeid = id.getText();
        
        if(e.getSource()==leaveButton){
            LeaveApplication leaveApplication = new LeaveApplication(employeeid);
            frame.dispose();
        }
        if(e.getSource()==viewButton){
            leavetable viewLeave = new leavetable(employeeid);
            frame.dispose();
        }
        if(e.getSource()==back){
            MainPage.main(null);
            frame.dispose();
        }
    }
}
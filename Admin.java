import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Admin implements ActionListener{

    JFrame frame = new JFrame("Admin");
    JButton addEmp = new JButton("Add New Employee");
    JButton checkLeave = new JButton("Check Employee Leave Application");
    JButton back = new JButton("Back");


    Admin(){

        // add 
        addEmp.setBounds(150,150,300,100);
        addEmp.setFocusable(false);
        addEmp.addActionListener(this);

        checkLeave.setBounds(150,300,300,100);
        checkLeave.setFocusable(false);
        checkLeave.addActionListener(this);

        back.setBounds(250,500,100,30);
        back.setFocusable(false);
        back.addActionListener(this);

        frame.add(addEmp);
        frame.add(checkLeave);
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
        
        
        if(e.getSource()==addEmp){
            AddNewEmployee addNewEmployee = new AddNewEmployee();
            frame.dispose();
        }
        if(e.getSource()==checkLeave){
            LeaveApprovePage leaveApprovePage = new LeaveApprovePage();
            frame.dispose();
        }
        if(e.getSource()==back){
            MainPage.main(null);
            frame.dispose();
        }
    }
}
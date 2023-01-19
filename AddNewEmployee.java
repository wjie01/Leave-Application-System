import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AddNewEmployee extends JFrame implements ActionListener {

    // title of the window
    JFrame frame = new JFrame("Add New Employee");
    String[] department = { "FIST", "FOB", "FOL", "FET" };

    // text in the window
    JLabel label = new JLabel("Add New Employee");

    JLabel label1 = new JLabel("Employee ID: ");
    JTextField id = new JTextField();

    JLabel name = new JLabel("Name: ");
    JTextField namefield = new JTextField();

    JLabel departmentLabel = new JLabel("Department: ");
    final JComboBox departmentBox = new JComboBox(department);
    // fetch employee ID from login
    
    

    JButton confirm = new JButton("Confirm");
    JButton cancel = new JButton("Cancel");

    
    AddNewEmployee() {

        label.setFont(new Font("Times Roman", Font.BOLD, 30));
        label.setBounds(120, 30, 300, 100);

        // ID
        label1.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        label1.setBounds(60,150, 200, 100);

        id.setBounds(200, 185, 150, 30);

        // Name
        name.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        name.setBounds(60,230, 250, 100);

        namefield.setBounds(200, 260, 150, 30);

        // Department
        departmentLabel.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        departmentLabel.setBounds(60,290, 200, 100);

        departmentBox.setBounds(200, 325, 150, 30);

        // Buttons 
        confirm.setBounds(100, 450, 100, 50);
        confirm.addActionListener(this);

        cancel.setBounds(300, 450, 100, 50);
        cancel.addActionListener(this);

        frame.add(label);
        frame.add(label1);
        frame.add(name);
        frame.add(namefield);
        frame.add(departmentLabel);
        frame.add(departmentBox);
        frame.add(id);
        frame.add(confirm);
        frame.add(cancel);

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
        if (e.getSource() == confirm) {

            final String empid = id.getText();

            try {
                FileWriter Writer = new FileWriter("empID.txt", true);

                Writer.write(empid);

                Writer.write(System.getProperty("line.separator"));

                Writer.close();
                
                JOptionPane.showMessageDialog(this, "New Employee Added");
                setVisible(false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Oops. Something went wrong");
            }
        }

        else if (e.getSource() == cancel) {
            frame.dispose();
            Admin admin = new Admin();
            frame.dispose();
        }
    }
}
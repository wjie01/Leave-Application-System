import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.io.File;

class EmployeeLogin extends JFrame implements ActionListener {
	public static Object actionPerformed;
	JFrame frame = new JFrame("Employee Login Page");
	JLabel label1 = new JLabel("Employee Login Page");
	JLabel label2 = new JLabel("Employee ID: ");
	JTextField id = new JTextField();
	JButton login = new JButton("Login");
	JButton back = new JButton("Back");

	EmployeeLogin() {

		// Employee Login Page
		label1.setFont(new Font("DM Sans", Font.BOLD, 40));
		label1.setBounds(90, 30, 450, 100);
		frame.add(label1);

		// Employee ID
		label2.setFont(new Font("Arial", Font.PLAIN, 25));
		label2.setBounds(50, 200, 450, 100);
		frame.add(label2);

		

		// Employee
		id = new JTextField(15);
		id.setBounds(220, 235, 200, 30);
		id.setFont(new Font("Arial", Font.PLAIN, 20));
		frame.add(id);

		login.setBounds(220, 330, 120, 60);
		login.setFont(new Font("Arial", Font.PLAIN, 20));
		frame.add(login);
		login.addActionListener(this);

		back.setBounds(220, 500, 100, 30);
		back.setFont(new Font("Arial", Font.PLAIN, 15));
		frame.add(back);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage.main(null);
				frame.dispose();
			}
		});

		setTitle("Leave Application System");

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

		// initialize found as false
		boolean found = false;
		final String employeeid = id.getText();

		try {
			Scanner scan = new Scanner(new File("empID.txt"));

			while (scan.hasNext()) {

				String line = scan.nextLine();

				if (line.contains(employeeid)) {

					// if found the employee id then update to true
					found = true;

					JOptionPane.showMessageDialog(this, "Login Successfully!");

					EmployeePage employeePage = new EmployeePage(employeeid);

					frame.dispose();
				}
			}
			// if employee id not found then show error message
			if (!found) {
				JOptionPane.showMessageDialog(this, "Invalid Employee ID");
			}

		} catch (Exception ex) {
			// if file fail to open
			JOptionPane.showMessageDialog(null, "Oops. Something went wrong");
		}

	}
}
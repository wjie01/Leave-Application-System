import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPage {
	public static void main(String[] args) {	
	  
    // Create a new JFrame
    final JFrame frame = new JFrame("Leave Application System");
	
	JLabel logo = new JLabel();
	logo.setIcon(new ImageIcon("mmulogo.png"));
	Dimension sizeLogo = logo.getPreferredSize();
	logo.setBounds(140, 30, 350, 200);
	frame.add(logo);
	
	JLabel systemName = new JLabel("Leave Application System");
	
	systemName.setFont(new Font("Serif", Font.BOLD, 40));
	systemName.setBounds(80, 200, 450, 100);
	frame.add(systemName);
	
	

	// Set the location of the frame
	frame.setLocation(600, 100);


    // Set the size of the frame
    frame.setSize(600, 800);

    // Set the default close operation
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

    // Create the two buttons
    JButton adminButton = new JButton("Admin");
	adminButton.setFont(new Font("Arial", Font.BOLD, 16));
    JButton employeeButton = new JButton("Employee");
	employeeButton.setFont(new Font("Arial", Font.BOLD, 16));
	
	//adminButton.setPreferredSize(new Dimension(100, 50));
	
	adminButton.setBounds(230,360,120,50);
	employeeButton.setBounds(230,450,120,50);
	

    // Add the buttons to the frame
    frame.add(adminButton);
    frame.add(employeeButton);
	
	Color backgroundSystem = new Color(255, 255, 204);
	frame.getContentPane().setBackground(backgroundSystem);
	
	adminButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// Show the login page for the admin
			LoginPage loginPage = new LoginPage();
			loginPage.setVisible(true);

			// Close the main page
			frame.dispose();
		}
	});

	employeeButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// Show the employee page
			EmployeeLogin employeeLogin = new EmployeeLogin();

			// Close the main page
			frame.dispose();
		}
	}); 


	frame.setLayout(null);
    // Make the frame visible
    frame.setVisible(true);
	
  }
}

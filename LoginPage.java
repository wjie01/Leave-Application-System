import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPage extends JFrame implements ActionListener {

  private static final long serialVersionUID = 1L;
  private JLabel adminLabel;
  private JLabel passwordLabel;
  private JTextField adminField;
  private JPasswordField passwordField;
  private JButton loginButton;

  public LoginPage() {
	// Set the layout of the frame
	setLayout(null);
	JLabel logo = new JLabel();
	logo.setIcon(new ImageIcon("mmulogo.png"));
	Dimension sizeLogo = logo.getPreferredSize();
	logo.setBounds(140, 30, 350, 200);
	add(logo);
	
	JLabel systemName = new JLabel("Leave Application System");
	systemName.setFont(new Font("Serif", Font.BOLD, 40));
	systemName.setBounds(80, 200, 450, 100);
	add(systemName);
	
	

    // Initialize and add the admin label and text field
    adminLabel = new JLabel("admin: ");
	adminLabel.setFont(new Font("Serif", Font.PLAIN, 25));
	adminLabel.setBounds(110, 340, 450, 100);
    add(adminLabel);
    adminField = new JTextField(15);
	adminField.setBounds(240, 380, 200, 30);
	adminField.setFont(new Font("Arial", Font.PLAIN, 20));
    add(adminField);

    // Initialize and add the password label and password field
    passwordLabel = new JLabel("Password: ");
	passwordLabel.setFont(new Font("Serif", Font.PLAIN, 25));
	passwordLabel.setBounds(110, 400, 450, 100);
    add(passwordLabel);
    passwordField = new JPasswordField(15);
	passwordField.setBounds(240, 440, 200, 30);
	setFont(new Font("Arial", Font.PLAIN, 20));
    add(passwordField);

    // Initialize and add the login button
    loginButton = new JButton("Login");
	loginButton.setBounds(240, 515, 120, 40);
	loginButton.setFont(new Font("Arial", Font.PLAIN, 20));
    add(loginButton);
    loginButton.addActionListener(this);

    // Set the size and title of the frame
    setSize(600, 800);
	setLocation(600, 100);
    setTitle("Leave Application System");
	Color backgroundSystem = new Color(255, 255, 204);
	getContentPane().setBackground(backgroundSystem);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		LoginPage frame = new LoginPage();
		// Get the entered admin and password
		String admin = adminField.getText();
		char[] password = passwordField.getPassword();

		// Check if the admin and password match
		if (admin.equals("admin") && new String(password).equals("password")) {
			JOptionPane.showMessageDialog(this,"Login Successfully!");
			
			LeaveApprovePage frame1 = new LeaveApprovePage();
			frame1.setSize(400, 300);
			frame1.setLocationRelativeTo(null); // Center the frame
			frame1.setDefaultCloseOperation(LoginPage.EXIT_ON_CLOSE);
			this.dispose();
			
		} 
	
		else {
			JOptionPane.showMessageDialog(this,"Invalid admin or password.");
			frame.dispose();
		}
	}

	public static void main(String[] args) {
		LoginPage login = new LoginPage();
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setVisible(true);
	}
}

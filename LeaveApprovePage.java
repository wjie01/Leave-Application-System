import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.event.*;

public class LeaveApprovePage extends JFrame{
    private JFrame frame;
    private JLabel employeeIDLabel, reasonTypeLabel, startDateLabel, endDateLabel, statusLabel, nameLabel;
    private JTextField employeeIDField, reasonTypeField, startDateField, endDateField, statusField, nameField;
    private JButton approveButton, rejectButton, nextButton, goBackButton;
    private ArrayList<String> leaveApplications;
    private int currentLeaveIndex = 0;

    public LeaveApprovePage() {
        // Initialize frame
        frame = new JFrame("Leave Approval");
		frame.setLayout(null);
		
        frame.setLocation(600, 100);
        frame.setSize(600, 700);
        frame.getContentPane().setBackground(new Color(255, 255, 204));
        //frame.setVisible(true);

        // Read leave applications from text file
        leaveApplications = readLeaveApplicationsFromFile("leave1.txt");

        // Initialize labels
        employeeIDLabel = new JLabel("Employee ID:");
		nameLabel = new JLabel("Name: ");
        reasonTypeLabel = new JLabel("Reason Type:");
        startDateLabel = new JLabel("Start Date:");
        endDateLabel = new JLabel("End Date:");
        statusLabel = new JLabel("Leave Approval Status:");
		
		employeeIDLabel.setFont(new Font("Arial", Font.BOLD, 16));
		nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
		reasonTypeLabel.setFont(new Font("Arial", Font.BOLD, 16));
		startDateLabel.setFont(new Font("Arial", Font.BOLD, 16));
		endDateLabel.setFont(new Font("Arial", Font.BOLD, 16));
		statusLabel.setFont(new Font("Arial", Font.BOLD, 16));

        // Initialize text fields
        employeeIDField = new JTextField(20);
		nameField = new JTextField(20);
        reasonTypeField = new JTextField(20);
        startDateField = new JTextField(20);
        endDateField = new JTextField(20);
        statusField = new JTextField(20);
		
		employeeIDField.setFont(new Font("Arial", Font.BOLD, 16));
		nameField.setFont(new Font("Arial", Font.BOLD, 16));
		reasonTypeField.setFont(new Font("Arial", Font.BOLD, 16));
		startDateField.setFont(new Font("Arial", Font.BOLD, 16));
		endDateField.setFont(new Font("Arial", Font.BOLD, 16));
		statusField.setFont(new Font("Arial", Font.BOLD, 16));
		
		employeeIDField.setEnabled(false);
		nameField.setEnabled(false);
		reasonTypeField.setEnabled(false);
		startDateField.setEnabled(false);
		endDateField.setEnabled(false);
		statusField.setEnabled(false);

		

        // Initialize buttons
        approveButton = new JButton("Approve");
        rejectButton = new JButton("Reject");
		goBackButton = new JButton("Go Back");
        nextButton = new JButton("Next");
		
		
		
		// Create action listener classes
        class ApproveButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String leaveApplication = leaveApplications.get(currentLeaveIndex);
                writeLeaveApplicationToFile(leaveApplication, "approve.txt");
                removeLeaveApplicationFromFile("leave1.txt", currentLeaveIndex);
                statusField.setText("Approved");
				JOptionPane.showMessageDialog(null, "It has been approved!");
            }
        }
        class RejectButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String leaveApplication = leaveApplications.get(currentLeaveIndex);
                writeLeaveApplicationToFile(leaveApplication, "reject.txt");
                removeLeaveApplicationFromFile("leave1.txt", currentLeaveIndex);
                statusField.setText("Rejected");
				JOptionPane.showMessageDialog(null, "It has been rejected!");
            }
        }
		
		 class goBackButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (currentLeaveIndex > 0) {
					currentLeaveIndex--;
					displayLeaveApplication(currentLeaveIndex);
				}
			}
		}

		
        class NextButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                if (currentLeaveIndex < leaveApplications.size()-1) {
                    currentLeaveIndex++;
                    displayLeaveApplication(currentLeaveIndex);
                }
				
				if(currentLeaveIndex == leaveApplications.size()-1){
					JOptionPane.showMessageDialog(null,"No any leave applications!");
				}
            }
        }


        // Display first leave application
        displayLeaveApplication(currentLeaveIndex);

        // Add action listeners to buttons
        approveButton.addActionListener(new ApproveButtonListener());
        rejectButton.addActionListener(new RejectButtonListener());
		goBackButton.addActionListener(new goBackButtonListener());
        nextButton.addActionListener(new NextButtonListener());

        // Set layout
        frame.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
		

        // Add labels and text fields to frame
		constraints.insets = new Insets(10,0,0,15);
        constraints.gridx = 0;
        constraints.gridy = 0;
		constraints.ipady = 25;
        frame.add(employeeIDLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
		constraints.ipady = 25;
        frame.add(employeeIDField, constraints);
		
		constraints.insets = new Insets(10,0,0,15);
        constraints.gridx = 0;
        constraints.gridy = 1;
		constraints.ipady = 25;
        frame.add(nameLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
		constraints.ipady = 25;
        frame.add(nameField, constraints);
		
        constraints.gridx = 0;
        constraints.gridy = 2;
		constraints.ipady = 25;
        frame.add(reasonTypeLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
		constraints.ipady = 25;
        frame.add(reasonTypeField, constraints);
		
        constraints.gridx = 0;
        constraints.gridy = 3;
		constraints.ipady = 25;
        frame.add(startDateLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 3;
		constraints.ipady = 25;
        frame.add(startDateField, constraints);
		
        constraints.gridx = 0;
        constraints.gridy = 4;
		constraints.ipady = 25;
        frame.add(endDateLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 4;
		constraints.ipady = 25;
        frame.add(endDateField, constraints);
		
        constraints.gridx = 0;
        constraints.gridy = 5;
		constraints.ipady = 25;
        frame.add(statusLabel, constraints);
        constraints.gridx = 1;
        constraints.gridy = 5;
		constraints.ipady = 25;
        frame.add(statusField, constraints);

        // Add buttons to frame
        constraints.gridx = 0;
        constraints.gridy = 6;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.insets = new Insets(20,40,0,0);
        frame.add(approveButton, constraints);
		
        constraints.gridx = 1;
        constraints.gridy = 6;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.insets = new Insets(20,-220,0,0);
        frame.add(rejectButton, constraints);
		
		constraints.gridx = 2;
        constraints.gridy = 6;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.insets = new Insets(20,-230,0,0);
        frame.add(goBackButton, constraints);
		
        constraints.gridx = 3;
        constraints.gridy = 6;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.insets = new Insets(20,-90,0,0);
        frame.add(nextButton, constraints);
		
		
		JButton statusButton = new JButton("View Status");
		statusButton.setFont(new Font("Arial", Font.BOLD, 15));
	
		constraints.gridx = 0;
        constraints.gridy = 7;
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		constraints.ipady = 15;
		constraints.insets = new Insets(40,45,0,0);
		//constraints.anchor = GridBagConstraints.SOUTH;
		frame.add(statusButton, constraints);

        JTextField id = new JTextField();

        String employeeid = id.getText();
		
		statusButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			viewLeave viewPage = new viewLeave(employeeid);
			frame.dispose();
		}
	});

        frame.setVisible(true);
    }

    private ArrayList<String> readLeaveApplicationsFromFile(String fileName) {
        ArrayList<String> leaveApplications = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                leaveApplications.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return leaveApplications;
    }

    private void writeLeaveApplicationToFile(String leaveApplication, String fileName) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
            bw.write(leaveApplication);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeLeaveApplicationFromFile(String fileName, int index) {
        try {
            ArrayList<String> leaveApplications = readLeaveApplicationsFromFile(fileName);
            leaveApplications.remove(index);
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            for (String leaveApplication : leaveApplications) {
                bw.write(leaveApplication);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayLeaveApplication(int index) {
        String[] leaveApplicationDetails = leaveApplications.get(index).split(",");
        employeeIDField.setText(leaveApplicationDetails[0]);
		nameField.setText(leaveApplicationDetails[1]);
        reasonTypeField.setText(leaveApplicationDetails[2]);
        startDateField.setText(leaveApplicationDetails[3]);
        endDateField.setText(leaveApplicationDetails[4]);
		statusField.setText("pending");
    }

    public static void main(String[] args) {	
		LeaveApprovePage leaveApprove = new LeaveApprovePage();
		leaveApprove.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}



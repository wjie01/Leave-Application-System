import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LeaveApprovePage {

    //Array to store leave applications
    String[][] leaves = new String[1000][5];

    public LeaveApprovePage() {
        //read data from leave.txt file
        try {
            BufferedReader br = new BufferedReader(new FileReader("leave.txt"));
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                leaves[i] = line.split(";");
                i++;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //create frame
        JFrame frame = new JFrame();
        frame.setTitle("Leave Approve Page");
        frame.setLocation(600, 100);
        frame.setSize(600, 700);

        //create scrollable panel
        final JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(panel);
        frame.add(scrollPane);

        //create buttons for each leave application
        for (int i = 0; i < leaves.length; i++) {
            if (leaves[i][0] != null) {
				final int index = i;
                JButton approveButton = new JButton("Approve");
                approveButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        //if button is clicked, change approval status
                        leaves[index][4] = "approved";
                        //update leave.txt file
                        try {
                            PrintWriter pw = new PrintWriter(new FileWriter("leave.txt"));
                            for (int j = 0; j < leaves.length; j++) {
                                if (leaves[j][0] != null) {
                                    pw.println(leaves[j][0] + ";" + leaves[j][1] + ";" + leaves[j][2] + ";" + leaves[j][3] + ";" + leaves[j][4]);
                                }
                            }
                            pw.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                panel.add(approveButton);

                JButton rejectButton = new JButton("Reject");
                rejectButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        //if button is clicked, change approval status
                        leaves[index][4] = "rejected";
                        //update leave.txt file
                        try {
                            PrintWriter pw = new PrintWriter(new FileWriter("leave.txt"));
                            for (int j = 0; j < leaves.length; j++) {
                                                               if (leaves[j][0] != null) {
                                    pw.println(leaves[j][0] + ";" + leaves[j][1] + ";" + leaves[j][2] + ";" + leaves[j][3] + ";" + leaves[j][4]);
                                }
                            }
                            pw.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                panel.add(rejectButton);
                JLabel label = new JLabel("  " + leaves[i][0] + " | " + leaves[i][1] + " | " + leaves[i][2] + " | " + leaves[i][3] + " | " + leaves[i][4] + "  ");
				label.setFont(new Font("Arial", Font.BOLD, 15));
				label.setBorder(BorderFactory.createLineBorder(Color.black));
                panel.add(label);
            }
        }
		
		//create refresh button
		JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				//remove all components from the panel
                panel.removeAll();
                //read data from leave.txt file
                try {
                    BufferedReader br = new BufferedReader(new FileReader("leave.txt"));
                    String line;
                    int i = 0;
                    while ((line = br.readLine()) != null) {
                        leaves[i] = line.split(";");
                        i++;
                    }
                    br.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                //add buttons and labels for each leave application
                for (int i = 0; i < leaves.length; i++) {
                    if (leaves[i][0] != null) {
                        final int index = i;
                        JButton approveButton = new JButton("Approve");
                        approveButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                //if button is clicked, change approval status
                                leaves[index][4] = "approved";
                                //update leave.txt file
                                try {
                                    PrintWriter pw = new PrintWriter(new FileWriter("leave.txt"));
                                    for (int j = 0; j < leaves.length; j++) {
                                        if (leaves[j][0] != null) {
                                            pw.println(leaves[j][0] + ";" + leaves[j][1] + ";" + leaves[j][2] + ";" + leaves[j][3] + ";" + leaves[j][4]);
                                        }
                                    }
                                    pw.close();
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                        });
                        panel.add(approveButton);

                        JButton rejectButton = new JButton("Reject");
                        rejectButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                //if button is clicked, change approval status
                                leaves[index][4] = "rejected";
                                //update leave.txt file
                                try {
                                    PrintWriter pw = new PrintWriter(new FileWriter("leave.txt"));
                                    for (int j = 0; j < leaves.length; j++) {
                                        if (leaves[j][0] != null) {
                                            pw.println(leaves[j][0] + ";" + leaves[j][1] + ";" + leaves[j][2] + ";" + leaves[j][3] + ";" + leaves[j][4]);
                                        }
                                    }
                                    pw.close();
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                        });
                        panel.add(rejectButton);
                        JLabel label = new JLabel(leaves[i][0] + " " + leaves[i][1] + " " + leaves[i][2] + " " + leaves[i][3] + " " + leaves[i][4]);
                        panel.add(label);
                    }
                }
                panel.revalidate();
                panel.repaint();
            }
        });
		
		refreshButton.setBackground(Color.white);
        panel.add(refreshButton);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LeaveApprovePage();
    }
}


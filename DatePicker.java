import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class DatePicker {
    JButton[] btn = new JButton[49];
    int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
    int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);;
    JLabel lbl = new JLabel("",JLabel.CENTER);
    String day = "";
    JDialog d;
    
        public DatePicker(JFrame parent){
            d = new JDialog();
            d.setModal(true);
            String[] header = {"Sun","Mon","Tue","Wed","Thur","Fri","Sat"};
            JPanel midPanel = new JPanel(new GridLayout(7,7));
            midPanel.setPreferredSize(new Dimension(400,400));

            for(int x = 0; x < btn.length; x++){
                final int selection = x;
                btn[x] = new JButton();
                btn[x].setFocusPainted(false);
                if(x>6)btn[x].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                    day = btn[selection].getActionCommand();
                    d.dispose();}});

                if(x < 7){
                    btn[x].setFont(new Font("Lucida",Font.PLAIN,10)); 
                    btn[x].setText(header[x]);}
                    midPanel.add(btn[x]);
                }
    
        JPanel lowPanel = new JPanel(new GridLayout(1,3));
        JButton prevBtn = new JButton("<< Previous");
        prevBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                month--;setDates();}});
                lowPanel.add(prevBtn);
                lowPanel.add(lbl);

        JButton nextBtn = new JButton("Next >>");
        nextBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                month++;setDates();}});
                lowPanel.add(nextBtn);
                d.add(midPanel,BorderLayout.CENTER);
                d.add(lowPanel,BorderLayout.SOUTH);
                d.pack();
                d.setLocationRelativeTo(parent);
                setDates();
                d.setVisible(true);

        }
    public void setDates(){
        for(int x = 7; x < btn.length; x++) btn[x].setText("");
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMMM yyyy");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year,month,1);
        int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
        int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
            for(int x = 6+dayOfWeek,day = 1; day <= daysInMonth; x++,day++) 
            btn[x].setText(""+day);
            lbl.setText(sdf.format(cal.getTime()));
            d.setTitle("Date Picker  - "+lbl.getText());
            }

    public String displayDatePicked(){
        if(day.equals("")) return day;
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("EEEE d MMMM, yyyy");
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.set(year,month,Integer.parseInt(day));

        return sdf.format(cal.getTime());

        }
}

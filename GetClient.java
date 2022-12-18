import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GetClient extends JFrame implements ActionListener {

    private JTextField usernameField;
    private JButton searchBtn;
    private JLabel fullNameLbl;
    private JLabel cnicLbl;
    private JLabel phoneLbl;
    private JLabel AddressLbl;
    private JLabel dobLbl;
    private JLabel genderLbl;
    private JLabel noOfBillsLbl;


    public GetClient(){

        super("Fetch Records");
        JPanel panel = new JPanel();
    
        setSize(720, 640);
        setResizable(true);
        // LayoutManager layout = new FlowLayout();
        // setLayout(layout);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        
        panel.setLayout(null);
        Border blackline = BorderFactory.createTitledBorder("Access Records");
        panel.setBorder(blackline);
        panel.setBounds(20, 20, 700, 620);

        JLabel lbl1 = new JLabel("Enter Client Username: ");
        lbl1.setBounds(30, 40, 160, 30);
        
        usernameField = new JTextField(15);
        usernameField.setBounds(180, 45, 150, 25);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(350, 45, 80, 25);
        searchBtn.addActionListener(this);

        // Adding components to the panel
        panel.add(lbl1);
        panel.add(usernameField);
        panel.add(searchBtn);

        // Adding the panel to frame
        add(panel);
        setVisible(true);
    }

    public String[] getClinetData(String username){
        String[] data = new String[11];


        try{
            File clientFile = new File("./login_credentials/"+ username + ".txt");
            Scanner fileReader = new Scanner(clientFile);

            byte count = 0;
            while(fileReader.hasNextLine()){
                data[count] = fileReader.nextLine();
                count++;
            }
            fileReader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", 2);
        }

        return data;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == searchBtn){
            String[] clientData = getClinetData(usernameField.getText());
            for (String string : clientData) {
                System.out.println(string);
            }
        }
    }
    
    public static void main(String[] args) {
        new GetClient();
    }

}

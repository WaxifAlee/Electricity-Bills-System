import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dashboard {
    
    private JFrame frame;
    private JPanel informationPanel;
    private String username;
    private String[] fetchedInformation = new String[10];

    Person user;
    
    public Dashboard(String un){
        this.username = un;

        // No Need to use FileNotFoundException Here Because This Frame will not open
        // unless the file exists

        try{
            File informationFile = new File("login_credentials/"+username+".txt");
            Scanner infoReader = new Scanner(informationFile);
            int lineCount = 0;

            while(infoReader.hasNextLine()){
                fetchedInformation[lineCount] = infoReader.nextLine();
                lineCount++;
            }
            infoReader.close();

            for (String string : fetchedInformation) {
                System.out.println(string);
            }

        } catch (Exception ex){
            JOptionPane.showMessageDialog(frame, "Something went wrong please try again!", "Error", 3);
        }

        // Now that the information is fetched into an array, let's store it into separate variables for reader ease

        String firstName = fetchedInformation[1];
        String lastName = fetchedInformation[2];
        String cnic = fetchedInformation[3];
        String contactNumber = fetchedInformation[4];
        String rank = fetchedInformation[5];
        String address = fetchedInformation[6];
        String dateOfJoining = fetchedInformation[7];
        String dateOfBirth= fetchedInformation[8];
        String gender = fetchedInformation[9];
        int billsGenderated; // May or may not exist depending on rank
        // Create a new Object based on the rank (i.e. admin or client)
        if(rank.equals("admin")){
            user = new Admin(firstName, lastName, cnic, contactNumber, dateOfBirth, address, gender, dateOfJoining);
        } else if(rank.equals("client")){
            try{
            billsGenderated = Integer.parseInt(fetchedInformation[10]);
            user = new Client(firstName, lastName, cnic, contactNumber, dateOfBirth, address, gender, dateOfJoining, billsGenderated);
            } catch (ArrayIndexOutOfBoundsException ex){
                JOptionPane.showMessageDialog(frame, "Invalid Enteries", "Error", 2);
                frame.dispose();
            }
        }

        frame = new JFrame();
        frame.setTitle("Dashboard");
        frame.setSize(800, 800);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        informationPanel = new JPanel();
        informationPanel.setLayout(null);
        JLabel dashLabel = new JLabel("Dashboard");
        dashLabel.setBounds(40, 20, 200, 30);
        dashLabel.setFont(new Font("Arial", Font.BOLD, 32));
        informationPanel.add(dashLabel);

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Full Name: "+user.getFullName());
        nameLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        nameLabel.setBounds(40, 80, 180, 30);
        informationPanel.add(nameLabel);

        

        frame.add(informationPanel);
        frame.setVisible(true);
    }


}

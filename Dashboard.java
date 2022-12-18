import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.Cursor;

public class Dashboard implements ActionListener {

    private JFrame frame;
    private JPanel informationPanel;
    private String username;
    private String[] fetchedInformation = new String[11];
    private JButton addRecordBtn;
    private JButton getRecordBtn;
    private JButton editRecordBtn;

    Person user;

    public Dashboard(String un) throws IOException {
        this.username = un;

        // No Need to use FileNotFoundException Here Because This Frame will not open
        // unless the file exists

        try {
            File informationFile = new File("login_credentials/" + username + ".txt");
            Scanner infoReader = new Scanner(informationFile);
            int lineCount = 0;

            while (infoReader.hasNextLine()) {
                fetchedInformation[lineCount] = infoReader.nextLine();
                lineCount++;
            }
            infoReader.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Something went wrong please try again!", "Error", 3);
            System.out.println(ex.getMessage());
        }

        // Now that the information is fetched into an array, let's store it into
        // separate variables for reader ease

        String firstName = fetchedInformation[1];
        String lastName = fetchedInformation[2];
        String cnic = fetchedInformation[3];
        String contactNumber = fetchedInformation[4];
        String rank = fetchedInformation[5];
        String address = fetchedInformation[6];
        String dateOfJoining = fetchedInformation[7];
        String dateOfBirth = fetchedInformation[8];
        String gender = fetchedInformation[9];
        int billsGenderated; // May or may not exist depending on rank
        // Create a new Object based on the rank (i.e. admin or client)
        if (rank.equals("admin")) {
            user = new Admin(firstName, lastName, cnic, contactNumber, dateOfBirth, address, gender, dateOfJoining);
        } else if (rank.equals("client")) {
            try {
                billsGenderated = Integer.parseInt(fetchedInformation[10]);
                user = new Client(firstName, lastName, cnic, contactNumber, dateOfBirth, address, gender, dateOfJoining,
                        billsGenderated);
            } catch (ArrayIndexOutOfBoundsException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid Enteries", "Error", 2);
                // frame.dispose();
            }
        }

        frame = new JFrame();
        frame.setTitle("Dashboard");
        frame.setSize(720, 640);
        frame.setResizable(true);
        // LayoutManager layout = new FlowLayout();
        // frame.setLayout(layout);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        informationPanel = new JPanel();
        informationPanel.setLayout(null);
        Border blackline = BorderFactory.createTitledBorder("Dashboard");
        informationPanel.setBorder(blackline);
        informationPanel.setBounds(20, 20, 700, 620);

        JLabel dashLabel = new JLabel(user.greetUser() + "!");
        dashLabel.setBounds(40, 40, 400, 30);
        dashLabel.setFont(new Font("Arial", Font.BOLD, 32));
        informationPanel.add(dashLabel);

        JLabel userImage = new JLabel();
        BufferedImage myPicture = ImageIO.read(new File("./images/" + username + ".jpg"));
        userImage.setIcon(new ImageIcon(myPicture));
        userImage.setBounds(450, 70, 180, 180);
        informationPanel.add(userImage);

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Full Name: " + user.getFullName());
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        nameLabel.setBounds(40, 100, 180, 30);
        informationPanel.add(nameLabel);

        JLabel genderLabel = new JLabel("Gender: " + user.getGender());
        genderLabel.setBounds(250, 100, 180, 30);
        genderLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        informationPanel.add(genderLabel);

        JLabel cnicLabel = new JLabel("CNIC: " + user.getCnic());
        cnicLabel.setBounds(40, 140, 180, 30);
        cnicLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        informationPanel.add(cnicLabel);

        JLabel contactLabel = new JLabel("Phone: " + user.getContactNumber());
        contactLabel.setBounds(250, 140, 180, 30);
        contactLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        informationPanel.add(contactLabel);

        JLabel rankLabel = new JLabel("Logged in as: " + rank.toUpperCase());
        rankLabel.setBounds(40, 180, 220, 30);
        rankLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        informationPanel.add(rankLabel);

        JLabel addressLabel = new JLabel("Address: " + user.getAddress());
        addressLabel.setBounds(40, 220, 500, 30);
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        informationPanel.add(addressLabel);

        JLabel dobLabel = new JLabel("Date of Birth: " + user.getDob());
        dobLabel.setBounds(40, 260, 250, 30);
        dobLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        informationPanel.add(dobLabel);

        JLabel dojLabel = new JLabel("Date of Joining: " + dateOfJoining);
        dojLabel.setBounds(250, 260, 250, 30);
        dojLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        informationPanel.add(dojLabel);

        frame.add(informationPanel);
        frame.setVisible(true);

        // Adding the functionality Buttons to perform different file handling
        // operations

        // Adding Buttons For Different Admin Operations
        if (rank.equals("admin")) {
            addRecordBtn = new JButton("Add Client");
            addRecordBtn.setBounds(120, 340, 100, 40);
            addRecordBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            informationPanel.add(addRecordBtn);

            getRecordBtn = new JButton("Get Client Record");
            getRecordBtn.setBounds(260, 340, 140, 40);
            getRecordBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            getRecordBtn.addActionListener(this);
            informationPanel.add(getRecordBtn);
            
            editRecordBtn = new JButton("Edit Client Record");
            editRecordBtn.setBounds(440, 340, 140, 40);
            editRecordBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            informationPanel.add(editRecordBtn);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == getRecordBtn){
            new GetClient();
        }
        
    }

}

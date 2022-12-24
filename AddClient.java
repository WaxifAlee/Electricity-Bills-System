import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClient extends JFrame implements ActionListener {

    private JLabel  firstNameLbl, lastNameLbl, userNameLbl, passwordLbl, 
                    cnicLbl, phoneLbl, addressLbl, dojLbl, dobLbl, 
                    genderLbl, noOfBillsLbl;
   
    private JTextField firstNameTxt, lastNameTxt, userNameTxt, cnicTxt, phoneTxt,
                       addressTxt, dojTxt, dobTxt, genderTxt, noOfBillsTxt;
    private JPasswordField passwordTxt; 

    private JButton saveBtn;

    public AddClient(){

        super("Add a new client");

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel infoLbl = new JLabel(" Register a new client");
        infoLbl.setBounds(20, 10, 200, 30);
        infoLbl.setFont(new Font("Arial", Font.BOLD, 18));
        infoLbl.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        panel.add(infoLbl);

        firstNameLbl = new JLabel("First Name: ");
        firstNameLbl.setBounds(20, 42, 80, 30);
        panel.add(firstNameLbl);

        firstNameTxt = new JTextField();
        firstNameTxt.setBounds(100, 47, 120, 25);
        panel.add(firstNameTxt);

        lastNameLbl = new JLabel("Last Name: ");
        lastNameLbl.setBounds(230, 42, 70, 30);
        panel.add(lastNameLbl);

        lastNameTxt = new JTextField(12);
        lastNameTxt.setBounds(305, 47, 120, 25);
        panel.add(lastNameTxt);

        userNameLbl = new JLabel("Username: ");
        userNameLbl.setBounds(20, 80, 120, 30);
        panel.add(userNameLbl);

        userNameTxt = new JTextField(12);
        userNameTxt.setBounds(100, 85, 120, 25);
        panel.add(userNameTxt);

        passwordLbl = new JLabel("Password: ");
        passwordLbl.setBounds(230, 85, 120, 25);
        panel.add(passwordLbl);

        passwordTxt = new JPasswordField(12);
        passwordTxt.setBounds(305, 85, 120, 25);
        panel.add(passwordTxt);

        cnicLbl = new JLabel("CNIC: ");
        cnicLbl.setBounds(20, 120, 120, 25);
        panel.add(cnicLbl);
        
        cnicTxt = new JTextField(15);
        cnicTxt.setBounds(100, 120, 120, 25);
        panel.add(cnicTxt);

        phoneLbl = new JLabel("Phone: ");
        phoneLbl.setBounds(230, 120, 120, 25);
        panel.add(phoneLbl);

        phoneTxt = new JTextField(14);
        phoneTxt.setBounds(305, 120, 120, 25);
        panel.add(phoneTxt);

        addressLbl = new JLabel("Full Address: ");
        addressLbl.setBounds(20, 155, 120, 25);
        panel.add(addressLbl);

        addressTxt = new JTextField(30);
        addressTxt.setBounds(100, 155, 325, 25);
        panel.add(addressTxt);

        dojLbl = new JLabel("Joining Date: ");
        dojLbl.setBounds(20, 190, 120, 25);
        panel.add(dojLbl);

        dojTxt = new JTextField(10);
        dojTxt.setBounds(100, 190, 120, 25);
        panel.add(dojTxt);

        dobLbl = new JLabel("Date of Birth:  ");
        dobLbl.setBounds(230, 190, 120, 25);
        panel.add(dobLbl);

        dobTxt = new JTextField(10);
        dobTxt.setBounds(307, 190, 118, 25);
        panel.add(dobTxt);

        genderLbl = new JLabel("Gender: ");
        genderLbl.setBounds(20, 225, 120, 25);
        panel.add(genderLbl);

        genderTxt = new JTextField(14);
        genderTxt.setBounds(100, 225, 120,25);
        panel.add(genderTxt);

        noOfBillsLbl = new JLabel("Total Bills: ");
        noOfBillsLbl.setBounds(230, 225, 120, 25);
        panel.add(noOfBillsLbl);

        noOfBillsTxt = new JTextField("0", 11);
        noOfBillsTxt.setBounds(305, 225, 120, 25);
        panel.add(noOfBillsTxt);

        saveBtn = new JButton("SAVE");
        saveBtn.setBounds(190, 280, 120, 30);
        saveBtn.setCursor(new Cursor( Cursor.HAND_CURSOR ));
        panel.add(saveBtn);

        setResizable(false);
        setSize(460, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
    }

    public static void main(String[] args){
        new AddClient();
    }



}

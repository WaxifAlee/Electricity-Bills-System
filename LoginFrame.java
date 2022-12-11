import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame implements ActionListener {

    private JFrame frame;
    private JPanel mainPanel;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel successOrFail;

    public LoginFrame() {
        frame = new JFrame(" LOGIN PAGE ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setSize(350, 200);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(10, 20, 80, 25);
        usernameField = new JTextField();
        usernameField.setBounds(100, 20, 165, 25);
        usernameField.setColumns(15);

        passwordLabel = new JLabel("\nPassword");
        passwordLabel.setBounds(10, 50, 80, 25);
        passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 165, 25);
        passwordField.setColumns(15);

        loginButton = new JButton("Login");
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.setBounds(135, 85, 80, 25);
        loginButton.addActionListener(this);

        successOrFail = new JLabel(" ");
        successOrFail.setBounds(10, 100, 80, 25);

        mainPanel.add(usernameLabel);
        mainPanel.add(usernameField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(loginButton);
        mainPanel.add(successOrFail);

        frame.add(mainPanel);
        frame.setVisible(true);

    }

    public boolean authenticateCredentials(){
        String username = usernameField.getText();
        char[] passwordArr = passwordField.getPassword();
        String password = new String(passwordArr);
        boolean success = false;
        if(username.equals("") || password.equals("")){
            JOptionPane.showMessageDialog(frame, "Username and Password must not be empty");
            return false;
        } else{
            try {
                File dataFile = new File("./login_credentials/"+username+".txt");
                Scanner fileReader = new Scanner(dataFile);
                String originalPassword = fileReader.nextLine(); 
                fileReader.close();
                if(originalPassword.equals(password)){
                    success = true;
                } else {
                    JOptionPane.showMessageDialog(frame, "Incorrect Password");
                }
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(frame, "User not found!", "Error", 3);
            }
        }
        return success;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton){
           if(authenticateCredentials()){
            new Dashboard(usernameField.getText());
            frame.dispose();
           }
        }
    }
}
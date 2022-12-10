import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {

    JPanel container = new JPanel();

    JLabel lblName = new JLabel("Username: ");
    JTextField txtUsrName = new JTextField();
    JLabel lblPswd = new JLabel("Password: ");
    JPasswordField txtPassword = new JPasswordField();

    public LoginFrame() {
        super("LOGIN FORM");
        setAlwaysOnTop(true);
        setSize(new Dimension(320, 320));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        add(container);
        container.add(lblName);
        txtUsrName.setSize(40, 10);
        container.add(txtUsrName);
        container.add(lblPswd);
        txtPassword.setSize(40, 10);
        container.add(txtPassword);

        setVisible(true);
    }

}
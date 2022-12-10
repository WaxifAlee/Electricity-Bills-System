import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dashboard {
    
    private JFrame frame;
    private JPanel panel;
    
    public Dashboard(String username, String password){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}

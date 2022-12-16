import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetClient extends JFrame implements ActionListener {

    private JCheckBox billsCB;
    private JCheckBox personalInfoCB;

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

        // Grouping the checkboxes to make only one of them selectable at once

        ButtonGroup btnGroup = new ButtonGroup();

        // Creating the checkBoxes
        billsCB = new JCheckBox("Bills information");
        billsCB.setBounds(10, 20, 140, 25);
        billsCB.addActionListener(this);

        personalInfoCB = new JCheckBox("Client Information");
        personalInfoCB.setBounds(10, 50, 140, 25);
        personalInfoCB.addActionListener(this);
        
        // Adding the checkboxes to group

        btnGroup.add(billsCB);
        btnGroup.add(personalInfoCB);

        // Adding the checkBoxes to the panel

        panel.add(billsCB);
        panel.add(personalInfoCB);
    
        // Adding the panel to frame
        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == billsCB){
            System.out.println("Bills information");
        } else if(e.getSource() == personalInfoCB){
            System.out.println("Client Information");
        }
        
    }
    
}

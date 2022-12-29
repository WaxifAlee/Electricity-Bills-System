import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;

public class GenerateBill extends JFrame implements ActionListener {

    JLabel accessionIdLabel;
    JTextField accessionIdField;

    JLabel generatedToLabel;
    JTextField generatedToField;

    JLabel pricePerUnitLabel;
    JTextField pricePerUnitField;

    JLabel totalUnitsLabel;
    JTextField totalUnitsField;

    JLabel dateLabel;
    JTextField dateField;

    JLabel totalPriceLabel;
    JTextField totalPriceField;

    JCheckBox paidCheck;

    JButton generateBtn;

    public GenerateBill() {

        super("Generate Bills");

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel topLabel = new JLabel("               Generate a Bill");
        topLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        topLabel.setBounds(120, 20, 350, 40);
        topLabel.setFont(new Font("serif", Font.BOLD, 24));
        panel.add(topLabel);

        // Creating the necessary screen components
        accessionIdLabel = new JLabel("Accession Id: ");
        accessionIdLabel.setBounds(60, 100, 100, 20);
        accessionIdField = new JTextField(12);
        accessionIdField.setBounds(150, 100, 150, 20);

        generatedToLabel = new JLabel("Generated To: ");
        generatedToLabel.setBounds(330, 100, 100, 20);
        generatedToField = new JTextField(12);
        generatedToField.setBounds(420, 100, 150, 20);

        pricePerUnitLabel = new JLabel("Price per unit: ");
        pricePerUnitLabel.setBounds(60, 140, 100, 20);
        pricePerUnitField = new JTextField(12);
        pricePerUnitField.setBounds(150, 140, 150, 20);

        totalUnitsLabel = new JLabel("Total Units: ");
        totalUnitsLabel.setBounds(330, 140, 100, 20);
        totalUnitsField = new JTextField(12);
        totalUnitsField.setBounds(420, 140, 150, 20);

        totalPriceLabel = new JLabel("Total: ");
        totalPriceLabel.setBounds(60, 180, 100, 20);
        totalPriceField = new JTextField(12);
        totalPriceField.setBounds(150, 180, 150, 20);
        totalPriceField.setEditable(false);

        dateLabel = new JLabel("Date: ");
        dateLabel.setBounds(330, 180, 100, 20);
        dateField = new JTextField(new Date().toString(), 12);
        dateField.setBounds(420, 180, 150, 20);

        paidCheck = new JCheckBox("Paid");
        paidCheck.setBounds(60, 210, 120, 20);

        generateBtn = new JButton("Generate");
        generateBtn.setBounds(280, 230, 100, 30);
        generateBtn.addActionListener(this);

        // Adding components to the panel
        panel.add(accessionIdLabel);
        panel.add(accessionIdField);

        panel.add(generatedToLabel);
        panel.add(generatedToField);

        panel.add(pricePerUnitLabel);
        panel.add(pricePerUnitField);

        panel.add(totalUnitsLabel);
        panel.add(totalUnitsField);

        panel.add(totalPriceLabel);
        panel.add(totalPriceField);

        panel.add(dateLabel);
        panel.add(dateField);

        panel.add(paidCheck);

        panel.add(generateBtn);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(panel);
        setSize(640, 320);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == generateBtn) {
            String accessionId = accessionIdField.getText();
            String generatedTo = generatedToField.getText();
            double pricePerUnit = Double.parseDouble(pricePerUnitField.getText());
            int totalUnits = Integer.parseInt(totalUnitsField.getText());
            double totalPrice = pricePerUnit * totalUnits;
            String date = dateField.getText();
            boolean isPaid = paidCheck.isSelected();

            totalPriceField.setText(Double.toString(totalPrice));

            Bill bill = new Bill(accessionId, generatedTo, pricePerUnit, totalUnits, totalPrice, date, isPaid);
            try {
                bill.save();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }

    }

}

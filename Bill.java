import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Bill {
    private String accessionId;
    private String generatedTo;
    private double pricePerUnit;
    private int totalUnits;
    private double totalPrice;
    private String date;
    private boolean paid;

    public Bill(String aId, String genTo, double ppu,
            int tu, double tp, String date, boolean paid) {
        accessionId = aId;
        generatedTo = genTo;
        pricePerUnit = ppu;
        totalUnits = tu;
        totalPrice = tp;
        this.date = date;
        this.paid = paid;
    }

    public void save() throws IOException {

        File clientFile = new File("./login_credentials/" + this.generatedTo + ".txt");

        if (clientFile.exists()) {
            File billFile = new File("./bills/" + accessionId + ".txt");

            if (billFile.exists()) {
                JOptionPane.showMessageDialog(new JFrame(), "Accession ID already exists!");
            } else {
                clientFile.createNewFile();
                FileWriter writer = new FileWriter(billFile);
                writer.write(accessionId + "\n");
                writer.write(generatedTo + "\n");
                writer.write(pricePerUnit + "\n");
                writer.write(totalUnits + "\n");
                writer.write(totalPrice + "\n");
                writer.write(date + "\n");
                writer.write(paid ? "paid" : "unpaid" + "\n");
                writer.close();
                JOptionPane.showMessageDialog(null, "Success!");
            }

        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Client is not registered!");
        }

    }

}

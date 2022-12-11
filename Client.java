public class Client extends Person{
    
    private String dateOfJoining;
    private int numberOfBillsGenerated;
    
    public Client(){}

    public Client(String fName, String lName, String nic,
                  String contactNumber, String dob, String adrs,
                  String gender, String doj, int billsGenerated) {
        
        // Calling the super constructor function
        super(fName, lName, nic, contactNumber, dob, adrs, gender);

        dateOfJoining = doj;
        numberOfBillsGenerated = billsGenerated;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }
    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
    public int getNumberOfBillsGenerated() {
        return numberOfBillsGenerated;
    }
    public void setNumberOfBillsGenerated(int numberOfBillsGenerated) {
        this.numberOfBillsGenerated = numberOfBillsGenerated;
    }
}

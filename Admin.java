public class Admin extends Person {
    
    private String dateOfJoining;
    public Admin(){}

    public Admin(String fName, String lName, String nic, String contactNumber, String dob, String adrs, String gender, String doj){
        super(fName, lName, nic, contactNumber, dob, adrs, gender);
        dateOfJoining = doj;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }
    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

}

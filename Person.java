public class Person {
    
    private String firstName, lastName, cnic, contactNumber, address;
    private char gender;
    
    public Person(){}
    public Person(String fName, String lName, String nic, String contactNumber, String adrs, char gender){
        firstName = fName;
        lastName = lName;
        cnic = nic;
        this.contactNumber = contactNumber;
        address = adrs;
        this.gender = gender;
    }

    // Getters and Setters for all the private data members of the class

    public String getAddress() {
        return address;
    }
    public String getCnic() {
        return cnic;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCnic(String cnic) {
        this.cnic = cnic;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFullName(){
        return this.firstName+" "+this.lastName;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public char getGender() {
        return gender;
    }

    // Greet method to get a String saying hello along with the user name
    public String greetUser(){
        String greetings = gender == 'M' ? "Welcome Mr. " : "Welcome Mrs. ";
        return greetings + getFullName();
    }


}

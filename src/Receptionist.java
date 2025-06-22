public class Receptionist {
    private int receptionistID;
    private String name;
    private String email;
    private String phone;

    public Receptionist(int receptionistID, String name, String email, String phone) {
        this.receptionistID = receptionistID;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getReceptionistID() {
        return receptionistID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}

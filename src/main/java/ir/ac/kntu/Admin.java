package ir.ac.kntu;

public class Admin extends Person {
    private String accesslvl;

    public Admin(String username, String password, String email, String phoneNumber) {
        super(username, password, email, phoneNumber);
        accesslvl = "a";
    }

    public String getAccesslvl() {
        return accesslvl;
    }
}

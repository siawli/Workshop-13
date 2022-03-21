package W13.W13.demo113.models;

import java.util.Random;

public class Contact {
    private String name;
    private String email;
    private String phoneNumber;
    private String id;

    public Contact(String name, String email, String phoneNo) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNo;
        this.id = generateId(8);
    }

    public Contact(String id, String name, String email, String phoneNo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNo;
    }

    public Contact() {
        this.id = generateId(8);
    }

    public synchronized String generateId(int numChars) {
        StringBuilder strBuilder = new StringBuilder();
        Random r = new Random();
        while (strBuilder.length() < numChars) {
            strBuilder.append(Integer.toHexString(r.nextInt()));
        }
        return strBuilder.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
}

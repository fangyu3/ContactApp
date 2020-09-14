package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        setPhoneNumber(phoneNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (validatePhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
            return;
        }
        System.out.println("Wrong number format!");
        this.phoneNumber = "[no number]";
        return;
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        String phoneRegex = "(\\+?(\\(\\w{1,}\\)|\\w{1,})([\\s-]\\w{2,})*|\\+?\\w{1,}[\\s-]\\(\\w{2,}\\)([\\s-]\\w{2,})*)";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    @Override
    public String toString() {
        return  firstName + " " + lastName + ", " + phoneNumber;
    }
}

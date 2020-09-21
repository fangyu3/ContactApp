package contacts;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public abstract class Contact {

    public static List<Contact> entries = new ArrayList<>();;
    protected String phoneNumber;
    protected LocalDateTime dateCreated;
    protected LocalDateTime dateLastModified;

    public static enum Field {
        NUMBER,BIRTH,GENDER,ADDRESS,NAME,SURNAME
    }

    public Contact(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        dateCreated = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        dateLastModified = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public void add() {
        entries.add(this);
    }

    public void update(String field, String newValue) {
        dateLastModified = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
    };

    public abstract void getInfo();

    public static void remove(int idx) {
        entries.remove(idx);
    }

    public static void listEntries() {
        int rowNum = 1;
        for (Contact entry:entries) {
            System.out.println(rowNum + ". " + entry);
            rowNum++;
        }
    };

}

package contacts.contact;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Contact implements Serializable {

    public static List<Contact> entries;
    protected String phoneNumber;
    protected LocalDateTime dateCreated;
    protected LocalDateTime dateLastModified;
    private static final long serialVersionUID = 1L;
    protected String searchId;

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

    public String getSearchId() {
        return searchId;
    }

    public static void setContactList(Contact[] contacts) {
        entries = new ArrayList<>();

        if(contacts != null) {
            for(Contact entry:contacts) {
                entries.add(entry);
            }
        }
    }

    public void add() {
        entries.add(this);
    }

    public void update(String field, String newValue) {
        dateLastModified = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
    };

    public abstract void getInfo();

    public static void remove(Contact contact) {
        entries.remove(contact);
    }

    public static void listEntries() {
        int rowNum = 1;
        for (Contact entry:entries) {
            System.out.println(rowNum + ". " + entry);
            rowNum++;
        }
    }

    public static List<Contact> searchContactList(String query) {
        Pattern pattern = Pattern.compile(".*" + query + ".*",Pattern.CASE_INSENSITIVE);
        Matcher matcher = null;
        List<Contact> result = new ArrayList<>();

        for(Contact e:entries) {
            matcher = pattern.matcher(e.getSearchId());
            if(matcher.find()) {
                result.add(e);
            }
        }

        return result;
    }

}

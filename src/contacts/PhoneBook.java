package contacts;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private List<Contact> contactList;

    public PhoneBook() {
        this.contactList = new ArrayList<>();
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }
}

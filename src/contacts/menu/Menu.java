package contacts.menu;

import contacts.PhoneBook;
import contacts.contact.Contact;
import contacts.contact.Organization;
import contacts.contact.Person;

import java.util.List;
import java.util.Scanner;

public abstract class Menu {
    protected static Scanner scanner;
    public abstract void display();
    protected static Contact currContact;

    static {
        scanner = new Scanner(System.in);
        currContact = null;
    }

    protected enum Action{

        // Main menu
        ADD,
        LIST,
        SEARCH,
        COUNT,
        EXIT,

        // Search menu
        BACK,
        AGAIN,
        INFO,

        // Record menu
        EDIT,
        DELETE,
        MENU
    }

    public void showContactInfo(int idx) {
        currContact = Contact.entries.get(idx);
        currContact.getInfo();
    }

    public void searchContact() {
        System.out.print("Enter search query: ");
        String query = scanner.nextLine();
        List<Contact> searchResult = Contact.searchContactList(query);

        System.out.println("Found " + searchResult.size() +  " results: ");

        for(int rowNum=1; rowNum<=searchResult.size(); rowNum++ ) {
            Contact contact = searchResult.get(rowNum-1);
            String name = contact instanceof Person ? ((Person)contact).toString()
                                                    :((Organization)contact).toString();
            System.out.println(rowNum + ". " + name);
        }
    }

    public void exitApp() {
        PhoneBook.appExit = true;
    }
}

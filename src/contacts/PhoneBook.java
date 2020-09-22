package contacts;

import contacts.contact.Contact;
import contacts.menu.*;

import java.io.IOException;

public class PhoneBook {

    public static MenuOption currMenu;
    public static Boolean appExit;
    private static Menu mainMenu;
    private static Menu searchMenu;
    private static Menu recordMenu;
    private static Menu listMenu;


    public static enum MenuOption {
        MAIN,
        SEARCH,
        RECORD,
        LIST
    }

    static {
        currMenu = MenuOption.MAIN;
        appExit = false;
        mainMenu = new MainMenu();
        searchMenu = new SearchMenu();
        recordMenu = new RecordMenu();
        listMenu = new ListMenu();
    }

    public static void startApp(String fileName) {

        try {
            // Load contacts from file
            Contact.setContactList((Contact[])(Utility.deserialize(fileName)));

            while (!appExit) {
                switch(currMenu) {
                    case MAIN:
                        mainMenu.display();
                        break;
                    case SEARCH:
                        searchMenu.display();
                        break;
                    case RECORD:
                        recordMenu.display();
                        break;
                    case LIST:
                        listMenu.display();
                        break;
                }
                System.out.println();
            }

            // Save contacts to file
            Contact[] contactArr = new Contact[Contact.entries.size()];
            contactArr = Contact.entries.toArray(contactArr);
            Utility.serialize(contactArr,fileName);
        }
        catch(IOException|ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

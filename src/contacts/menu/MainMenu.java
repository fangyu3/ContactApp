package contacts.menu;

import contacts.FieldValidator;
import contacts.PhoneBook;
import contacts.contact.Contact;
import contacts.contact.Organization;
import contacts.contact.Person;

public class MainMenu extends Menu{

    @Override
    public void display() {

        try {
            System.out.print("[menu] Enter action (add, list, search, count, exit): ");
            Action currAction = Action.valueOf(scanner.nextLine().toUpperCase());
            switch (currAction) {
                case ADD:
                    addContact();
                    break;
                case LIST:
                    PhoneBook.currMenu = PhoneBook.MenuOption.LIST;
                    Contact.listEntries();
                    break;
                case SEARCH:
                    PhoneBook.currMenu = PhoneBook.MenuOption.SEARCH;
                    searchContact();
                    break;
                case COUNT:
                    System.out.println("The Phone Book has " + Contact.entries.size() + " records.");
                    break;
                case EXIT:
                    exitApp();
                    break;
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("Please enter valid command.");
            PhoneBook.appExit = true;
        }
    }

    public void addContact() {
        System.out.print("Enter the type (person, organization): ");
        String type = scanner.nextLine();

        if (type.equals("person")) {
            System.out.print("Enter the name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter the surname: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter the birth date: ");
            String birthday = scanner.nextLine();
            birthday = FieldValidator.validateField("birth",birthday)?birthday:"[no data]";

            System.out.print("Enter the gender (M, F): ");
            String gender = scanner.nextLine();
            gender = FieldValidator.validateField("gender",gender)?gender:"[no data]";

            System.out.print("Enter the number: ");
            String phoneNumber = scanner.nextLine();
            phoneNumber = FieldValidator.validateField("number",phoneNumber)?phoneNumber:"[no number]";

            Contact person = new Person(firstName,lastName,birthday,gender,phoneNumber);
            person.add();
        }
        else if (type.equals("organization")) {
            System.out.print("Enter the organization name: ");
            String orgName = scanner.nextLine();

            System.out.print("Enter the address: ");
            String address = scanner.nextLine();

            System.out.print("Enter the number: ");
            String phoneNumber = scanner.nextLine();
            phoneNumber = FieldValidator.validateField("number",phoneNumber)?phoneNumber:"[no number]";

            Contact organization = new Organization(orgName,address,phoneNumber);
            organization.add();
        }

        System.out.println("The record added");
    }
}

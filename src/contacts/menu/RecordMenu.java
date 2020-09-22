package contacts.menu;

import contacts.FieldValidator;
import contacts.PhoneBook;
import contacts.contact.Contact;
import contacts.contact.Organization;
import contacts.contact.Person;

public class RecordMenu extends Menu{
    @Override
    public void display() {
        System.out.print("[record] Enter action (edit, delete, menu): ");
        Action currAction = Action.valueOf(scanner.nextLine().toUpperCase());

        switch(currAction) {
            case EDIT:
                editContact();
                break;
            case DELETE:
                removeContact();
                break;
            case MENU:
                PhoneBook.currMenu = PhoneBook.MenuOption.MAIN;
                break;
        }
    }

    public void removeContact() {

        Contact.remove(currContact);

        System.out.println("The record removed!");
    }

    public void editContact() {

        if (currContact instanceof Person) {
            System.out.print("Select a field (name, surname, birth, gender, number): ");
            String field = scanner.nextLine();

            System.out.print("Enter " + field + ": ");
            String value = scanner.nextLine();

            if (!FieldValidator.validateField(field,value)) {
                if (field.equals("number"))
                    value = "[no number]";
                else
                    value = "[no data]";
            }

            currContact.update(field,value);
        }
        else if (currContact instanceof Organization) {
            System.out.print("Select a field (name, address, number): ");
            String field = scanner.nextLine();

            System.out.print("Enter " + field + ": ");
            String value = scanner.nextLine();

            if (!FieldValidator.validateField(field,value)) {
                if (field.equals("number"))
                    value = "[no number]";
                else
                    value = "[no data]";
            }

            currContact.update(field,value);
        }
        System.out.println("Saved");
    }


}

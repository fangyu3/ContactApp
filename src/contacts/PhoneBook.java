package contacts;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PhoneBook {

    private Scanner scanner;

    private Action currAction;

    private enum Action{
        ADD,REMOVE,EDIT,COUNT,INFO,EXIT
    };

    public PhoneBook() {
        this.scanner = new Scanner(System.in);
        this.currAction = null;
    }

    public void startApp() {

        while (currAction == null || !currAction.name().equals("EXIT")) {
            System.out.print("Enter action (add, remove, edit, count, info, exit): ");
            currAction = Action.valueOf(scanner.nextLine().toUpperCase());
            switch(currAction) {
                case ADD:
                    addContact();
                    break;
                case REMOVE:
                    removeContact();
                    break;
                case EDIT:
                    editContact();
                    break;
                case COUNT:
                    System.out.println("The Phone Book has " + Contact.entries.size() + " records.");
                    break;
                case INFO:
                    showContactInfo();
                    break;
            }
            System.out.println();
        }
        scanner.close();
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


    public void removeContact() {

        try {
            Contact.listEntries();

            System.out.print("Select a record: ");
            int rowNum = scanner.nextInt();
            scanner.nextLine();

            Contact.remove(rowNum - 1);

            System.out.println("The record removed!");
        }
        catch (InputMismatchException e) {
            System.out.println("No records to remove");
            currAction = Action.EXIT;
        }
    }

    public void editContact() {

        try {
            Contact.listEntries();

            System.out.print("Select a record: ");
            int rowNum = scanner.nextInt();
            scanner.nextLine();

            Contact contact = Contact.entries.get(rowNum - 1);

            if (contact instanceof Person) {
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

                contact.update(field,value);
            }
            else if (contact instanceof Organization) {
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

                contact.update(field,value);
            }
            System.out.println("The record updated!");
        }
        catch (InputMismatchException e) {
            System.out.println("No records to edit");
            currAction = Action.EXIT;
        }
    }

    public void showContactInfo() {
        Contact.listEntries();

        System.out.print("Enter index to show info: ");
        int idx = scanner.nextInt()-1;
        scanner.nextLine();

        Contact contact = Contact.entries.get(idx);
        contact.getInfo();
    }
}

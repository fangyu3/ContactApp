package contacts;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {

    private Scanner scanner;

    private List<Contact> contactList;

    private String action;

    public PhoneBook() {
        this.scanner = new Scanner(System.in);
        this.contactList = new ArrayList<>();
        this.action = "";
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public void startApp() {

        while (!action.equals("exit")) {
            System.out.print("Enter action (add, remove, edit, count, list, exit): ");
            action = scanner.nextLine();
            switch(action) {
                case "add":
                    addContact();
                    break;
                case "remove":
                    removeContact();
                    break;
                case "edit":
                    editContact();
                    break;
                case "count":
                    int numEntries = countContact();
                    System.out.println("The Phone Book has " + numEntries + " records.");
                    break;
                case "list":
                    listContact();
                    break;
            }
        }
        scanner.close();
    }

    public void addContact() {
        System.out.print("Enter the name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter the surname: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter the number: ");
        String phoneNumber = scanner.nextLine();

        contactList.add(new Contact(firstName,lastName,phoneNumber));

        System.out.println("The record added");
    }

    public void removeContact() {

        try {
            listContact();

            System.out.print("Select a record: ");
            int rowNum = scanner.nextInt();
            scanner.nextLine();

            contactList.remove(rowNum - 1);

            System.out.println("The record removed!");
        }
        catch (InputMismatchException e) {
            System.out.println("No records to remove");
            action = "exit";
        }
    }

    public void editContact() {

        try {
            listContact();

            System.out.print("Select a record: ");
            int rowNum = scanner.nextInt();
            scanner.nextLine();

            Contact contact = contactList.get(rowNum - 1);

            System.out.print("Select a field (name, surname, number): ");
            String field = scanner.nextLine();

            System.out.print("Enter " + field + ": ");
            String value = scanner.nextLine();

            switch (field) {
                case "name":
                    contact.setFirstName(value);
                    break;
                case "surname":
                    contact.setLastName(value);
                    break;
                case "number":
                    contact.setPhoneNumber(value);
                    break;
            }
            System.out.println("The record updated!");
        }
        catch (InputMismatchException e) {
            System.out.println("No records to edit");
            action = "exit";
        }
    }

    public void listContact() {

        int rowNum = 1;
        for (Contact contact:contactList) {
            System.out.println(rowNum + ". " + contact);
            rowNum++;
        }
    }

    public int countContact() {
        return contactList.size();
    }
}

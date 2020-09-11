package contacts;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook myPhoneBook = new PhoneBook();

        System.out.println("Enter the name of the person:");
        String firstName = scanner.nextLine();

        System.out.println("Enter the surname of the person:");
        String lastName = scanner.nextLine();

        System.out.println("Enter the number:");
        String phoneNumber = scanner.nextLine();

        myPhoneBook.getContactList().add(new Contact(firstName,lastName,phoneNumber));

        System.out.println("A record created!");
        System.out.println("A Phone Book with a single record created!");
    }
}

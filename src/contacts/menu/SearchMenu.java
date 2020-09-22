package contacts.menu;

import contacts.PhoneBook;

public class SearchMenu extends Menu{

    @Override
    public void display() {
        System.out.print("[search] Enter action ([number], back, again): ");
        int rowNum = -1;
        Action currAction = null;
        if (scanner.hasNextInt()) {
            rowNum = scanner.nextInt();
            scanner.nextLine();
            currAction = Action.INFO;
        }
        else
            currAction = Action.valueOf(scanner.nextLine().toUpperCase());

        switch(currAction) {
            case BACK:
                PhoneBook.currMenu = PhoneBook.MenuOption.MAIN;
                break;
            case AGAIN:
                searchContact();
                break;
            case INFO:
                PhoneBook.currMenu = PhoneBook.MenuOption.RECORD;
                showContactInfo(rowNum-1);
                break;
        }
    }
}

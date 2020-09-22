package contacts.menu;

import contacts.PhoneBook;

public class ListMenu extends Menu{
    @Override
    public void display() {
        System.out.print("[list] Enter action ([number], back): ");
        Action currAction = null;
        int rowNum = -1;
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
            case INFO:
                PhoneBook.currMenu = PhoneBook.MenuOption.RECORD;
                showContactInfo(rowNum-1);
                break;
        }
    }
}

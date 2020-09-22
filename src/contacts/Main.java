package contacts;

public class Main {
    public static void main(String[] args) {
        String fileName = args.length==0?null:args[0];

        System.out.println(fileName);
        PhoneBook.startApp(fileName);
    }
}

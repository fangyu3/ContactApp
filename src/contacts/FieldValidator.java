package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldValidator {

    public static boolean validateField(String fieldToValidate, String value) {
        Contact.Field field = Contact.Field.valueOf(fieldToValidate.toUpperCase());
        switch(field) {
            case NUMBER:
                return validatePhoneNumber(value);
            case BIRTH:
                return validateBirthday(value);
            case GENDER:
                return validateGender(value);
        }
        return true;
    }

    private static boolean validatePhoneNumber(String phoneNumber) {
        String phoneRegex = "(\\+?(\\(\\w{1,}\\)|\\w{1,})([\\s-]\\w{2,})*|\\+?\\w{1,}[\\s-]\\(\\w{2,}\\)([\\s-]\\w{2,})*)";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);

        if (!matcher.matches()) {
            System.out.println("Wrong number format!");
            return false;
        }

        return true;
    }

    private static boolean validateBirthday(String birthday) {

        if (birthday.length()==0) {
            System.out.println("Bad birth date!");
            return false;
        }

        return true;
    }

    private static boolean validateGender(String gender) {

        if (gender.length()==0) {
            System.out.println("Bad gender!");
            return false;
        }

        return true;
    }
}

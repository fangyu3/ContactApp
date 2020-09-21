package contacts;

public class Person extends Contact{

    private String firstName;
    private String lastName;
    private String birthday;
    private String gender;

    public Person (String firstName,String lastName,String birthday,String gender,String phoneNumber) {
        super(phoneNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        setBirthday(birthday);
        setGender(gender);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void update(String field, String newValue) {
        super.update(field,newValue);

        switch(field) {
            case "name":
                setFirstName(newValue);
                break;
            case "surname":
                setLastName(newValue);
                break;
            case "birth":
                setBirthday(newValue);
                break;
            case "gender":
                setGender(newValue);
                break;
            case "number":
                setPhoneNumber(newValue);
                break;
        }
    }

    public void getInfo() {
        System.out.println("Name: " + firstName + "\n" +
                            "Surname: " + lastName + "\n" +
                            "Birth date: " + birthday + "\n" +
                            "Gender: " + gender + "\n" +
                            "Number: " + phoneNumber + "\n" +
                            "Time created: " + dateCreated + "\n" +
                            "Time last edit: " + dateLastModified);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

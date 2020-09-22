package contacts.contact;

public class Organization extends Contact {
    private String name;
    private String address;
    private static final long serialVersionUID = 1L;

    public Organization(String name, String address, String phoneNumber) {
        super(phoneNumber);
        this.name = name;
        this.address = address;
        this.searchId = name + " " + address + " " + phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void update(String field, String newValue) {
        super.update(field,newValue);
        switch(field) {
            case "name":
                setName(newValue);
                break;
            case "address":
                setAddress(newValue);
                break;
            case "number":
                setPhoneNumber(newValue);
                break;
        }
    }

    public void getInfo() {
        System.out.println("Organization name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Number: " + phoneNumber + "\n" +
                "Time created: " + dateCreated + "\n" +
                "Time last edit: " + dateLastModified);
    }

    @Override
    public String toString() {
        return name;
    }
}

package volodymyr.groupexpense.expense.domain.vo;

import volodymyr.groupexpense.expense.domain.exceptions.InvalidGroupNameException;

public class NamePayer {

    private String firstName;
    private String lastName;

    private NamePayer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static NamePayer createParticipantName(String firstName, String lastName) {
        if (firstName == null || lastName == null || firstName.length() < 3) {
            throw new InvalidGroupNameException(firstName);
        }
        return new NamePayer(firstName, lastName);
    }

    public String fullName() {
        return firstName.concat(lastName);
    }
}

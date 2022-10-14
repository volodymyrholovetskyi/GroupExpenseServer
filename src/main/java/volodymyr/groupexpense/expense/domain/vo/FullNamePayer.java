package volodymyr.groupexpense.expense.domain.vo;

import volodymyr.groupexpense.expense.domain.exceptions.InvalidGroupNameException;

public class FullNamePayer {

    private String firstName;
    private String lastName;

    public FullNamePayer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static FullNamePayer createParticipantName(String firstName, String lastName) {
        if (firstName == null || lastName == null || firstName.length() < 3) {
            throw new InvalidGroupNameException(firstName);
        }
        return new FullNamePayer(firstName, lastName);
    }

    public String fullName() {
        return firstName.concat(lastName);
    }
}

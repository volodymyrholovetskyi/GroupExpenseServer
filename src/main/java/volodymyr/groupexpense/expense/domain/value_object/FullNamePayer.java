package volodymyr.groupexpense.expense.domain.value_object;

import lombok.EqualsAndHashCode;
import volodymyr.groupexpense.expense.domain.exceptions.InvalidGroupDescriptionException;
@EqualsAndHashCode

public class FullNamePayer {

    private String firstName;
    private String lastName;

    public FullNamePayer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static FullNamePayer ofFullName(String firstName, String lastName) {
        if (firstName == null || lastName == null || firstName.length() < 3) {
            throw new InvalidGroupDescriptionException(firstName);
        }
        return new FullNamePayer(firstName, lastName);
    }

    public String fullName() {
        return firstName.concat(lastName);
    }
}
